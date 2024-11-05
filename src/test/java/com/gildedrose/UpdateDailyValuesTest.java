package com.gildedrose;


import com.gildedrose.aplication.UpdateDailyValues;
import com.gildedrose.domain.*;
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
                new UniversalItem("Aged Brie", 2, 0, List.of(ItemType.AGED_BRIE)),
                new UniversalItem("Conjured Mana Cake", 3, 16, List.of(ItemType.CONJURED)),
                new UniversalItem("Universal", 6, 20, List.of(ItemType.AGED_BRIE, ItemType.CONJURED)),
                new UniversalItem("Backstage", 20, 20, List.of(ItemType.BACKSTAGE_PASS)),
                new UniversalItem("Sulfuras, Hand of Ragnaros", 0, 80, List.of(ItemType.LEGENDARY)),
                new UniversalItem("Leggo staff", 2, 3, List.of(ItemType.CONJURED, ItemType.AGED_BRIE, ItemType.LEGENDARY))
        );
        updateDailyValues = new UpdateDailyValues(items);
    }

    @Test
    public void testFourDaysDegradation() {
        for (int day = 1; day <= 4; day++) {
            updateDailyValues.updateQuality();
        }

        // Verificar resultados después de 4 días
        Item agedBrie = items.get(0);
        Item conjured = items.get(1);
        Item agedBrieConjured = items.get(2);
        Item backStage = items.get(3);
        Item legendary = items.get(4);
        Item conjuredLegendaryAgedBrie = items.get(5);

        // Aged Brie después de 4 días
        assertEquals("Aged Brie", agedBrie.getName());
        assertEquals(-2, agedBrie.getSellIn());
        assertEquals(6, agedBrie.getQuality());

        // Conjured Mana Cake después de 4 días
        assertEquals("Conjured Mana Cake", conjured.getName());
        assertEquals(-1, conjured.getSellIn());
        assertEquals(6, conjured.getQuality());

        // Aged Brie Conjured después de 4 días
        assertEquals("Universal", agedBrieConjured.getName());
        assertEquals(2, agedBrieConjured.getSellIn());
        assertEquals(16, agedBrieConjured.getQuality());

        //BackStage despues de 4 dias
        assertEquals("Backstage", backStage.getName());
        assertEquals(16, backStage.getSellIn());
        assertEquals(28, backStage.getQuality());

        //Legendary despues de 4 dias
        assertEquals("Sulfuras, Hand of Ragnaros", legendary.getName());
        assertEquals(0, legendary.getSellIn());
        assertEquals(80, legendary.getQuality());

        //Conjured Aged y Legendary despues de 4 dias
        assertEquals("Leggo staff", conjuredLegendaryAgedBrie.getName());
        assertEquals(2, conjuredLegendaryAgedBrie.getSellIn());
        assertEquals(3, conjuredLegendaryAgedBrie.getQuality());


    }
}
