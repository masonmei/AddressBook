package org.personal.mason.addressbook.app.event;

import org.personal.mason.addressbook.app.model.Address;
import org.personal.mason.addressbook.app.type.AddressType;

import java.io.Serializable;

/**
 * Created by mason on 11/25/14.
 */
public abstract class AbstractAddressBookEvent implements Serializable {

    private final String contactId;
    private final AddressType type;
    private final Address address;

    protected AbstractAddressBookEvent(String contactId, AddressType type, Address address) {
        this.contactId = contactId;
        this.type = type;
        this.address = address;
    }

    public AddressType getType() {
        return type;
    }

    public Address getAddress() {
        return address;
    }

    public String getContactId() {
        return contactId;
    }
}
