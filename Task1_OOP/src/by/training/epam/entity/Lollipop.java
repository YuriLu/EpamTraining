package by.training.epam.entity;

public class Lollipop extends Sweet {

	private final LollipopTastes taste;
	private final LollipopFiller filler;

	public Lollipop(String name, String manufacturer, String gost, int weight, int sugarCount, LollipopTastes taste,
			LollipopFiller filler) {

		super(name, manufacturer, gost, weight, sugarCount);
		this.taste = taste;
		this.filler = filler;

	}

	public LollipopTastes getTaste() {
		return taste;
	}

	public LollipopFiller getFiller() {
		return filler;
	}
	
	
	@Override
	public String toString() {
		
		StringBuilder strb = new StringBuilder();
		
		strb.append(taste.toString());
		strb.append(" lollipop ");
		strb.append("\"" + getName() + "\"");
		
		if(filler == LollipopFiller.NONE){
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
		result = prime * result + ((filler == null) ? 0 : filler.hashCode());
		result = prime * result + ((taste == null) ? 0 : taste.hashCode());
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
		Lollipop other = (Lollipop) obj;
		if (filler != other.filler)
			return false;
		if (taste != other.taste)
			return false;
		return true;
	}
	
	
}
