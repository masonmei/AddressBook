package org.personal.mason.addressbook.app.command;

/**
 * Created by mason on 11/25/14.
 */
public abstract class AbstractAddressBookCommand {

    private final String contactId;

    public AbstractAddressBookCommand(String contactId) {
        this.contactId = contactId;
    }

    public String getContactId() {
        return contactId;
    }
}
