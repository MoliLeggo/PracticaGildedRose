package com.gildedrose.domain;

public class ConjuredUpdater implements ItemUpdater{

    @Override
    public void updateQuality(Item item) {
        int sellIn = item.getSellIn();
        int quality = item.getQuality();
        sellIn--; if (sellIn < 0) {
            quality -= 4;
        } else { quality -= 2;
        }
        item.setSellIn(sellIn);
        item.setQuality(quality);
    }
}

