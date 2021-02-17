package me.niravpradhan.data.entities;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Investment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ISSUER")
    private String issuer;

    @Column(name = "PURCHASE_DATE")
    private LocalDateTime purchaseDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
