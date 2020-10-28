package com.epam.medicaments.data.parser.dom;

import com.epam.medicaments.data.parser.factory.AbstractMedicamentsBuilder;
import com.epam.medicaments.model.entity.Drops;
import com.epam.medicaments.model.entity.Pills;
import com.epam.medicaments.model.entity.Powder;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMBuilder extends AbstractMedicamentsBuilder {
    private final static Logger LOGGER = Logger.getLogger(DOMBuilder.class);


    private List<Drops> drops;
    private List<Pills> pills;
    private List<Powder> powders;
    private DocumentBuilder docBuilder;

    public DOMBuilder(){
        this.drops = new ArrayList<>();
        this.pills = new ArrayList<>();
        this.powders = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("Ошибка конфигурации парсера" + e);
        }
    }

    public List<Drops> getDrops() {
        return drops;
    }
    public List<Pills> getPills() {
        return pills;
    }
    public List<Powder> getPowders(){
        return powders;
    }

    public void buildList(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();

            NodeList dropsList = root.getElementsByTagName("Drops");
            for (int i = 0; i < dropsList.getLength(); i++){
                Element dropElement = (Element) dropsList.item(i);
                Drops drop = buildDrop(dropElement);
                drops.add(drop);
            }

            NodeList pillsList = root.getElementsByTagName("Pills");
            for (int i = 0; i < pillsList.getLength(); i++){
                Element pillElement = (Element) pillsList.item(i);
                Pills pill = buildPill(pillElement);
                pills.add(pill);
            }

            NodeList powdersList = root.getElementsByTagName("Powder");
            for (int i = 0; i < powdersList.getLength(); i++){
                Element powderElement = (Element) powdersList.item(i);
                Powder powder = buildPowder(powderElement);
                powders.add(powder);
            }
        } catch (SAXException e) {
            LOGGER.error("Parsing failure: " + e);
        } catch (IOException e) {
            LOGGER.error("File error or I/O error: " + e);
        }
    }

    private Drops buildDrop(Element dropElement) {
        Drops drops = new Drops();

        drops.setId(dropElement.getAttribute("id"));
        drops.setName(getElementTextContext(dropElement, "name"));
        drops.setPharm(getElementTextContext(dropElement, "pharm"));
        drops.setGroup(getElementTextContext(dropElement, "group"));

        int capacity = Integer.parseInt(getElementTextContext(dropElement, "capacity"));
        drops.setCapacity(capacity);

        int receivingFrequency = Integer.parseInt(getElementTextContext(dropElement, "receivingFrequency"));
        drops.setReceivingFrequency(receivingFrequency);

        return drops;
    }

    private Pills buildPill(Element pillElement) {
        Pills pills = new Pills();

        pills.setId(pillElement.getAttribute("id"));
        pills.setName(getElementTextContext(pillElement, "name"));
        pills.setPharm(getElementTextContext(pillElement, "pharm"));
        pills.setGroup(getElementTextContext(pillElement, "group"));

        int quantityPackage = Integer.parseInt(getElementTextContext(pillElement, "quantityPackage"));
        pills.setQuantityPackage(quantityPackage);

        int receivingFrequency = Integer.parseInt(getElementTextContext(pillElement, "receivingFrequency"));
        pills.setReceivingFrequency(receivingFrequency);

        return pills;
    }

    private Powder buildPowder(Element powderElement) {
        Powder powder = new Powder();

        powder.setId(powderElement.getAttribute("id"));
        powder.setName(getElementTextContext(powderElement, "name"));
        powder.setPharm(getElementTextContext(powderElement, "pharm"));
        powder.setGroup(getElementTextContext(powderElement, "group"));

        double weightPackage = Double.parseDouble(getElementTextContext(powderElement, "weightPacket"));
        powder.setWeightPacket(weightPackage);

        int receivingFrequency = Integer.parseInt(getElementTextContext(powderElement, "receivingFrequency"));
        powder.setReceivingFrequency(receivingFrequency);

        return powder;
    }

    private static String getElementTextContext(Element element, String elementName){
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
