package main.java.com.gildedrose.evaluators;

import main.java.com.gildedrose.Item;

public class BackstageItemEvaluator implements ItemEvaluator {
	
	private Item item;
	
	public BackstageItemEvaluator(Item item) {
		this.item = item;
	}

	@Override
	public Item evaluateItem() {
		decreaseSellIn();
		decreaseQualityForStandardItem();
		
    	return item;
	}
	
	private void decreaseSellIn() {
		item.sellIn--;
	}
	
	private void decreaseQualityForStandardItem() {
		if (item.sellIn < 0)
			item.quality = item.quality - 2;
		else
			item.quality--;
		
		if (item.quality < 0)
			item.quality = 0;
	}
}