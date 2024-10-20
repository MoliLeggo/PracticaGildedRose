package com.gildedrose;

public class Item {
    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality + "\n";
    }

    public String getName() {
        return name;
    }
    public int getSellIn() {
        return sellIn;
    }
    public int getQuality() {
        return quality;
    }


}