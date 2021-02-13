package me.niravpradhan.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "bank")
public class Bank extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BANK_ID")
    private Long id;

    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "addressLine1", column = @Column(name = "ADDRESS_LINE_1")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "ADDRESS_LINE_2"))
    })
    private Address address;

    @Column(name = "IS_INTERNATIONAL")
    private boolean isInternational;

    @ElementCollection
    @CollectionTable(name = "bank_contact", joinColumns = {@JoinColumn(name = "BANK_ID")})
    @Column(name = "NAME")
    private Collection<String> bankContacts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isInternational() {
        return isInternational;
    }

    public void setInternational(boolean international) {
        isInternational = international;
    }

    public Collection<String> getBankContacts() {
        return bankContacts;
    }

    public void setBankContacts(Collection<String> bankContacts) {
        this.bankContacts = bankContacts;
    }
}
