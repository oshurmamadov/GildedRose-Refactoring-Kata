package main.java.com.gildedrose.evaluators;

import main.java.com.gildedrose.Item;

/**
 * Item Evaluator abstract class
 * 
 * @author Parviz_Oshurmamadov
 *
 */
public abstract class ItemEvaluator {

	private Item item;

	public ItemEvaluator(Item item) {
		this.item = item;
	}
	
	/*
	 * Decrease sell in
	 */
	public void decreaseSellIn() {
		item.sellIn--;
	}
	
	/*
	 * Evaluate Item
	 */
	public abstract Item evaluateItem();
}
