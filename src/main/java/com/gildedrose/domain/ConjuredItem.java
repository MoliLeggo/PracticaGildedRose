package com.gildedrose.domain;

import java.util.List;

public class ConjuredItem implements Item {
    private String name;
    private int sellIn;
    private int quality;
    private List<ItemType> types;

    public ConjuredItem(String name, int sellIn, int quality, List<ItemType> types) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.types = types;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getSellIn() {
        return sellIn;
    }
    @Override
    public int getQuality() {
        return quality;
    }
    @Override
    public List<ItemType> getTypes() {
        return types;
    }
    @Override
    public void updateQuality() {

        sellIn--;
        if (sellIn < 0) {
            quality = quality -4;
        } else {
            quality = quality -2;
        }
        qualityValidator();
    }

    @Override
    public void setSellIn(int sellIn) {

    }
    @Override
    public void setQuality(int quality) {
        this.quality = quality;
    }
    @Override
    public String toString() {
        return name + ", " + sellIn + ", " + quality + "\n";
    }
}

