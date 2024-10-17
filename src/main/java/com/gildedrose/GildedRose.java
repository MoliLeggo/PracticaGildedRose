package com.gildedrose;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }//constructor

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")// si no se llama aged
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {// y tampoco se llama backstage...
                if (items[i].quality > 0) {//si la calidad es mayor a 0
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {//si no se llama Sulfuras....
                        items[i].quality = items[i].quality - 1;//la calidad baja 1
                    }
                }
            } else {// si el nombre es Aged o Backstage
                if (items[i].quality < 50) {//si la calidad es menor que 50
                    items[i].quality = items[i].quality + 1;//calidad sube 1

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {// si se llama Backstage...
                        if (items[i].sellIn < 11) {//si sellIn es menor que 11
                            if (items[i].quality < 50) {//si la calidad es menor que 50
                                items[i].quality = items[i].quality + 1;//calidad sube 1
                            }//con lo cual si se llama Aged sube la calidad 1 si es inferior a 50 pero si se llama Backstage.. su be la calidad 2
                        }    // uno si es la calidad menor a 50 y otro si el sellIn es menor a 11

                        if (items[i].sellIn < 6) {//si sellIn es menor que 6
                            if (items[i].quality < 50) {//si calidad es menor que 50
                                items[i].quality = items[i].quality + 1;//calidad aumenta 1 con lo que la calidad de Backstage seria aumentada 2+1
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {// si no se llama Sulfuras
                items[i].sellIn = items[i].sellIn - 1;//el sellIn baja 1
            }

            if (items[i].sellIn < 0) {//si el sellIn es menor que 0, es decir negativo
                if (!items[i].name.equals("Aged Brie")) {//si no se llama aged
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {//si no se llama backstage
                        if (items[i].quality > 0) {//si la cualidad es mayor a 0
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {//si no se llama Sulfuras
                                items[i].quality = items[i].quality - 1;//la calidad baja 1
                            }
                        }
                    } else {//si el nombre es Backstage
                        items[i].quality = items[i].quality - items[i].quality;//su calidad sera la que tenga menos la que tenga es decir 0
                    }
                } else {//si el nombre es Aged
                    if (items[i].quality < 50) {//si la calidad es menor a 50
                        items[i].quality = items[i].quality + 1;// la calidad aumenta en 1
                    }
                }
            }
        }
    }
}