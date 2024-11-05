package com.gildedrose.domain;

public class BackstagePassUpdater implements ItemUpdater {

    @Override
    public void updateQuality(Item item) {
        int sellIn = item.getSellIn();
        int quality = item.getQuality();
        sellIn--;
        if (sellIn < 11 && sellIn > 5) {
            quality += 3;
        } else if (sellIn < 6 && sellIn > -1) {
            quality += 4;
        } else if (sellIn < 0) {
            quality = 0;
        } else {
            quality += 2;
        }
        item.setSellIn(sellIn);
        item.setQuality(quality);
    }
}
