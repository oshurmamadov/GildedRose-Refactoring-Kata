package main.java.com.gildedrose.evaluators.impl;

import main.java.com.gildedrose.Item;
import main.java.com.gildedrose.evaluators.ItemEvaluator;
import main.java.com.gildedrose.utils.ItemQualityLevelValidator;
import main.java.com.gildedrose.utils.ItemUtils;

/**
 * Conjured item evaluator
 * 
 * Conjured items degrade in Quality twice as fast as normal items
 * 
 * @author Parviz_Oshurmamadov
 *
 */
public class ConjuredItemEvaluator extends ItemEvaluator {
	
	private Item item;
	
	public ConjuredItemEvaluator(Item item) {
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
		item.quality -= ItemUtils.ADJUST_QUALITY_BY_TWO;
	}
}