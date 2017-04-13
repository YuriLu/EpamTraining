
package by.training.epam.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Candy", propOrder = {
    "name",
    "energy",
    "ingridients",
    "value",
    "production"
})
public class Candy {
	
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected Integer energy;
    @XmlElement(required = true)
    protected Ingridients ingridients;
    @XmlElement(required = true)
    protected Value value;
    @XmlElement(required = true)
    protected String production;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "topping")
    protected String topping;

    public Candy(){
    	this.ingridients = new Ingridients();
    	this.value = new Value();
    }
    

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer value) {
        this.energy = value;
    }

    public Ingridients getIngridients() {
        return ingridients;
    }

    public void setIngridients(Ingridients value) {
        this.ingridients = value;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String value) {
        this.production = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String value) {
        this.topping = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "proteins",
        "fats",
        "carbohydrates"
    })
    public class Value {

        @XmlElement(required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected int proteins;
        @XmlElement(required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected int fats;
        @XmlElement(required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected int carbohydrates;

        public int getProteins() {
            return proteins;
        }

        public void setProteins(int value) {
            this.proteins = value;
        }

        public int getFats() {
            return fats;
        }

        public void setFats(int value) {
            this.fats = value;
        }

        public int getCarbohydrates() {
            return carbohydrates;
        }

        public void setCarbohydrates(int value) {
            this.carbohydrates = value;
        }

    }

}
