package main.java.com.gildedrose.utils;

import main.java.com.gildedrose.Item;

/**
 * This class validates if during increase or decrease processes quality is not more  
 * than 50 or less than 0
 * 
 * @author Parviz_Oshurmamadov
 *
 */
public class ItemQualityLevelValidator {
	private Item item;
	
	public static Item validateAndReturn(Item item) {
		new ItemQualityLevelValidator(item).validate();
		return item;
	}
	
	private ItemQualityLevelValidator(Item item) {
		this.item = item;
	}
	
	private void validate() {
		validateAgainstMaximum();
		validateAgainstMinimum();
	}
	
	private void validateAgainstMaximum() {
		item.quality = item.quality > ItemUtils.ITEM_MAX_QUALITY ? 
				ItemUtils.ITEM_MAX_QUALITY : item.quality;
	}
	
	private void validateAgainstMinimum() {
		item.quality = item.quality < ItemUtils.ITEM_MIN_QUALITY ?
				ItemUtils.ITEM_MIN_QUALITY : item.quality;
	}
}
