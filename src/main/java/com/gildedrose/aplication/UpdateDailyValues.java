package com.gildedrose.aplication;

import com.gildedrose.domain.Item;
import com.gildedrose.infraestructure.ItemsService;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class UpdateDailyValues {

    public ItemsService itemsService = new ItemsService();
    public List<Item> items;
    public final Map<String, Consumer<Item>> updateMethods;
    public UpdateDailyValues(List<Item>items) {
        this.items = items;
        this.updateMethods = Map.of(
                "Aged Brie", itemsService::dailyUpdateAged,
                "Sulfuras, Hand of Ragnaros", item -> {},
                "Conjured Mana Cake", itemsService::dailyUpdateConjured,
                "Backstage passes to a TAFKAL80ETC concert", itemsService::dailyUpdateBackstage
        );
    }

    public void updateQuality() {
        items.stream()
                .collect(Collectors.groupingBy(item -> updateMethods.getOrDefault(item.getName().getDisplayName(), itemsService::dailyDegradation)))
                .forEach((updateMethod, itemList) -> itemList.forEach(updateMethod::accept));
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
