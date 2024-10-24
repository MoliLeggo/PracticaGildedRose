package com.gildedrose.domain;

public class Item {
    private ItemType name;
    public int sellIn;
    public int quality;

    public Item(ItemType name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {

        return this.name.getDisplayName() + ", " + this.sellIn + ", " + this.quality + "\n";
    }
    public ItemType getName() {
        return name;
    }
    public int getSellIn() {
        return sellIn;
    }
    public int getQuality() {
        return quality;
    }
}