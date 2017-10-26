package main.java.com.gildedrose.utils;

import main.java.com.gildedrose.Item;

/**
 * This class validates if during increase or decrease processes quality is not more  
 * than 50 or less than 0
 * 
 * @author Parviz_Oshurmamadov
 *
 */
public class ItemQualityValidator {

	public static Item validate(Item item) {
		if (item.quality > ItemUtils.ITEM_MAX_QUALITY) {
			item.quality = ItemUtils.ITEM_MAX_QUALITY;
		} else if (item.quality < ItemUtils.ITEM_MIN_QUALITY) {
			item.quality = ItemUtils.ITEM_MIN_QUALITY;
		}
		return item;
	}
}
