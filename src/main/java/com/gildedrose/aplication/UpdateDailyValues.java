package com.gildedrose.aplication;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.ItemType;
import com.gildedrose.domain.UniversalItem;

import java.util.List;

public class UpdateDailyValues {

    private List<Item> items;

    public UpdateDailyValues(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        items.forEach(item -> {
                    int initialSellIn = item.getSellIn();
                    List<ItemType> types = item.getTypes();

                    // Verificar si el ítem es legendario y no modificar si lo es
                    if (types.contains(ItemType.LEGENDARY)) {
                        return;
                    }
                    if (types.isEmpty() || types.size() > 1) {
                        UniversalItem universalItem = new UniversalItem(item.getName(), initialSellIn, item.getQuality(), types);
                        universalItem.updateQuality();
                        item.setSellIn(universalItem.getSellIn());
                        item.setQuality(universalItem.getQuality());
                    } else {
                        item.updateQuality();
                        item.qualityValidator();
                    }
                    // Ajustar sellIn restando 1 solo una vez, si hay más de un tipo
                    if (item.getTypes().size() > 1) {
                        item.setSellIn(initialSellIn - (item.getTypes().size() - 1));
                    }
                }
        );
    }

    @Override
    public String toString() {
        String salida = "name, sellIn, quality" + "\n";

        for (Item item : items) {
            salida += item.getName() + ", " + item.getSellIn() + ", " + item.getQuality() + "\n";
        }
        return salida;
    }
}
