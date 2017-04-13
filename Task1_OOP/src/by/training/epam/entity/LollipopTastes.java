package by.training.epam.entity;

public enum LollipopTastes {
	
	BURATINO,
	STARWBERRY,
	CRANBERRY,
	POTATO,
	TOMATO;
	
	@Override
    public String toString() {
        String name = "";
        switch (ordinal()) {
        case 0:
            name = "Buratino";
            break;
        case 1:
            name = "Strawberry";
            break;
        case 2:
            name = "Cranberry";
            break;
        case 3:
            name = "Potato";
            break;
        case 4:
            name = "Tomato";
            break;
        default:
            name = "";
            break;
        }
        return name;
    }
	
	

}
