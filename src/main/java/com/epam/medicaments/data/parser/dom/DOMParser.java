package com.epam.medicaments.data.parser.dom;

public class DOMParser {
    public void domParse(){
        DOMBuilder domBuilder = new DOMBuilder();
        domBuilder.buildList("src/main/java/com/epam/medicaments/data/medicaments.xml");
        System.out.println(domBuilder.getPills());
        System.out.println(domBuilder.getDrops());
        System.out.println(domBuilder.getPowders());
    }
}
