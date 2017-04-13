package by.training.epam.entity;

public abstract class Sweet {

	private String name;
	private String manufacturer;
	private String gost;
	private int weight;
	private int sugarCount;

	public Sweet(String name, String manufacturer, String gost, int weight, int sugarCount) {

		this.name = name;
		this.manufacturer = manufacturer;
		this.gost = gost;
		this.weight = weight;
		this.sugarCount = sugarCount;

	}
	
	public String getName() {
		return name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getGost() {
		return gost;
	}

	public int getWeight() {
		return weight;
	}

	public int getSugarAmount() {
		return sugarCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gost == null) ? 0 : gost.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sugarCount;
		result = prime * result + weight;
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
		Sweet other = (Sweet) obj;
		if (gost == null) {
			if (other.gost != null)
				return false;
		} else if (!gost.equals(other.gost))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sugarCount != other.sugarCount)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	

}
