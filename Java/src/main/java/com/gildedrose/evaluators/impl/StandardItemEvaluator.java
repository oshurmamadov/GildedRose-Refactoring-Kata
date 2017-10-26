package main.java.com.gildedrose.evaluators.impl;

import main.java.com.gildedrose.Item;
import main.java.com.gildedrose.evaluators.ItemEvaluator;
import main.java.com.gildedrose.utils.ItemQualityLevelValidator;
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
public class StandardItemEvaluator extends ItemEvaluator {
	
	private Item item;
	
	public StandardItemEvaluator(Item item) {
		super(item);
		this.item = item;
	}

	@Override
	public Item evaluateItem() {
		decreaseSellIn();
		decreaseQuality();
    	return ItemQualityLevelValidator.validateAndReturn(item);
	}
	
	private void decreaseQuality() {
		if (item.sellIn < ItemUtils.SELL_IN_DAY) {
			item.quality -= ItemUtils.ADJUST_QUALITY_BY_TWO;
		} else {
			item.quality--;
		}
	}
}