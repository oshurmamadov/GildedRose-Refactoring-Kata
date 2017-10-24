package main.java.com.gildedrose.evaluators.impl;

import main.java.com.gildedrose.Item;
import main.java.com.gildedrose.ItemQualityValidator;
import main.java.com.gildedrose.evaluators.ItemEvaluator;
import main.java.com.gildedrose.utils.ItemUtils;

/**
 * Conjured item evaluator
 * 
 * Conjured items degrade in Quality twice as fast as normal items
 * 
 * @author Parviz_Oshurmamadov
 *
 */
public class ConjuredItemEvaluator implements ItemEvaluator {
	
	private Item item;
	
	public ConjuredItemEvaluator(Item item) {
		this.item = item;
	}

	@Override
	public Item evaluateItem() {
		decreaseSellIn();
		decreaseQuality();
		
    	return ItemQualityValidator.validate(item);
	}
	
	private void decreaseSellIn() {
		item.sellIn--;
	}
	
	private void decreaseQuality() {
		item.quality = item.quality - ItemUtils.ADJUST_QUALITY_BY_TWO;
	}
}