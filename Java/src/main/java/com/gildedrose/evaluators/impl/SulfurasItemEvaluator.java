package main.java.com.gildedrose.evaluators.impl;

import main.java.com.gildedrose.Item;
import main.java.com.gildedrose.evaluators.ItemEvaluator;

/**
 * Sulfuras, being a legendary item, never has to be sold or decreases in Quality
 * 
 * Always should remain the same
 * 
 * @author Parviz_Oshurmamadov
 *
 */
public class SulfurasItemEvaluator implements ItemEvaluator {
	
	private Item item;
	
	public SulfurasItemEvaluator(Item item) {
		this.item = item;
	}

	@Override
	public Item evaluateItem() {
		return item;
	}
}