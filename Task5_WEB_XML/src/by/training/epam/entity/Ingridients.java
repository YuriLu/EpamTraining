
package by.training.epam.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ingridients", propOrder = {
    "water",
    "sugar",
    "fructose",
    "chocolatetype",
    "vanilla"
})
public class Ingridients {

    protected int water;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected int sugar;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected int fructose;
    protected String chocolatetype;
    @XmlElement(required = true)
    protected int vanilla;

    public int getWater() {
        return water;
    }

    public void setWater(int value) {
        this.water = value;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int value) {
        this.sugar = value;
    }

    public int getFructose() {
        return fructose;
    }

    public void setFructose(int value) {
        this.fructose = value;
    }

    public String getChocolatetype() {
        return chocolatetype;
    }

    public void setChocolatetype(String value) {
        this.chocolatetype = value;
    }

    public int getVanilla() {
        return vanilla;
    }

    public void setVanilla(int value) {
        this.vanilla = value;
    }

}
