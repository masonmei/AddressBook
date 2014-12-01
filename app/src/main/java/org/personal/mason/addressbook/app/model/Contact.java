package org.personal.mason.addressbook.app.model;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.personal.mason.addressbook.app.event.*;
import org.personal.mason.addressbook.app.type.AddressType;

import java.util.HashMap;
import java.util.Map;

public class Contact extends AbstractAnnotatedAggregateRoot {
    private Map<AddressType, Address> addresses = new HashMap<AddressType, Address>();
    private ContactId id;

    public Contact(ContactId identifier, String name) {
        apply(new ContactCreatedEvent(identifier, name));
    }

    @SuppressWarnings("UnusedDeclaration")
    Contact() {
    }

    /**
     * Register the provided address with the provided type. If a contact already has an address of the provided type,
     * that address is changed.
     *
     * @param type    AddressType of the address to add or change
     * @param address Address to add or change
     */
    public void registerAddress(AddressType type, Address address) {
        if (addresses.containsKey(type)) {
            apply(new AddressChangedEvent(id, type, address));
        } else {
            apply(new AddressAddedEvent(id, type, address));
        }
    }

    /**
     * Removes the address with the provided type if it exists.
     *
     * @param type AddressType of the address that needs to be removed
     */
    public void removeAddress(AddressType type) {
        if (addresses.containsKey(type)) {
            apply(new AddressRemovedEvent(id, type));
        }
    }

    /**
     * Change the name of the contact
     *
     * @param name String containing the new name
     */
    public void changeName(String name) {
        apply(new ContactNameChangedEvent(id, name));
    }

    public void delete() {
        apply(new ContactDeletedEvent(id));
    }

    @EventHandler
    protected void handleContactCreatedEvent(ContactCreatedEvent event) {
        this.id = event.getContactId();
    }

    @EventHandler
    protected void handleContactNameChangedEvent(ContactNameChangedEvent event) {
    }

    @EventHandler
    protected void handleAddressRegisteredEvent(AbstractAddressBookEvent event) {
        addresses.put(event.getType(), event.getAddress());
    }

    @EventHandler
    protected void handleAddressRemovedEvent(AddressRemovedEvent event) {
        addresses.remove(event.getType());
    }

    public Object getIdentifier() {
        return id;
    }
}