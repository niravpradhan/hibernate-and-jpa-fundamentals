package me.niravpradhan.data.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BankContact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "NAME1")
    private String name;

    @Column(name = "POSITION_TYPE1")
    private String positionType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
}
