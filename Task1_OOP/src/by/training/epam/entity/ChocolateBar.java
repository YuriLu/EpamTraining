package by.training.epam.entity;

public class ChocolateBar extends Sweet {

	private final int cocoaCount;
	private final boolean porous;
	private final ChocolateBarFiller filler;

	public ChocolateBar(String name, String manufacturer, String gost, int weight, int sugarCount, int cocoaCount, boolean porous,
			ChocolateBarFiller filler) {
		super(name, manufacturer, gost, weight, sugarCount);

		this.cocoaCount = cocoaCount;
		this.porous = porous;
		this.filler = filler;

	}

	public int getCocoaCount() {
		return cocoaCount;
	}

	public boolean isPorous() {
		return porous;
	}

	public ChocolateBarFiller getFiller() {
		return filler;
	}

	@Override
	public String toString() {
		
		StringBuilder strb = new StringBuilder();
		if (porous){
			strb.append("Porous ");
		}
		
		strb.append("ChocolateBar ");
		strb.append("\"" + getName() + "\"");
		
		if(filler == ChocolateBarFiller.NONE){
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
		result = prime * result + (porous ? 1231 : 1237);
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
		ChocolateBar other = (ChocolateBar) obj;
		if (cocoaCount != other.cocoaCount)
			return false;
		if (filler != other.filler)
			return false;
		if (porous != other.porous)
			return false;
		return true;
	}

	
	
	
}
