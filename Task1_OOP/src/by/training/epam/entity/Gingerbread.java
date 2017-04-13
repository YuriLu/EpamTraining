package by.training.epam.entity;

public class Gingerbread extends Sweet {

	private final int flourCount;
	private final int cocoaCount;
	private final GingerbreadFiller filler;

	public Gingerbread(String name, String manufacturer, String gost, int weight, int sugarCount, int flourCount,
			int cocoaCount, GingerbreadFiller filler) {
		super(name, manufacturer, gost, weight, sugarCount);

		this.flourCount = flourCount;
		this.cocoaCount = cocoaCount;
		this.filler = filler;

	}

	public int getFlourCount() {
		return flourCount;
	}

	public int getCocoaCount() {
		return cocoaCount;
	}

	public GingerbreadFiller getFiller() {
		return filler;
	}

	@Override
	public String toString() {

		StringBuilder strb = new StringBuilder();

		strb.append("Giggerbread ");
		strb.append("\"" + getName() + "\"");

		if (filler == GingerbreadFiller.NONE) {
			strb.append(" without filler.");
		} else {
			strb.append(" with " + filler.toString() + " filler.");
		}

		strb.append("  weight: " + getWeight());
		
		return strb.toString();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + cocoaCount;
		result = prime * result + ((filler == null) ? 0 : filler.hashCode());
		result = prime * result + flourCount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gingerbread other = (Gingerbread) obj;
		if (cocoaCount != other.cocoaCount)
			return false;
		if (filler != other.filler)
			return false;
		if (flourCount != other.flourCount)
			return false;
		return true;
	}

}
