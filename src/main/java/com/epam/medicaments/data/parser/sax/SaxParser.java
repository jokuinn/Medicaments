package com.epam.medicaments.data.parser.sax;

public class SaxParser {
    public void staxParse(){
        SaxBuilder staxBuilder = new SaxBuilder();
        staxBuilder.buildList("src/main/java/com/epam/medicaments/data/medicaments.xml");
        System.out.println(staxBuilder.getPills());
        System.out.println(staxBuilder.getPowders());
        System.out.println(staxBuilder.getDrops());
    }
}
