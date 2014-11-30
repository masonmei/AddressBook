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

package org.personal.mason.addressbook.app.entry;


import org.personal.mason.addressbook.app.type.AddressType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Allard Buijze
 */
@Entity
public class AddressEntry {

    @Id
    @GeneratedValue
    private Long db_identifier;

    @Basic
    @Column(length = 36)
    private String identifier;

    @Basic
    private String name;

    @NotNull
    @Basic
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @NotNull
    @Size(min = 5)
    @Basic
    private String streetAndNumber;

    @NotNull
    @Size(min = 4)
    @Basic
    private String zipCode;

    @NotNull
    @Size(min = 2)
    @Basic
    private String city;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
