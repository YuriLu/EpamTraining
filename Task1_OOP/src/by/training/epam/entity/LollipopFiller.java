package by.training.epam.entity;

public enum LollipopFiller {

	NONE,
	STRAWBERRY_JAM,
	CRANBERRY_JAM,
	CHERRY_JAM,
	RAISINS;
	
	 @Override
	    public String toString() {
	        String name = "";
	        switch (ordinal()) {
	        case 0:
	            name = "none";
	            break;
	        case 1:
	            name = "Strawberry jam";
	            break;
	        case 2:
	            name = "Cranberry jam";
	            break;
	        case 3:
	            name = "Cherry jam";
	            break;
	        case 4:
	            name = "Tomato jam";
	            break;
	        default:
	            name = "";
	            break;
	        }
	        return name;
	    }
	
}
