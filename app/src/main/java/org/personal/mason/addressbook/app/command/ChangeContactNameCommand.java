/*
 * Copyright (c) 2010. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.personal.mason.addressbook.app.command;

import org.personal.mason.addressbook.app.model.ContactId;
import org.springframework.util.Assert;

public class ChangeContactNameCommand extends AbstractAddressBookCommand {
    private final String contactNewName;

    public ChangeContactNameCommand(ContactId contactId, String contactNewName) {
        super(contactId);
        Assert.hasText(contactNewName, "New name for contact should contain text");
        this.contactNewName = contactNewName;
    }

    public String getContactNewName() {
        return contactNewName;
    }

}
