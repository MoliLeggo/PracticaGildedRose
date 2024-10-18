package com.gildedrose;

//leggo changes:

import java.util.List;
public class MiSolucion {
    public List<Item> items;
    public MiSolucion(List<Item> items) {
        this.items = items;
    }
    public void updateQuality() {

        for (Item itemx : items) {

            if (itemx.getName().equals("Aged Brie")) {
                dailyUpdateAged(itemx);

            }else if(itemx.getName().equals("Sulfuras, Hand of Ragnaros")) {

            }else if(itemx.getName().equals("Conjured Mana Cake")) {
                dailyUpdateConjured(itemx);

            }else if (itemx.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                dailyUpdateBackstage(itemx);

            }else{
                dailyDegradation(itemx);
            }
        }
    }
    public void dailyUpdateAged(Item item){

        item.sellIn = item.getSellIn() -1;

        if (item.getSellIn() < 0) {
            item.quality = item.getQuality() + 2;
        } else {
            item.quality = item.getQuality() + 1;
        }
        qualityValidator(item);
    }
    public void dailyUpdateConjured(Item item){

        item.quality = item.getQuality() - 1;
        dailyDegradation(item);
        qualityValidator(item);
    }
    public void dailyUpdateBackstage(Item item){

        dailyDegradation(item);
        qualityValidator(item);
        if (item.getSellIn() < 11 && item.getSellIn() > 5) {
            item.quality = item.getQuality() + 3;

        }
        else if(item.getSellIn() < 6 && item.getSellIn() > -1) {
            item.quality = item.getQuality() +4;
        }
        else if(item.getSellIn() < 0) {
            item.quality = 0;
        }else {
            item.quality = item.getQuality() +2;
        }
        qualityValidator(item);

    }

    public void dailyDegradation(Item item) {

        Item dailyDegradation = item;
        dailyDegradation.sellIn = dailyDegradation.getSellIn() - 1;
        if (dailyDegradation.getSellIn() < 0) {
            dailyDegradation.quality = dailyDegradation.getQuality() - 2;
        } else {
            dailyDegradation.quality = dailyDegradation.getQuality() - 1;
        }

        qualityValidator(dailyDegradation);
    }

    public void qualityValidator(Item item) {
        if (item.quality < 0) {
            item.quality = 0;
        }
        if (item.quality > 49) {
            item.quality = 50;
        }
    }

    @Override
    public String toString() {
        String salida = "name, sellIn, quality" + "\n" ;

        for (Item item : items){
            salida += item.getName() + ", " + item.getSellIn() + ", " + item.getQuality() + "\n";
        }
        return salida;
    }
}
