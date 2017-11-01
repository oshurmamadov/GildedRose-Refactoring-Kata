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
    	for(Item item : items) {
    		item = ItemUpdater.update(item);
    	}
    }
}