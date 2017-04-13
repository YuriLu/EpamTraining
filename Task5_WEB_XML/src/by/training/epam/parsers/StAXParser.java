package by.training.epam.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.log4j.Logger;

import by.training.epam.entity.Candy;

public class StAXParser implements XMLParser {

	private static final StAXParser instance = new StAXParser();
	private static Logger log = Logger.getLogger(StAXParser.class);

	private StAXParser() {
	}

	public static StAXParser getInstance() {
		return instance;
	}

	@Override
	public List<Candy> createCandiesList(String xmlFileName) {

		List<Candy> resultList = new ArrayList<>();

		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			InputStream is = new FileInputStream(new File(xmlFileName));
			XMLEventReader eventReader = inputFactory.createXMLEventReader(is);
			Candy item = null;

			while (eventReader.hasNext()) {

				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();

					if (startElement.getName().getLocalPart().equals(TagsConstants.CANDY)) {
						item = new Candy();

						@SuppressWarnings("unchecked")
						Iterator<Attribute> attributes = startElement.getAttributes();
						Attribute attribute;

						while (attributes.hasNext()) {
							attribute = attributes.next();

							if (attribute.getName().toString().equals(TagsConstants.ID)) {
								item.setId(attribute.getValue());
							}
							if (attribute.getName().toString().equals(TagsConstants.TYPE)) {
								item.setType(attribute.getValue());
							}
							if (attribute.getName().toString().equals(TagsConstants.TOPPING)) {
								item.setTopping(attribute.getValue());
							}
						}

					}

					if (event.asStartElement().getName().getLocalPart().equals(TagsConstants.NAME)) {
						event = eventReader.nextEvent();
						item.setName(event.asCharacters().getData());
						continue;
					}
					if (event.asStartElement().getName().getLocalPart().equals(TagsConstants.ENERGY)) {
						event = eventReader.nextEvent();
						item.setEnergy(Integer.valueOf(event.asCharacters().getData()));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart().equals(TagsConstants.WATER)) {
						event = eventReader.nextEvent();
						item.getIngridients().setWater(Integer.valueOf(event.asCharacters().getData()));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart().equals(TagsConstants.SUGAR)) {
						event = eventReader.nextEvent();
						item.getIngridients().setSugar(Integer.valueOf(event.asCharacters().getData()));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart().equals(TagsConstants.FRUCTOSE)) {
						event = eventReader.nextEvent();
						item.getIngridients().setFructose(Integer.valueOf(event.asCharacters().getData()));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart().equals(TagsConstants.VANILLA)) {
						event = eventReader.nextEvent();
						item.getIngridients().setVanilla(Integer.valueOf(event.asCharacters().getData()));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart().equals(TagsConstants.CHOCOLATETYPE)) {
						event = eventReader.nextEvent();
						item.getIngridients().setChocolatetype(event.asCharacters().getData());
						continue;
					}
					if (event.asStartElement().getName().getLocalPart().equals(TagsConstants.PROTEINS)) {
						event = eventReader.nextEvent();
						item.getValue().setProteins(Integer.valueOf(event.asCharacters().getData()));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart().equals(TagsConstants.FATS)) {
						event = eventReader.nextEvent();
						item.getValue().setFats(Integer.valueOf(event.asCharacters().getData()));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart().equals(TagsConstants.CARBOHYDRATES)) {
						event = eventReader.nextEvent();
						item.getValue().setCarbohydrates(Integer.valueOf(event.asCharacters().getData()));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart().equals(TagsConstants.PRODUCTION)) {
						event = eventReader.nextEvent();
						item.setProduction(event.asCharacters().getData());
						continue;
					}

				}

				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart().equals(TagsConstants.CANDY)) {
						resultList.add(item);

					}

				}

			}

		} catch (FileNotFoundException | XMLStreamException e) {
			log.error(e.getMessage());
		}

		return resultList;
	}

}
