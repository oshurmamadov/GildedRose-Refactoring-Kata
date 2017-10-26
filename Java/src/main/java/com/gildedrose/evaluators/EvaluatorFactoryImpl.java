package main.java.com.gildedrose.evaluators;

import main.java.com.gildedrose.Item;
import main.java.com.gildedrose.common.ItemTypes;
import main.java.com.gildedrose.evaluators.impl.AgedBrieItemEvaluator;
import main.java.com.gildedrose.evaluators.impl.BackstageItemEvaluator;
import main.java.com.gildedrose.evaluators.impl.ConjuredItemEvaluator;
import main.java.com.gildedrose.evaluators.impl.StandardItemEvaluator;
import main.java.com.gildedrose.evaluators.impl.SulfurasItemEvaluator;

/**
 * Evaluator Factory implementation
 * 
 * @author Parviz_Oshurmamadov
 *
 */
public class EvaluatorFactoryImpl implements EvaluatorFactory{

	@Override
	public ItemEvaluator initEvaluator(Item itemToEvaluate) {
		switch(itemToEvaluate.name) {
			case ItemTypes.AGED_BRIE :
				return new AgedBrieItemEvaluator(itemToEvaluate);
			case ItemTypes.SULFURAS :
				return new SulfurasItemEvaluator(itemToEvaluate);
			case ItemTypes.BACKSTAGE :
				return new BackstageItemEvaluator(itemToEvaluate);
			case ItemTypes.CONJURED :
				return new ConjuredItemEvaluator(itemToEvaluate);
			default :
				return new StandardItemEvaluator(itemToEvaluate);
			
		}
	}
}
