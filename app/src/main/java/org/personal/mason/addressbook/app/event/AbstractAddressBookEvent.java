package org.personal.mason.addressbook.app.event;

import org.personal.mason.addressbook.app.model.Address;
import org.personal.mason.addressbook.app.model.ContactId;
import org.personal.mason.addressbook.app.type.AddressType;

import java.io.Serializable;

/**
 * Created by mason on 11/25/14.
 */
public abstract class AbstractAddressBookEvent implements Serializable {

    private final ContactId contactId;
    private final AddressType type;
    private final Address address;

    protected AbstractAddressBookEvent(ContactId contactId, AddressType type, Address address) {
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

    public ContactId getContactId() {
        return contactId;
    }
}
