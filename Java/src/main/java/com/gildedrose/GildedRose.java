package gildedrose;

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
    	Evaluator evaluator;
    	for(Item item : items) {
    		evaluator = new Evaluator(item);
    		switch(item.name) {
	    		case ItemTypes.AGED_BRIE :
	    			item = evaluator.evaluateAgedBrieItem(item);
	    			break;
	    		case ItemTypes.SULFURAS :
	    			item = evaluator.evaluateSulfurasItem(item);
	    			break;
	    		case ItemTypes.BACKSTAGE :
	    			item = evaluator.evaluateBackstageItem(item);
	    			break;
	    		case ItemTypes.CONJURED :
	    			item = evaluator.evaluateConjuredItem(item);
	    			break;
	    		default :
	    			item = evaluator.evaluateStandardItem();
	    			break;
    		}
    	}
    }
    	
}
