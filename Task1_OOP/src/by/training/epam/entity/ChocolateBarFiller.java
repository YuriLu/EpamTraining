package by.training.epam.entity;

public enum ChocolateBarFiller {
	
	NONE,
	RAISINS,
	NUTS,
	COCOA_CRUMB;
	
	 @Override
	    public String toString() {
	        String name = "";
	        switch (ordinal()) {
	        case 0:
	            name = "none";
	            break;
	        case 1:
	            name = "raisins";
	            break;
	        case 2:
	            name = "nuts";
	            break;
	        case 3:
	            name = "cocoa crumb";
	            break;
	        default:
	            name = "";
	            break;
	        }
	        return name;
	    }
	
}
