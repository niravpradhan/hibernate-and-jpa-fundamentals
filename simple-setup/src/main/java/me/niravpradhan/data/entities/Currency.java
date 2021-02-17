package me.niravpradhan.data.entities;

import me.niravpradhan.data.entities.ids.CurrencyId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "currency")
@IdClass(CurrencyId.class)
public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NAME")
    private String name;

    @Id
    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @Column(name = "SYMBOL")
    private String symbol;

    @OneToMany(mappedBy = "currency")
    private List<Market> markets = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(List<Market> markets) {
        this.markets = markets;
    }
}
