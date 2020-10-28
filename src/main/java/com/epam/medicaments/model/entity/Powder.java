package com.epam.medicaments.model.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Drops", propOrder = { "weightPacket" })
public class Powder extends AbstractMedicaments {
    @XmlElement(name = "weightPacket")
    private double weightPacket;


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
        return "\n" + "Powder{" + "\n" +
                "id='" + getId() + '\'' + "\n" +
                "name= '" + getName() + '\'' + "\n" +
                "pharm= '" + getPharm() + '\'' + "\n" +
                "group= '" + getGroup() + '\'' + "\n" +
                "weightPacket= '" + getWeightPacket() + '\'' + "\n" +
                "receivingFrequency= '" + getReceivingFrequency() + '\'' + "\n" +
                '}' ;
    }

    public double getWeightPacket() {
        return weightPacket;
    }

    public void setWeightPacket(double weight) {
        this.weightPacket = weightPacket;
    }
}
