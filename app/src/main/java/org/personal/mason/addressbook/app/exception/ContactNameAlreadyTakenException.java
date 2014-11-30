package org.personal.mason.addressbook.app.exception;


public class ContactNameAlreadyTakenException extends RuntimeException {

    public ContactNameAlreadyTakenException(String newContactName) {
        super(newContactName);
    }
}
