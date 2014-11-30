package org.personal.mason.addressbook.app.query.repository;

import org.personal.mason.addressbook.app.entry.AddressEntry;
import org.personal.mason.addressbook.app.type.AddressType;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by m00290368 on 2014-11-26.
 */
public interface AddressRepository extends PagingAndSortingRepository<AddressEntry, Long> {

    public List<AddressEntry> findByIdentifier(String identifier);

    public List<AddressEntry> findByIdentifierAndAddressType(String identifier, AddressType addressType);
}
