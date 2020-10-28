package com.epam.medicaments.data.parser.factory;

import com.epam.medicaments.model.entity.AbstractMedicaments;
import com.epam.medicaments.model.entity.Drops;
import com.epam.medicaments.model.entity.Pills;
import com.epam.medicaments.model.entity.Powder;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMedicamentsBuilder {

    protected List<Pills> pills;
    protected List<Drops> drops;
    protected List<Powder> powders;

    public AbstractMedicamentsBuilder() {
        pills = new ArrayList<>();
        drops = new ArrayList<>();
        powders = new ArrayList<>();

    }

    public AbstractMedicamentsBuilder(List<Pills> pills, List<Drops> drops, List<Powder> powders){
        this.powders = powders;
        this.drops = drops;
        this.pills = pills;
    }

    public List<Pills> getPills() {
        return pills;
    }

    public List<Drops> getDrops() {
        return drops;
    }

    public List<Powder> getPowders() {
        return powders;
    }

    abstract public void buildList(String filename);

}
