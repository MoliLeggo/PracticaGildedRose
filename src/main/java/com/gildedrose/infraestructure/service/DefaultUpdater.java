package com.gildedrose.infraestructure.service;

import com.gildedrose.domain.Item;

public class DefaultUpdater extends AbstractItemUpdater {

    @Override
    public void update(Item item) {
        dailyDegradation(item);
        qualityValidator(item);
    }
    private void dailyDegradation(Item item) {
        item.sellIn = item.getSellIn() - 1;
        if (item.getSellIn() < 0) {
            item.quality = item.getQuality() - 2;
        } else {
            item.quality = item.getQuality() - 1;
        }
    }
}
