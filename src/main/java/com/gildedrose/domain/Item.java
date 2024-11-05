package com.gildedrose.domain;

import java.util.List;

public interface Item {
    String getName();
    int getSellIn();
    int getQuality();
    List<ItemType> getTypes();
    void updateQuality();

    default void updateDefault() {
        setSellIn(getSellIn() - 1);
        if (getSellIn() < 0) {
            setQuality(getQuality() -2);
        } else {
            setQuality(getQuality() - 1);
        }
    }

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

