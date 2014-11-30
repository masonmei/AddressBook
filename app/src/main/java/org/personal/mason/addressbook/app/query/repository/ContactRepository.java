package org.personal.mason.addressbook.app.query.repository;

import org.personal.mason.addressbook.app.entry.ContactEntry;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by m00290368 on 2014-11-26.
 */
public interface ContactRepository extends PagingAndSortingRepository<ContactEntry, Long> {

    public ContactEntry findByIdentifier(String identifier);

}
