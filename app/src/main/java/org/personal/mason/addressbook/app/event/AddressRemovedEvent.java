/*
 * Copyright (c) 2010-2011. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.personal.mason.addressbook.app.event;

import org.personal.mason.addressbook.app.model.ContactId;
import org.personal.mason.addressbook.app.type.AddressType;

import java.io.Serializable;

public class AddressRemovedEvent implements Serializable {

    private final ContactId contactId;
    private final AddressType type;

    public AddressRemovedEvent(ContactId contactId, AddressType type) {
        this.contactId = contactId;
        this.type = type;
    }

    public AddressType getType() {
        return type;
    }

    public ContactId getContactId() {
        return contactId;
    }
}
