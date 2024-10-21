package com.gildedrose;

import com.gildedrose.aplication.MiSolucion;
import com.gildedrose.domain.Item;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiSolucionTest {
    private MiSolucion miSolucion;
    @BeforeEach
    public void setUp() {
        List<Item> items = Arrays.asList(
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6)
        );
        miSolucion = new MiSolucion(items);
    }

    @Test
    public void testUpdateQuality() {
        miSolucion.updateQuality();

        Item agedBrie = miSolucion.items.get(0);
        assertEquals("Aged Brie", agedBrie.getName());
        assertEquals(1, agedBrie.getSellIn());
        assertEquals(1, agedBrie.getQuality());

        Item elixir = miSolucion.items.get(1);
        assertEquals("Elixir of the Mongoose", elixir.getName());
        assertEquals(4, elixir.getSellIn());
        assertEquals(6, elixir.getQuality());

        Item sulfuras = miSolucion.items.get(2);
        assertEquals("Sulfuras, Hand of Ragnaros", sulfuras.getName());
        assertEquals(0, sulfuras.getSellIn());
        assertEquals(80, sulfuras.getQuality());

        Item backstage = miSolucion.items.get(3);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstage.getName());
        assertEquals(14, backstage.getSellIn());
        assertEquals(21, backstage.getQuality());

        Item conjured = miSolucion.items.get(4);
        assertEquals("Conjured Mana Cake", conjured.getName());
        assertEquals(2, conjured.getSellIn());
        assertEquals(4, conjured.getQuality());
    }
}
