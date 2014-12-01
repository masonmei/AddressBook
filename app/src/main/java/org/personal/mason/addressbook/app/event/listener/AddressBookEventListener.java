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

package org.personal.mason.addressbook.app.event.listener;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.personal.mason.addressbook.app.entry.AddressEntry;
import org.personal.mason.addressbook.app.entry.ContactEntry;
import org.personal.mason.addressbook.app.event.*;
import org.personal.mason.addressbook.app.query.repository.AddressRepository;
import org.personal.mason.addressbook.app.query.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Allard Buijze
 */
public class AddressBookEventListener {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AddressRepository addressRepository;

    @EventHandler
    public void handleContactCreatedEvent(ContactCreatedEvent event) {
        ContactEntry entry = new ContactEntry();
        entry.setIdentifier(event.getContactId().toString());
        entry.setName(event.getName());
        contactRepository.save(entry);
    }

    @EventHandler
    public void handleContactNameChangedEvent(ContactNameChangedEvent event) {
        ContactEntry contactEntry = contactRepository.findByIdentifier(event.getContactId().toString());
        List<AddressEntry> addressEntries = addressRepository.findByIdentifier(event.getContactId().toString());
        contactEntry.setName(event.getNewName());
        for (AddressEntry addressEntry: addressEntries){
            addressEntry.setName(event.getNewName());
        }
        contactRepository.save(contactEntry);
        addressRepository.save(addressEntries);
    }

    @EventHandler
    public void handleContactDeletedEvent(ContactDeletedEvent event) {
        ContactEntry contactEntry = contactRepository.findByIdentifier(event.getContactId().toString());
        List<AddressEntry> addressEntries = addressRepository.findByIdentifier(event.getContactId().toString());
        addressRepository.delete(addressEntries);
        contactRepository.delete(contactEntry);
    }

    @EventHandler
    public void handleAddressDeletedEvent(AddressRemovedEvent event) {
        List<AddressEntry> addressEntries = addressRepository.findByIdentifierAndAddressType(event.getContactId().toString(), event.getType());
        addressRepository.delete(addressEntries);
    }

    @EventHandler
    public void handleAddressChangedEvent(AddressChangedEvent event) {
        List<AddressEntry> addressEntries = addressRepository.findByIdentifierAndAddressType(event.getContactId().toString(), event.getType());
        for (AddressEntry addressEntry: addressEntries){
            addressEntry.setStreetAndNumber(event.getAddress().getStreetAndNumber());
            addressEntry.setZipCode(event.getAddress().getZipCode());
            addressEntry.setCity(event.getAddress().getCity());
        }
        addressRepository.save(addressEntries);
    }

    @EventHandler
    public void handleAddressAddedEvent(AddressAddedEvent event) {
        ContactEntry contactEntry = contactRepository.findByIdentifier(event.getContactId().toString());
        AddressEntry entry = new AddressEntry();
        entry.setIdentifier(event.getContactId().toString());
        entry.setName(contactEntry.getName());
        entry.setAddressType(event.getType());
        entry.setStreetAndNumber(event.getAddress().getStreetAndNumber());
        entry.setCity(event.getAddress().getCity());
        entry.setZipCode(event.getAddress().getZipCode());
        entityManager.persist(entry);
    }
}
