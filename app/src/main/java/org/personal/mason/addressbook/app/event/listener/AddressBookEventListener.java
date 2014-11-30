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
        entry.setIdentifier(event.getContactId());
        entry.setName(event.getName());
        contactRepository.save(entry);
    }

    @EventHandler
    public void handleContactNameChangedEvent(ContactNameChangedEvent event) {
        entityManager.createQuery("UPDATE ContactEntry e SET e.name = :newName WHERE e.identifier = :id")
                     .setParameter("newName", event.getNewName())
                     .setParameter("id", event.getContactId())
                     .executeUpdate();
        entityManager.createQuery("UPDATE AddressEntry e SET e.name = :newName WHERE e.identifier = :id")
                     .setParameter("newName", event.getNewName())
                     .setParameter("id", event.getContactId())
                     .executeUpdate();
    }

    @EventHandler
    public void handleContactDeletedEvent(ContactDeletedEvent event) {
        entityManager.createQuery("DELETE FROM AddressEntry e WHERE e.identifier = :id")
                     .setParameter("id", event.getContactId())
                     .executeUpdate();

        entityManager.createQuery("DELETE FROM ContactEntry e WHERE e.identifier = :id")
                     .setParameter("id", event.getContactId())
                     .executeUpdate();
    }

    @EventHandler
    public void handleAddressDeletedEvent(AddressRemovedEvent event) {
        entityManager.createQuery("DELETE FROM AddressEntry e WHERE e.identifier = :id and e.addressType = :type")
                     .setParameter("id", event.getContactId())
                     .setParameter("type", event.getType())
                     .executeUpdate();
    }

    @EventHandler
    public void handleAddressChangedEvent(AddressChangedEvent event) {
        AddressEntry entry = (AddressEntry) entityManager.createQuery(
                "FROM AddressEntry e WHERE e.identifier = :id and e.addressType = :type")
                                                         .setParameter("id", event.getContactId())
                                                         .setParameter("type", event.getType())
                                                         .getSingleResult();

        entry.setStreetAndNumber(event.getAddress().getStreetAndNumber());
        entry.setZipCode(event.getAddress().getZipCode());
        entry.setCity(event.getAddress().getCity());
        entityManager.persist(entry);
    }

    @EventHandler
    public void handleAddressAddedEvent(AddressAddedEvent event) {
        ContactEntry contact = (ContactEntry)
                entityManager.createQuery("FROM ContactEntry e WHERE e.identifier = :id")
                             .setParameter("id", event.getContactId())
                             .getSingleResult();
        AddressEntry entry = new AddressEntry();
        entry.setIdentifier(event.getContactId());
        entry.setName(contact.getName());
        entry.setAddressType(event.getType());
        entry.setStreetAndNumber(event.getAddress().getStreetAndNumber());
        entry.setCity(event.getAddress().getCity());
        entry.setZipCode(event.getAddress().getZipCode());
        entityManager.persist(entry);
    }
}
