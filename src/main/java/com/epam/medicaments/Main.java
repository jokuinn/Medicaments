package com.epam.medicaments;

import com.epam.medicaments.data.parser.ParserFactory;
import com.epam.medicaments.data.parser.factory.AbstractMedicamentsBuilder;
import org.apache.log4j.Logger;


public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            process();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

    private static void process() {
        LOGGER.info("start Main");

        LOGGER.info("Create factory");
        ParserFactory factory = new ParserFactory();
        AbstractMedicamentsBuilder builder = factory.createBuilder("sax");
        builder.buildList("src/main/java/com/epam/medicaments/data/medicaments.xml");

        LOGGER.info("Parse Xml-file");
        System.out.println(builder.getDrops());
        System.out.println(builder.getPills());
        System.out.println(builder.getPowders());
        LOGGER.info("Finish");

    }
}
