package com.epam.medicaments.model.entity;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Objects;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractMedicaments", propOrder = {
        "name",
        "pharm",
        "group",
        "receivingFrequency",
        "id"
})
@XmlSeeAlso({
        Powder.class,
        Pills.class,
        Drops.class
})
public abstract class AbstractMedicaments {
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private String pharm;
    @XmlElement(required = true)
    private String group;
    @XmlElement(required = true)
    private int receivingFrequency;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String id;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReceivingFrequency() {
        return receivingFrequency;
    }

    public void setReceivingFrequency(int receivingFrequency) {
        this.receivingFrequency = receivingFrequency;
    }

    public String getPharm() {
        return pharm;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractMedicaments abstractMedicaments = (AbstractMedicaments) obj;
        return Objects.equals(id, abstractMedicaments.id) &&
                Objects.equals(name, abstractMedicaments.name) &&
                Objects.equals(pharm, abstractMedicaments.pharm) &&
                Objects.equals(group, abstractMedicaments.group) &&
                receivingFrequency == abstractMedicaments.receivingFrequency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, pharm, group, receivingFrequency);
    }

    @Override
    public String toString() {
        return "Medicaments: ";
    }
}
