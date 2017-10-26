package main.java.com.gildedrose;

import main.java.com.gildedrose.common.ItemTypes;
import main.java.com.gildedrose.evaluators.EvaluatorFactory;
import main.java.com.gildedrose.evaluators.EvaluatorFactoryImpl;
import main.java.com.gildedrose.evaluators.ItemEvaluator;
import main.java.com.gildedrose.evaluators.impl.AgedBrieItemEvaluator;
import main.java.com.gildedrose.evaluators.impl.BackstageItemEvaluator;
import main.java.com.gildedrose.evaluators.impl.ConjuredItemEvaluator;
import main.java.com.gildedrose.evaluators.impl.StandardItemEvaluator;
import main.java.com.gildedrose.evaluators.impl.SulfurasItemEvaluator;

public class GildedRose {
	public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(ItemTypes.AGED_BRIE)
                    && !items[i].name.equals(ItemTypes.BACKSTAGE)) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(ItemTypes.SULFURAS)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(ItemTypes.BACKSTAGE)) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals(ItemTypes.SULFURAS)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(ItemTypes.AGED_BRIE)) {
                    if (!items[i].name.equals(ItemTypes.BACKSTAGE)) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(ItemTypes.SULFURAS)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
    
    
    public void myUpdate() {
    	for(Item item : items) {
    		item = evaluateItem(item);
    	}
    }
    
    private Item evaluateItem(Item currentItem) {
    	return getItemEvaluator(currentItem).evaluateItem();
    }
    
    private ItemEvaluator getItemEvaluator(Item currentItem) {
    	return new EvaluatorFactoryImpl().initEvaluator(currentItem);
    }
}
