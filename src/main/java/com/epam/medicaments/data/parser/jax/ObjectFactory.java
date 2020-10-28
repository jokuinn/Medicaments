package com.epam.medicaments.data.parser.jax;

import com.epam.medicaments.model.MedTagName;
import com.epam.medicaments.model.entity.AbstractMedicaments;
import com.epam.medicaments.model.entity.Drops;
import com.epam.medicaments.model.entity.Pills;
import com.epam.medicaments.model.entity.Powder;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {
    private final static QName _Medicaments_QName =
            new QName("http://www.epam.com/medicaments", "medicaments");
    private final static QName _Pills_QName =
            new QName("http://www.epam.com/medicaments", "Pills");
    private final static QName _Drops_QName =
            new QName("http://www.epam.com/medicaments", "Drops");
    private final static QName _Powder_QName =
            new QName("http://www.epam.com/medicaments", "Powder");

    public ObjectFactory() {

    }

    public Pills createPills() {
        return new Pills();
    }

    public Drops createDrops() {
        return new Drops();
    }

    public Powder createPowder() {
        return new Powder();
    }

    @XmlElementDecl(namespace = "http://www.epam.com/medicaments", name = "Pills")
    public JAXBElement<Pills> createPills(Pills value){
        return new JAXBElement<Pills>(_Medicaments_QName, Pills.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.epam.com/medicaments", name = "Drops", substitutionHeadNamespace = "http://www.epam.com/medicaments", substitutionHeadName = "Drops")
    public JAXBElement<Drops> createDrops(Drops value){
        return new JAXBElement<Drops>(_Drops_QName, Drops.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.epam.com/medicaments", name = "Powder", substitutionHeadNamespace = "http://www.epam.com/medicaments", substitutionHeadName = "Powders")
    public JAXBElement<Powder> createPowders(Powder value){
        return new JAXBElement<Powder>(_Drops_QName, Powder.class, null, value);
    }


}
