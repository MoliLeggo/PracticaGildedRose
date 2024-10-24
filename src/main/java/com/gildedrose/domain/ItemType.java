package com.gildedrose.domain;

public enum ItemType {
    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    CONJURED("Conjured Mana Cake"),
    BACKSTAGE_PASS("Backstage passes to a TAFKAL80ETC concert"),
    ELIXIR("Elixir of the Mongoose"),
    AGED_BRIE_CONJURED("Aged Brie Conjured");

    private final String displayName;

    ItemType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
