package by.training.epam.entity;

public enum ChocolateCandyFiller {
	
	NONE,
	GRATED_NUTS,
	COCOA_CRUMB,
	RUM,
	WHISKEY;
	
	 @Override
	    public String toString() {
	        String name = "";
	        switch (ordinal()) {
	        case 0:
	            name = "none";
	            break;
	        case 1:
	            name = "grated nuts";
	            break;
	        case 2:
	            name = "cocoa crumb";
	            break;
	        case 3:
	            name = "rum";
	            break;
	        case 4:
	            name = "whiskey";
	            break;
	        default:
	            name = "";
	            break;
	        }
	        return name;
	    }
	
}
