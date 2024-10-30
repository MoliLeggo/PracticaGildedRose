package com.gildedrose.domain;

import java.util.List;

public interface Item {
    String getName();
    int getSellIn();
    int getQuality();
    List<ItemType> getTypes();
    void updateQuality();

    // Default method for quality validation
    default void qualityValidator() {
        if (getQuality() < 0) {
            setQuality(0);
        }
        if (getQuality() > 50) {
            setQuality(50);
        }
    }
    void setSellIn(int sellIn);
    void setQuality(int quality);
}

