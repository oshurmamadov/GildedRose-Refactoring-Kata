package main.java.com.gildedrose.evaluators.impl;

import main.java.com.gildedrose.Item;
import main.java.com.gildedrose.evaluators.ItemEvaluator;
import main.java.com.gildedrose.utils.ItemUtils;

/**
 * Aged Brie item evaluator
 * 
 * Aged Brie increases in Quality the older it gets
 * The Quality of an item is never more than 50
 * 
 * @author Parviz_Oshurmamadov
 *
 */
public class AgedBrieItemEvaluator extends ItemEvaluator {
	
	private Item item;
	
	public AgedBrieItemEvaluator(Item item) {
		super(item);
		this.item = item;
	}

	@Override
	public Item evaluateItem() {
		decreaseSellIn();
		increaseQuality();
    	return item;
	}
		
	private void increaseQuality() {
		if (isQualityLessThanMax()) {
			item.quality++;
		}
	}
	
	private boolean isQualityLessThanMax() {
		return item.quality < ItemUtils.ITEM_MAX_QUALITY;
	}
}