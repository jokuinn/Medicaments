package com.epam.medicaments.data.parser.sax;

import com.epam.medicaments.data.parser.factory.AbstractMedicamentsBuilder;
import com.epam.medicaments.model.MedTagName;
import com.epam.medicaments.model.entity.Drops;
import com.epam.medicaments.model.entity.Pills;
import com.epam.medicaments.model.entity.Powder;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxBuilder extends AbstractMedicamentsBuilder {

    private final static Logger LOGGER = Logger.getLogger(SaxBuilder.class);

    private List<Pills> pills = new ArrayList<>();
    private List<Drops> drops = new ArrayList<>();
    private List<Powder> powders = new ArrayList<>();

    private XMLInputFactory inputFactory;

    public SaxBuilder(){
        inputFactory = XMLInputFactory.newInstance();
    }

    public List<Pills> getPills(){
        return pills;
    }

    public List<Drops> getDrops(){
        return drops;
    }

    public List<Powder> getPowders(){
        return powders;
    }

    public void buildList(String filename){
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;

        String name;
        try {
            inputStream = new FileInputStream(new File(filename));
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT){
                    name = reader.getLocalName();
                    if (MedTagName.valueOf(name.toUpperCase()) == MedTagName.PILLS){
                        Pills pill = buildPill(reader);
                        pills.add(pill);
                    } else if (MedTagName.valueOf(name.toUpperCase()) == MedTagName.DROPS){
                        Drops drop = buildDrop(reader);
                        drops.add(drop);
                    } else if (MedTagName.valueOf(name.toUpperCase()) == MedTagName.POWDER){
                        Powder powder = buildPowder(reader);
                        powders.add(powder);
                    }
                }
            }
        } catch (XMLStreamException e) {
            LOGGER.error("StAX parsing error!" + e.getMessage());
        } catch (FileNotFoundException e) {
            LOGGER.error("File" + filename + " not found!" + e);
        } finally {
            try {
                if (inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error("Impossible close file" + filename + " : " + e);
            }
        }
    }

    private Powder buildPowder(XMLStreamReader reader) throws XMLStreamException {
        Powder powders = new Powder();
        powders.setId(reader.getAttributeValue(null, String.valueOf(MedTagName.ID).toLowerCase()));

        String name;

        while (reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedTagName.valueOf(name.toUpperCase())){
                        case NAME: {
                            powders.setName(getXMLText(reader));
                            break;
                        }
                        case PHARM: {
                            powders.setPharm(getXMLText(reader));
                            break;
                        }
                        case GROUP: {
                            powders.setGroup(getXMLText(reader));
                            break;
                        }
                        case WEIGHTPACKET: {
                            String text = getXMLText(reader);
                            powders.setWeightPacket(Double.parseDouble(text));
                            break;
                        }
                        case RECEIVINGFREQUENCY: {
                            String text = getXMLText(reader);
                            powders.setReceivingFrequency(Integer.parseInt(text));
                            break;
                        }
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT: {
                    name = reader.getLocalName();
                    if (MedTagName.valueOf(name.toUpperCase()) == MedTagName.POWDER){
                        return powders;
                    }
                    break;
                }
            }
        }
        throw new XMLStreamException("Unknown element in tag Powders");
    }

    private Drops buildDrop(XMLStreamReader reader) throws XMLStreamException {
        Drops drops = new Drops();
        drops.setId(reader.getAttributeValue(null, String.valueOf(MedTagName.ID).toLowerCase()));

        String name;

        while (reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedTagName.valueOf(name.toUpperCase())){
                        case NAME: {
                            drops.setName(getXMLText(reader));
                            break;
                        }
                        case PHARM: {
                            drops.setPharm(getXMLText(reader));
                            break;
                        }
                        case GROUP: {
                            drops.setGroup(getXMLText(reader));
                            break;
                        }
                        case CAPACITY: {
                            String text = getXMLText(reader);
                            drops.setCapacity(Integer.parseInt(text));
                            break;
                        }
                        case RECEIVINGFREQUENCY: {
                            String text = getXMLText(reader);
                            drops.setReceivingFrequency(Integer.parseInt(text));
                            break;
                        }
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT: {
                    name = reader.getLocalName();
                    if (MedTagName.valueOf(name.toUpperCase()) == MedTagName.DROPS){
                        return drops;
                    }
                    break;
                }
            }
        }
        throw new XMLStreamException("Unknown element in tag Drops");
    }

    private Pills buildPill(XMLStreamReader reader) throws XMLStreamException {
        Pills pills = new Pills();
        pills.setId(reader.getAttributeValue(null, String.valueOf(MedTagName.ID).toLowerCase()));

        String name;

        while (reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedTagName.valueOf(name.toUpperCase())){
                        case NAME: {
                            pills.setName(getXMLText(reader));
                            break;
                        }
                        case PHARM: {
                            pills.setPharm(getXMLText(reader));
                            break;
                        }
                        case GROUP: {
                            pills.setGroup(getXMLText(reader));
                            break;
                        }
                        case QUANTITYPACKAGE: {
                            String text = getXMLText(reader);
                            pills.setQuantityPackage(Integer.parseInt(text));
                            break;
                        }
                        case RECEIVINGFREQUENCY: {
                            String text = getXMLText(reader);
                            pills.setReceivingFrequency(Integer.parseInt(text));
                            break;
                        }
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT: {
                    name = reader.getLocalName();
                    if (MedTagName.valueOf(name.toUpperCase()) == MedTagName.PILLS){
                        return pills;
                    }
                    break;
                }
            }
        }
        throw new XMLStreamException("Unknown element in tag Pills");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException{
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
