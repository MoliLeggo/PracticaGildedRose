package com.gildedrose.domain;

public class AgedBrieUpdater implements ItemUpdater {

    @Override
    public void updateQuality(Item item) {
        int sellIn = item.getSellIn();
        int quality = item.getQuality();
        sellIn--;
        if (sellIn < 0) {
            quality += 2;
        } else {
            quality += 1;
        }
        item.setSellIn(sellIn);
        item.setQuality(quality);
    }
}
