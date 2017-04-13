package by.training.epam.builders;

import java.util.ArrayList;
import java.util.List;

import by.training.epam.entity.Candy;
import by.training.epam.entity.CandyBean;

public class BeanBuilder {

	public static List<CandyBean> buildCandyBeanList(List<Candy> listOfCandy){
		
		List<CandyBean> resultList = new ArrayList<>();
		
		for (Candy candy : listOfCandy) {
			
			CandyBean bean = new CandyBean();
			
			bean.setId(candy.getId());
			bean.setType(candy.getType());
			bean.setEnergy(candy.getEnergy());
			bean.setName(candy.getName());
			bean.setWater(candy.getIngridients().getWater());
			bean.setSugar(candy.getIngridients().getSugar());
			bean.setVanilla(candy.getIngridients().getVanilla());
			bean.setFructose(candy.getIngridients().getFructose());
			if (candy.getIngridients().getChocolatetype() != null){
				bean.setChocolatetype(candy.getIngridients().getChocolatetype());
			} else {
				bean.setChocolatetype("");
			}
			bean.setProteins(candy.getValue().getProteins());
			bean.setFats(candy.getValue().getFats());
			bean.setCarbohydrates(candy.getValue().getCarbohydrates());
			bean.setProduction(candy.getProduction());
			if(candy.getTopping() != null){
				bean.setTopping(candy.getTopping());
			} else {
				bean.setTopping("");
			}
			
			resultList.add(bean);
			
		}
		
		return resultList;
	}
	
}
