package main.java.com.gildedrose;

public class ItemEvaluator {
	
	private Item item;
	
	public ItemEvaluator(Item item) {
		this.item = item;
	}

	public Item evaluateStandardItem() {
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

	public Item evaluateAgedBrieItem(Item item) {
		return item;
    }
    
	public Item evaluateSulfurasItem(Item item) {
    	return item;
    }
    
	public Item evaluateBackstageItem(Item item) {
    	return item;
    }
    
	public Item evaluateConjuredItem(Item item) {
    	return item;
    }
}