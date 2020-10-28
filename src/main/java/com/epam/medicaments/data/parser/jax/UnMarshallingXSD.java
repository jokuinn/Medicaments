package com.epam.medicaments.data.parser.jax;

import com.epam.medicaments.data.parser.sax.SaxBuilder;
import com.epam.medicaments.model.entity.Pills;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class UnMarshallingXSD {

    private final static Logger LOGGER = Logger.getLogger(SaxBuilder.class);

    public void parse() {
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance("com.epam.medicaments");
            Unmarshaller um = jc.createUnmarshaller();
            String shemaName = "data/med.xsd";
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
            File shemaLocation = new File(shemaName);
            Schema shema = factory.newSchema(shemaLocation);
            um.setSchema(shema);

            Pills pills = (Pills) um.unmarshal(new File(("data/medicaments.xml")));
            System.out.println(pills);
        } catch (JAXBException | SAXException e) {
            LOGGER.info(e);
        }
    }
}
