package com.epam.medicaments.data.parser;

import com.epam.medicaments.data.parser.dom.DOMBuilder;
import com.epam.medicaments.data.parser.factory.AbstractMedicamentsBuilder;
import com.epam.medicaments.data.parser.sax.SaxBuilder;

public class ParserFactory {
    private enum TypeParser {
        SAX,
        DOM
    }
    public AbstractMedicamentsBuilder createBuilder(String typeParser){
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type){
            case DOM: {
                return new DOMBuilder();
            }
            case SAX: {
                return new SaxBuilder();
            }
            default: {
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
            }
        }
    }
}
