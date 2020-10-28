package com.epam.medicaments.model;

public enum MedTagName {
    MEDICAMENTS("medicaments"),
    PILLS("Pills"),
    POWDER("Powder"),
    DROPS("Drops"),
    ID("id"),
    NAME("name"),
    PHARM("pharm"),
    GROUP("group"),
    QUANTITYPACKAGE("quantityPackage"),
    RECEIVINGFREQUENCY("receivingFrequency"),
    WEIGHTPACKET("weightPacket"),
    CAPACITY("capacity");
    private String value;

    MedTagName(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
