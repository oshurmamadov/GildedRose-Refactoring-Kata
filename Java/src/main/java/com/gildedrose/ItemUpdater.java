package main.java.com.gildedrose;

import main.java.com.gildedrose.evaluators.EvaluatorFactoryImpl;
import main.java.com.gildedrose.evaluators.ItemEvaluator;

/**
 * Item updater
 * 
 * @author Parviz_Oshurmamadov
 *
 */
public class ItemUpdater {

	private Item item;
	
	public static Item update(Item item) {
		return new ItemUpdater(item).update();
	}
	
	private ItemUpdater(Item item) {
		this.item = item;
	}
	
	private Item update() {
		return getItemEvaluator().evaluateItem();
	}
	
    private ItemEvaluator getItemEvaluator() {
    	return new EvaluatorFactoryImpl().initEvaluator(item);
    }
}
