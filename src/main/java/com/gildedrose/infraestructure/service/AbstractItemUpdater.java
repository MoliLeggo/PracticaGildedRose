package com.gildedrose.infraestructure.service;

import com.gildedrose.domain.Item;

public abstract class AbstractItemUpdater implements ItemUpdater {

    protected void qualityValidator(Item item){
        if (item.quality < 0) {
            item.quality = 0;
        }
        if (item.quality > 49) {
            item.quality = 50;
        }
    }
}
