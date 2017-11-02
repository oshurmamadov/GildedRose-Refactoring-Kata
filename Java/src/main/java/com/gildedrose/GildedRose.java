package main.java.com.gildedrose;

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