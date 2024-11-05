package com.gildedrose.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniversalItem implements Item{
    private String name;
    private int sellIn;
    private int quality;
    private List<ItemType> types;

    private static final Map<ItemType, ItemUpdater> updaterMap = new HashMap<>();

    static {
        updaterMap.put(ItemType.AGED_BRIE, new AgedBrieUpdater());
        updaterMap.put(ItemType.CONJURED, new ConjuredUpdater());
        updaterMap.put(ItemType.LEGENDARY, new LegendaryUpdater());
        updaterMap.put(ItemType.BACKSTAGE_PASS, new BackstagePassUpdater());
        // Agrega más tipos aquí según sea necesario
    }
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
            types.forEach(type -> {
                ItemUpdater updater = updaterMap.getOrDefault(type, item -> updateDefault());
                updater.updateQuality(this);
            });
        }
        qualityValidator(); // Validar la calidad

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
    public String toString() {
        return name + ", " + sellIn + ", " + quality + "\n";
    }
}
