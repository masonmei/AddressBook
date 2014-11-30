package org.personal.mason.addressbook.web;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.personal.mason.addressbook.app.command.*;
import org.personal.mason.addressbook.app.entry.AddressEntry;
import org.personal.mason.addressbook.app.entry.ContactEntry;
import org.personal.mason.addressbook.app.query.ContactNameRepository;
import org.personal.mason.addressbook.app.query.ContactRepository;
import org.personal.mason.addressbook.app.type.AddressType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Jettro Coenradie
 */
@Controller
@RequestMapping(value = "/contacts")
public class ContactsController {
    private final static Logger logger = LoggerFactory.getLogger(ContactsController.class);

    @Autowired
    private ContactRepository repository;

    @Autowired
    private ContactNameRepository contactNameRepository;

    @Autowired
    private CommandBus commandBus;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("contacts", repository.findAllContacts());
        return "contacts/list";
    }

    @RequestMapping(value = "{identifier}", method = RequestMethod.GET)
    public String details(@PathVariable String identifier, Model model) {
        List<AddressEntry> addressesForContact = repository.findAllAddressesForContact(identifier);
        String name;
        if (addressesForContact.size() > 0) {
            name = addressesForContact.get(0).getName();
        } else {
            name = repository.loadContactDetails(identifier).getName();
        }
        model.addAttribute("addresses", addressesForContact);
        model.addAttribute("identifier", identifier);
        model.addAttribute("name", name);
        return "contacts/details";
    }

    @RequestMapping(value = "{identifier}/edit", method = RequestMethod.GET)
    public String formEdit(@PathVariable String identifier, Model model) {
        ContactEntry contactEntry = repository.loadContactDetails(identifier);
        model.addAttribute("contact", contactEntry);
        return "contacts/edit";
    }

    @RequestMapping(value = "{identifier}/edit", method = RequestMethod.POST)
    public String formEditSubmit(@ModelAttribute("contact") @Valid ContactEntry contact, BindingResult bindingResult) {
        // beware, we cannot support other updates since that would always give an error when the name is not changed
        if (contactHasErrors(contact, bindingResult)) {
            return "contacts/edit";
        }

        ChangeContactNameCommand command = new ChangeContactNameCommand(
                contact.getIdentifier(),
                contact.getName()
        );

        commandBus.dispatch(new GenericCommandMessage<Object>(command));

        return "contacts/edit";

    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String formNew(Model model) {
        ContactEntry attributeValue = new ContactEntry();
        model.addAttribute("contact", attributeValue);
        return "contacts/new";
    }

    /**
     * If we submit a new contact, we want immediate feedback if the contact could be added. If it could not be added
     * we want an error. Therefore we use the Future callback mechanism as provide by Axon.
     *
     * @param contact       ContactEntry object that contains the entered data
     * @param bindingResult BindingResult containing information about the binding of the form data to the ContactEntry
     * @return String representing the name of the view to present.
     */
    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String formNewSubmit(@ModelAttribute("contact") @Valid ContactEntry contact, BindingResult bindingResult) {
        if (contactHasErrors(contact, bindingResult)) {
            return "contacts/new";
        }

        CreateContactCommand command = new CreateContactCommand(contact.getName());

        commandBus.dispatch(new GenericCommandMessage<Object>(command));

        return "redirect:/contacts";
    }

    @RequestMapping(value = "{identifier}/delete", method = RequestMethod.GET)
    public String formDelete(@PathVariable String identifier, Model model) {
        ContactEntry contactEntry = repository.loadContactDetails(identifier);
        model.addAttribute("contact", contactEntry);
        return "contacts/delete";
    }

    @RequestMapping(value = "{identifier}/delete", method = RequestMethod.POST)
    public String formDelete(@ModelAttribute("contact") ContactEntry contact, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            RemoveContactCommand command = new RemoveContactCommand(contact.getIdentifier());
            commandBus.dispatch(new GenericCommandMessage<Object>(command));

            return "redirect:/contacts";
        }
        return "contacts/delete";

    }

    @RequestMapping(value = "{identifier}/address/new", method = RequestMethod.GET)
    public String formNewAddress(@PathVariable String identifier, Model model) {
        ContactEntry contactEntry = repository.loadContactDetails(identifier);
        AddressEntry addressEntry = new AddressEntry();
        addressEntry.setIdentifier(contactEntry.getIdentifier());
        addressEntry.setName(contactEntry.getName());
        model.addAttribute("address", addressEntry);
        return "contacts/address";
    }

    @RequestMapping(value = "{identifier}/address/new", method = RequestMethod.POST)
    public String formNewAddressSubmit(@ModelAttribute("address") @Valid AddressEntry address, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            RegisterAddressCommand command = new RegisterAddressCommand(
                    address.getIdentifier(),
                    address.getAddressType(),
                    address.getStreetAndNumber(),
                    address.getZipCode(),
                    address.getCity()
            );
            commandBus.dispatch(new GenericCommandMessage<Object>(command));

            return "redirect:/contacts/" + address.getIdentifier();
        }
        return "contacts/address";
    }

    @RequestMapping(value = "{identifier}/address/delete/{addressType}", method = RequestMethod.GET)
    public String formDeleteAddress(@PathVariable String identifier, @PathVariable AddressType addressType, Model model) {
        ContactEntry contactEntry = repository.loadContactDetails(identifier);
        AddressEntry addressEntry = new AddressEntry();
        addressEntry.setIdentifier(contactEntry.getIdentifier());
        addressEntry.setName(contactEntry.getName());
        addressEntry.setAddressType(addressType);
        model.addAttribute("address", addressEntry);
        return "contacts/removeAddress";
    }


    @RequestMapping(value = "{identifier}/address/delete/{addressType}", method = RequestMethod.POST)
    public String formDeleteAddressSubmit(@ModelAttribute("address") AddressEntry address, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            RemoveAddressCommand command = new RemoveAddressCommand(
                    address.getIdentifier(),
                    address.getAddressType()
            );
            commandBus.dispatch(new GenericCommandMessage<Object>(command));

            return "redirect:/contacts/" + address.getIdentifier();
        }
        return "contacts/removeAddress";
    }

    /**
     * Checks if the entered data for a contact is valid and if the provided contact has not yet been taken.
     *
     * @param contact       Contact to validate
     * @param bindingResult BindingResult that can contain error and can be used to store additional errors
     * @return true if the contact has errors, false otherwise
     */
    private boolean contactHasErrors(ContactEntry contact, BindingResult bindingResult) {
        if (bindingResult.hasErrors() || !contactNameRepository.vacantContactName(contact.getName())) {
            ObjectError error = new FieldError("contact", "name",
                    "The provided name \'" + contact.getName() + "\' already exists");
            bindingResult.addError(error);
            return true;
        }
        return false;
    }
}
