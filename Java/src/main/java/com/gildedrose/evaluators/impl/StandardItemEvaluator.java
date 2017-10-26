package main.java.com.gildedrose.evaluators.impl;

import main.java.com.gildedrose.Item;
import main.java.com.gildedrose.evaluators.ItemEvaluator;
import main.java.com.gildedrose.utils.ItemQualityValidator;
import main.java.com.gildedrose.utils.ItemUtils;

/**
 * Standard item evaluator.
 * 
 * Once the sell by date has passed, Quality degrades twice as fast
 * The Quality of an item is never negative
 *  
 * @author Parviz_Oshurmamadov
 *
 */
public class StandardItemEvaluator implements ItemEvaluator {
	
	private Item item;
	
	public StandardItemEvaluator(Item item) {
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
		if (item.sellIn < ItemUtils.SELL_IN_DAY) {
			item.quality -= ItemUtils.ADJUST_QUALITY_BY_TWO;
		} else {
			item.quality--;
		}
	}
}