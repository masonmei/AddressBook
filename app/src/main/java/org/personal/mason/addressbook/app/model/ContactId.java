package org.personal.mason.addressbook.app.model;

import org.axonframework.common.Assert;
import org.axonframework.domain.IdentifierFactory;

import java.io.Serializable;

/**
 * Created by m00290368 on 2014-11-26.
 */
public class ContactId implements Serializable {

    private final String identifier;

    public ContactId(){
        this.identifier = IdentifierFactory.getInstance().generateIdentifier();
    }

    public ContactId(String identifier) {
        Assert.notNull(identifier, "Identifier must not be null");
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactId)) return false;

        ContactId contactId = (ContactId) o;

        if (identifier != null ? !identifier.equals(contactId.identifier) : contactId.identifier != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return identifier != null ? identifier.hashCode() : 0;
    }

    @Override
    public String toString() {
        return identifier;
    }
}
