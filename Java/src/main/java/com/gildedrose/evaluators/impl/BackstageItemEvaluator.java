package main.java.com.gildedrose.evaluators.impl;

import main.java.com.gildedrose.Item;
import main.java.com.gildedrose.evaluators.ItemEvaluator;
import main.java.com.gildedrose.utils.ItemQualityValidator;
import main.java.com.gildedrose.utils.ItemUtils;

/**
 * Backstage item evaluator
 * 
 * Backstage passes, like aged Aged Brie, increases in Quality as its SellIn value approaches
 * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
 * Quality drops to 0 after the concert
 * The Quality of an item is never more than 50
 * 
 * @author Parviz_Oshurmamadov
 *
 */
public class BackstageItemEvaluator implements ItemEvaluator {
	private static final int CONCERT_DAY = 0;
	private static final int FIVE_DAYS_TILL_CONCERT = 5;
	private static final int TEN_DAYS_TILL_CONCERT = 10;
	
	private Item item;
	
	public BackstageItemEvaluator(Item item) {
		this.item = item;
	}

	@Override
	public Item evaluateItem() {
		decreaseSellIn();
		alterItemQuality();
    	return ItemQualityValidator.validate(item);
	}
	
	private void decreaseSellIn() {
		item.sellIn--;
	}
	
	private void alterItemQuality() {
		if (item.sellIn <= TEN_DAYS_TILL_CONCERT && item.sellIn > FIVE_DAYS_TILL_CONCERT) {
			item.quality += ItemUtils.ADJUST_QUALITY_BY_TWO;
		} else if(item.sellIn <= FIVE_DAYS_TILL_CONCERT && item.sellIn >= CONCERT_DAY){
			item.quality += ItemUtils.ADJUST_QUALITY_BY_THREE;
		} else if(item.sellIn < CONCERT_DAY) {
			item.quality = ItemUtils.ITEM_MIN_QUALITY;
		} else {
			item.quality++;
		}
	}
}