package main.java.com.gildedrose.evaluators;

import main.java.com.gildedrose.Item;
import main.java.com.gildedrose.common.ItemTypes;

/**
 * Item Evaluator Factory
 * 
 * @author Parviz_Oshurmamadov
 *
 */
public interface EvaluatorFactory {
	
	/*
	 * Initialize evaluator
	 */
	public ItemQualityEvaluator initEvaluator(Item item);
}
