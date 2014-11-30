package org.personal.mason.addressbook.web;

import org.personal.mason.addressbook.app.command.CreateContactCommand;
import org.personal.mason.addressbook.app.model.ContactId;
import org.springframework.security.crypto.keygen.KeyGenerators;

/**
 * Created by m00290368 on 2014-11-26.
 */
public class DataGenerator {

    public static String generateName() {
        return KeyGenerators.string().generateKey();
    }

    public static CreateContactCommand generateCommand(){
        return new CreateContactCommand(new ContactId(), generateName());
    }
}
