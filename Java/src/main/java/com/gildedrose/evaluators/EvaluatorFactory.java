package main.java.com.gildedrose.evaluators;

import main.java.com.gildedrose.Item;

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
	public ItemEvaluator initEvaluator(Item item);
}
