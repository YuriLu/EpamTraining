package by.training.epam.entity;

public enum GingerbreadFiller {

	NONE,
	RAISINS,
	STRAWBERRY_JAM,
	CRANBERRY_JAM;
	
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
	            name = "strawberry jam";
	            break;
	        case 3:
	            name = "cranberry jam";
	            break;
	        default:
	            name = "";
	            break;
	        }
	        return name;
	    }

}
