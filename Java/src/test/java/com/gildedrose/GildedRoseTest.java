package test.java.com.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.com.gildedrose.GildedRose;
import main.java.com.gildedrose.Item;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

}
