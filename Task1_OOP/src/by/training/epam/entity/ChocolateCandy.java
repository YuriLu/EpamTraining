package by.training.epam.entity;

public class ChocolateCandy extends Sweet {

	private int cocoaCount;
	private boolean waffle;
	private ChocolateCandyFiller filler;

	public ChocolateCandy(String name, String manufacturer, String gost, int weight, int sugarCount, int cocoaCount, boolean waffle,
			ChocolateCandyFiller filler) {

		super(name, manufacturer, gost, weight, sugarCount);
		this.cocoaCount = cocoaCount;
		this.waffle = waffle;
		this.filler = filler;

	}

	public int getCocoaCount() {
		return cocoaCount;
	}

	public boolean isWaffle() {
		return waffle;
	}

	public ChocolateCandyFiller getFiller() {
		return filler;
	}
	
	

	@Override
	public String toString() {
		
		StringBuilder strb = new StringBuilder();
		
		strb.append("Chocolate candy ");
		strb.append("\"" + getName() + "\"");
		
		if(waffle){
			strb.append(" with waffle and");
		}
		
		if(filler == ChocolateCandyFiller.NONE){
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
		result = prime * result + (waffle ? 1231 : 1237);
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
		ChocolateCandy other = (ChocolateCandy) obj;
		if (cocoaCount != other.cocoaCount)
			return false;
		if (filler != other.filler)
			return false;
		if (waffle != other.waffle)
			return false;
		return true;
	}
	
	
	
}
