package com.gildedrose;

import com.gildedrose.aplication.UpdateDailyValues;
import com.gildedrose.domain.Item;
import com.gildedrose.domain.ItemType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateDailyValuesTest {
    private UpdateDailyValues updateDailyValues;
    private List<Item> items;

    @BeforeEach
    public void setUp() {
        items = Arrays.asList(
                new Item(ItemType.AGED_BRIE, 2, 0),
                new Item(ItemType.ELIXIR, 5, 7),
                new Item(ItemType.SULFURAS, 0, 80),
                new Item(ItemType.BACKSTAGE_PASS, 15, 20),
                new Item(ItemType.CONJURED, 3, 6),
                new Item(ItemType.AGED_BRIE_CONJURED, 2, 0)
        );
        updateDailyValues = new UpdateDailyValues(items);
    }

    @Test
    public void testUpdateQualityAgedBrie() {
        Item agedBrie = items.get(0);
        updateDailyValues.updateQuality();

        assertEquals(ItemType.AGED_BRIE.getDisplayName(), agedBrie.getName().getDisplayName());
        assertEquals(1, agedBrie.getSellIn());
        assertEquals(1, agedBrie.getQuality());
    }

    @Test
    public void testUpdateQualityElixir() {
        Item elixir = items.get(1);
        updateDailyValues.updateQuality();

        assertEquals(ItemType.ELIXIR.getDisplayName(), elixir.getName().getDisplayName());
        assertEquals(4, elixir.getSellIn());
        assertEquals(6, elixir.getQuality());
    }

    @Test
    public void testUpdateQualitySulfuras() {
        Item sulfuras = items.get(2);
        updateDailyValues.updateQuality();

        assertEquals(ItemType.SULFURAS.getDisplayName(), sulfuras.getName().getDisplayName());
        assertEquals(0, sulfuras.getSellIn());
        assertEquals(80, sulfuras.getQuality());
    }

    @Test
    public void testUpdateQualityBackstagePass() {
        Item backstage = items.get(3);
        updateDailyValues.updateQuality();

        assertEquals(ItemType.BACKSTAGE_PASS.getDisplayName(), backstage.getName().getDisplayName());
        assertEquals(14, backstage.getSellIn());
        assertEquals(21, backstage.getQuality());
    }
    @Test
    public void testUpdateQualityConjured() {
        Item conjured = items.get(4);
        updateDailyValues.updateQuality();

        assertEquals(ItemType.CONJURED.getDisplayName(), conjured.getName().getDisplayName());
        assertEquals(2, conjured.getSellIn());
        assertEquals(4, conjured.getQuality());
    }
    @Test
    public void testUpdateQualityAgedBrieConjured() {
        Item agedBrieConjured = items.get(5);
        updateDailyValues.updateQuality();

        assertEquals(ItemType.AGED_BRIE_CONJURED.getDisplayName(), agedBrieConjured.getName().getDisplayName());
        assertEquals(1, agedBrieConjured.getSellIn());
        assertEquals(0, agedBrieConjured.getQuality());
    }
}
