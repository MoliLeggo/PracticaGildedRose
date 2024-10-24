package com.gildedrose.aplication;

import com.gildedrose.domain.Item;
import com.gildedrose.infraestructure.service.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UpdateDailyValues {

    public List<Item> items;
    public final Map<String, ItemUpdater> updateMethods;
    public UpdateDailyValues(List<Item>items) {
        this.items = items;
        this.updateMethods = Map.of(
                "Aged Brie", new AgedBrieUpdater(),
                "Sulfuras, Hand of Ragnaros", item -> {},
                "Conjured Mana Cake", new ConjuredUpdater(),
                "Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater()
        );
    }

    public void updateQuality() {
        items.stream()
                .collect(Collectors.groupingBy(item -> updateMethods.getOrDefault(item.getName().getDisplayName(), new DefaultUpdater())))
                .forEach((updateMethod, itemList) -> itemList.forEach(updateMethod::update));
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
