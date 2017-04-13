package by.training.epam.builders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SweetsBuildersPool implements Iterable<Class<? extends SweetsBuilder>> {

	private final List<Class<? extends SweetsBuilder>> buildersPool;
	
	{
		buildersPool = new ArrayList<>();
		buildersPool.add(ChocolateBarAirFunBuilder.class);
		buildersPool.add(ChocolateBarSpaceRaisinsBuilder.class);
		buildersPool.add(ChocolateBarSparnutsBuilder.class);
		buildersPool.add(ChocolateCandyAlenkaBuilder.class);
		buildersPool.add(ChocolateCandyKryzhachekBuilder.class);
		buildersPool.add(GingerbreadDruzhbaBuilder.class);
		buildersPool.add(LollipopBarbarisBuilder.class);
		buildersPool.add(LollipopBuratinoBuilder.class);
	}
	
	public int getPoolSize(){
		return buildersPool.size();
	}
	
	public Class<? extends SweetsBuilder> getCertainBuilder(int index){
		return buildersPool.get(index);
	}

	@Override
	public Iterator<Class<? extends SweetsBuilder>> iterator() {
		
		return buildersPool.iterator();

	}
}
