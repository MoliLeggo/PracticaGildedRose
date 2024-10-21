package com.gildedrose.aplication;

import com.gildedrose.domain.Item;
import com.gildedrose.infraestructure.repositories.ItemsRepository;

import java.util.List;
public class MiSolucion {

    public ItemsRepository itemsRepository = new ItemsRepository();
    public List<Item> items;
    public MiSolucion(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item itemx : items) {

            if (itemx.getName().equals("Aged Brie")) {
                itemsRepository.dailyUpdateAged(itemx);

            }else if(itemx.getName().equals("Sulfuras, Hand of Ragnaros")) {

            }else if(itemx.getName().equals("Conjured Mana Cake")) {
                itemsRepository.dailyUpdateConjured(itemx);

            }else if (itemx.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                itemsRepository.dailyUpdateBackstage(itemx);

            }else{
                itemsRepository.dailyDegradation(itemx);
            }
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
