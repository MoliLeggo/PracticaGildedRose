package com.gildedrose.domain;

import java.util.List;

public class AgedBrieItem implements Item {
    private String name;
    private int sellIn;
    private int quality;
    private List<ItemType> types;

    public AgedBrieItem(String name, int sellIn, int quality, List<ItemType> types) {
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
            quality += 2;// Suma el valor del operando derecho del valor del operando izquierdo y luego asigna el resultado al operando izquierdo.
        } else {
            quality += 1;
        }
        qualityValidator();
    }
    @Override
    public void setQuality(int quality) {
        this.quality = quality;
    }
    @Override
    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }
    @Override
    public String toString() {
        return name + ", " + sellIn + ", " + quality + "\n";
    }
}
