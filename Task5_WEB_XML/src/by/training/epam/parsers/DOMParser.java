package by.training.epam.parsers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.training.epam.entity.Candy;

public class DOMParser implements XMLParser {

	private static final Logger log = Logger.getLogger(DOMParser.class);

	@Override
	public List<Candy> createCandiesList(String xmlFileName) {

		List<Candy> list = new ArrayList<>();
		File xmlFile = new File(xmlFileName);

		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document doc = documentBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			NodeList candyNodeList = doc.getElementsByTagName("candy");
			
			for (int i = 0; i < candyNodeList.getLength(); i++) {
				Node node = candyNodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					list.add(createCandyFromElement((Element) node));
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			log.error(e.getMessage());
		}

		return list;
	}

	private Candy createCandyFromElement(Element candyElement) {

		Candy candy = new Candy();
		candy.setId(candyElement.getAttribute(TagsConstants.ID));
		candy.setType(candyElement.getAttribute(TagsConstants.TYPE));
		if (candyElement.hasAttribute(TagsConstants.TOPPING)) {
			candy.setTopping(candyElement.getAttribute(TagsConstants.TOPPING));
		} else {
			candy.setTopping("");
		}

		candy.setName(candyElement.getElementsByTagName(TagsConstants.NAME).item(0).getTextContent());
		candy.setEnergy(Integer.valueOf(candyElement.getElementsByTagName(TagsConstants.ENERGY).item(0).getTextContent()));
		String water = candyElement.getElementsByTagName(TagsConstants.WATER).item(0).getTextContent();
		candy.getIngridients().setWater(Integer.valueOf(water));
		String sugar = candyElement.getElementsByTagName(TagsConstants.SUGAR).item(0).getTextContent();
		candy.getIngridients().setSugar(Integer.valueOf(sugar));
		String fructose = candyElement.getElementsByTagName(TagsConstants.FRUCTOSE).item(0).getTextContent();
		candy.getIngridients().setFructose(Integer.valueOf(fructose));
		String vanilla = candyElement.getElementsByTagName(TagsConstants.VANILLA).item(0).getTextContent();
		candy.getIngridients().setVanilla(Integer.valueOf(vanilla));
		if (candyElement.getElementsByTagName(TagsConstants.CHOCOLATETYPE).item(0) != null) {
			candy.getIngridients()
					.setChocolatetype(candyElement.getElementsByTagName(TagsConstants.CHOCOLATETYPE).item(0).getTextContent());
		} else {
			candy.getIngridients().setChocolatetype("");
		}
		String proteins = candyElement.getElementsByTagName(TagsConstants.PROTEINS).item(0).getTextContent();
		candy.getValue().setProteins(Integer.valueOf(proteins));
		candy.getValue().setFats(Integer.valueOf(candyElement.getElementsByTagName(TagsConstants.FATS).item(0).getTextContent()));
		candy.getValue().setCarbohydrates(Integer.valueOf(candyElement.getElementsByTagName(TagsConstants.CARBOHYDRATES).item(0).getTextContent()));
		candy.setProduction(candyElement.getElementsByTagName(TagsConstants.PRODUCTION).item(0).getTextContent());

		return candy;
	}

}
