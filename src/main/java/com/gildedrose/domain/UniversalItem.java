package com.gildedrose.domain;

import java.util.List;

public class UniversalItem implements Item{
    private String name;
    private int sellIn;
    private int quality;
    private List<ItemType> types;
    public UniversalItem(String name, int sellIn, int quality, List<ItemType> types) {
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
        if (types.isEmpty()) {
            updateDefault();
        } else {
            types.forEach(this::applyUpdate);
        }
        qualityValidator();
    }
    private void applyUpdate(ItemType type) {
        switch (type) {
            case AGED_BRIE:
                AgedBrieItem agedBrie = new AgedBrieItem(name, sellIn, quality, types);
                agedBrie.updateQuality();
                this.sellIn = agedBrie.getSellIn();
                this.quality = agedBrie.getQuality();
                break;
            case CONJURED:
                ConjuredItem conjured = new ConjuredItem(name, sellIn, quality, types);
                conjured.updateQuality();
                this.sellIn = conjured.getSellIn();
                this.quality = conjured.getQuality();
                break;
            // Agrega más casos aquí según sea necesario
            default:
                updateDefault();
                break;
        }
    }
    private void updateDefault() {
        sellIn--;
        if (sellIn < 0) {
            quality -= 2;// Suma el valor del operando derecho del valor del operando izquierdo y luego asigna el resultado al operando izquierdo.
        } else {
            quality -= 1;
        }
        qualityValidator();
    }
    @Override
    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }
    @Override
    public void setQuality(int quality) {
        this.quality = quality;
    }
    @Override
    public void qualityValidator() {
        if (quality < 0) {
            quality = 0;
        }
        if (quality > 50) {
            quality = 50;
        }
    }
    @Override
    public String toString() {
        return name + ", " + sellIn + ", " + quality + "\n";
    }
}
