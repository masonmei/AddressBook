package org.personal.mason.addressbook.app.command;

import org.personal.mason.addressbook.app.model.ContactId;

/**
 * Created by mason on 11/25/14.
 */
public abstract class AbstractAddressBookCommand {

    private final ContactId contactId;

    public AbstractAddressBookCommand(ContactId contactId) {
        this.contactId = contactId;
    }

    public ContactId getContactId() {
        return contactId;
    }
}
