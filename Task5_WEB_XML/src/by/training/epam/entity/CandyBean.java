package by.training.epam.entity;

import java.io.Serializable;

public class CandyBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private String name;
    private int energy;
    private int water;
    private int sugar;
    private int fructose;
    private String chocolatetype;
    private int vanilla;
    private int proteins;
    private int fats;
    private int carbohydrates;
    private String production;
    private String id;
    private String type;
    private String topping;
    
    public CandyBean() {
    	
	}

	public String getName() {
		return name;
	}

	public int getEnergy() {
		return energy;
	}

	public int getWater() {
		return water;
	}

	public int getSugar() {
		return sugar;
	}

	public int getFructose() {
		return fructose;
	}

	public String getChocolatetype() {
		return chocolatetype;
	}

	public int getVanilla() {
		return vanilla;
	}

	public int getProteins() {
		return proteins;
	}

	public int getFats() {
		return fats;
	}

	public int getCarbohydrates() {
		return carbohydrates;
	}

	public String getProduction() {
		return production;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getTopping() {
		return topping;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public void setSugar(int sugar) {
		this.sugar = sugar;
	}

	public void setFructose(int fructose) {
		this.fructose = fructose;
	}

	public void setChocolatetype(String chocolatetype) {
		this.chocolatetype = chocolatetype;
	}

	public void setVanilla(int vanilla) {
		this.vanilla = vanilla;
	}

	public void setProteins(int proteins) {
		this.proteins = proteins;
	}

	public void setFats(int fats) {
		this.fats = fats;
	}

	public void setCarbohydrates(int carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + carbohydrates;
		result = prime * result + ((chocolatetype == null) ? 0 : chocolatetype.hashCode());
		result = prime * result + energy;
		result = prime * result + fats;
		result = prime * result + fructose;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((production == null) ? 0 : production.hashCode());
		result = prime * result + proteins;
		result = prime * result + sugar;
		result = prime * result + ((topping == null) ? 0 : topping.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + vanilla;
		result = prime * result + water;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandyBean other = (CandyBean) obj;
		if (carbohydrates != other.carbohydrates)
			return false;
		if (chocolatetype == null) {
			if (other.chocolatetype != null)
				return false;
		} else if (!chocolatetype.equals(other.chocolatetype))
			return false;
		if (energy != other.energy)
			return false;
		if (fats != other.fats)
			return false;
		if (fructose != other.fructose)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (production == null) {
			if (other.production != null)
				return false;
		} else if (!production.equals(other.production))
			return false;
		if (proteins != other.proteins)
			return false;
		if (sugar != other.sugar)
			return false;
		if (topping == null) {
			if (other.topping != null)
				return false;
		} else if (!topping.equals(other.topping))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (vanilla != other.vanilla)
			return false;
		if (water != other.water)
			return false;
		return true;
	}

    
	
}
