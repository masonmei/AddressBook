package org.personal.mason.addressbook.app.command;

import org.personal.mason.addressbook.app.type.AddressType;
import org.springframework.util.Assert;

/**
 * @author mason
 */
public class RegisterAddressCommand extends AbstractAddressBookCommand {
    private final AddressType addressType;
    private final String streetAndNumber;
    private final String zipCode;
    private final String city;

    public RegisterAddressCommand(String contactId, AddressType addressType, String streetAndNumber, String zipCode, String city) {
        super(contactId);
        Assert.notNull(addressType, "An Address type must be provided.");
        this.addressType = addressType;
        this.streetAndNumber = streetAndNumber;
        this.zipCode = zipCode;
        this.city = city;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }
}
