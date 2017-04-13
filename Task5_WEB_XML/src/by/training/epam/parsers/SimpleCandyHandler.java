package by.training.epam.parsers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.training.epam.entity.Candy;
import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;

public class SimpleCandyHandler extends DefaultHandler {
	

	private final static Logger log = Logger.getLogger(SimpleCandyHandler.class);

	private List<Candy> candies;
	private Candy currentCandy;
	private String tmpValue;
	
	public SimpleCandyHandler() {
		candies = new ArrayList<Candy>();
	}
	
	@Override
	public void startDocument() throws SAXException {
		log.info("Parsing started.");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		
		if(localName.equals(TagsConstants.CANDY)){
			currentCandy = new Candy();
			currentCandy.setId(attrs.getValue(TagsConstants.ID));
			if (attrs.getValue(TagsConstants.TOPPING) != null){
				currentCandy.setTopping(attrs.getValue(TagsConstants.TOPPING));
			} else {
				currentCandy.setTopping("none");
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		switch (localName){
		
		case TagsConstants.CANDY:
			candies.add(currentCandy);
			break;
		case TagsConstants.NAME:
			currentCandy.setName(tmpValue);
			break;
		case TagsConstants.ENERGY:
			currentCandy.setEnergy(Integer.valueOf(tmpValue));
			break;
		case TagsConstants.WATER:
			currentCandy.getIngridients().setWater(Integer.valueOf(tmpValue));
			break;
		case TagsConstants.SUGAR:
			currentCandy.getIngridients().setSugar(Integer.valueOf(tmpValue));
			break;	
		case TagsConstants.FRUCTOSE:
			currentCandy.getIngridients().setFructose(Integer.valueOf(tmpValue));
			break;
		case TagsConstants.VANILLA:
			currentCandy.getIngridients().setVanilla(Integer.valueOf(tmpValue));
			break;	
		case TagsConstants.CHOCOLATETYPE:
			currentCandy.getIngridients().setChocolatetype(tmpValue);
			break;
		case TagsConstants.PROTEINS:
			currentCandy.getValue().setProteins(Integer.valueOf(tmpValue));
			break;
		case TagsConstants.FATS:
			currentCandy.getValue().setFats(Integer.valueOf(tmpValue));
			break;	
		case TagsConstants.CARBOHYDRATES:
			currentCandy.getValue().setCarbohydrates(Integer.valueOf(tmpValue));
			break;
		case TagsConstants.PRODUCTION:
			currentCandy.setProduction(tmpValue);
			break;
		}
		
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		tmpValue = new String(ch, start, length);
	}
	
	@Override
	public void endDocument() throws SAXException {
		log.info("Parsing endeded.");
	}
	
	public List<Candy> getCandiesList(){
		return this.candies;
	}
	
}
