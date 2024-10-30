package com.gildedrose.domain;

import java.util.List;

public class BackstagePassItem implements Item{

    private String name;
    private int sellIn;
    private int quality;
    private List<ItemType> types;

    public BackstagePassItem(String name, int sellIn, int quality, List<ItemType> types) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.types = types;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getSellIn() {
        return sellIn;
    }

    @Override
    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    @Override
    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public List<ItemType> getTypes() {
        return types;
    }
    @Override
    public void updateQuality() {
        sellIn --;
        if (getSellIn() < 11 && getSellIn() > 5) {
            quality +=  3;
        } else if (getSellIn() < 6 && getSellIn() > -1) {
            quality += 4;
        } else if (getSellIn() < 0) {
            quality = 0;
        } else {
            quality += 2;
        }
        qualityValidator();
    }

    @Override
    public String toString() {
        return name + ", " + sellIn + ", " + quality + "\n";
    }
}
