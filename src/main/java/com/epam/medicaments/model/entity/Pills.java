package com.epam.medicaments.model.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Drops", propOrder = { "quantityPackage" })
public class Pills extends AbstractMedicaments {
    @XmlElement(name = "quantityPackage")
    private int quantityPackage;


    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getGroup() {
        return super.getGroup();
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public int getReceivingFrequency() {
        return super.getReceivingFrequency();
    }

    @Override
    public String getPharm() {
        return super.getPharm();
    }

    @Override
    public void setGroup(String group) {
        super.setGroup(group);
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setPharm(String pharm) {
        super.setPharm(pharm);
    }

    @Override
    public void setReceivingFrequency(int receivingFrequency) {
        super.setReceivingFrequency(receivingFrequency);
    }

    @Override
    public String toString() {
        return "\n" + "Pills{" + "\n" +
                "id='" + getId() + '\'' + "\n" +
                "name= '" + getName() + '\'' + "\n" +
                "pharm= '" + getPharm() + '\'' + "\n" +
                "group= '" + getGroup() + '\'' + "\n" +
                "quantityPackage= '" + getQuantityPackage() + '\'' + "\n" +
                "receivingFrequency= '" + getReceivingFrequency() + '\'' + "\n" +
                '}' ;
    }

    public int getQuantityPackage() {
        return quantityPackage;
    }

    public void setQuantityPackage(int quantityPackage) {
        this.quantityPackage = quantityPackage;
    }
}
