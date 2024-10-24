package com.gildedrose.infraestructure.service;

import com.gildedrose.domain.Item;

public class BackstagePassUpdater extends AbstractItemUpdater {
    @Override
    public void update(Item item) {
        dailyDegradation(item);
        qualityValidator(item);
        if (item.getSellIn() < 11 && item.getSellIn() > 5) {
            item.quality = item.getQuality() + 3;
        } else if (item.getSellIn() < 6 && item.getSellIn() > -1) {
            item.quality = item.getQuality() + 4;
        } else if (item.getSellIn() < 0) {
            item.quality = 0;
        } else {
            item.quality = item.getQuality() + 2;
        }
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
