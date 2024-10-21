package com.gildedrose;

import com.gildedrose.aplication.MiSolucion;
import com.gildedrose.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class TexttestFixture {


    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40)//añado esta linea para testear calidad inferior
        };



        List<Item> test = new ArrayList<>();
        Item test1 = new Item("+5 Dexterity Vest", 10, 20);
        Item test2 = new Item("Aged Brie", 2, 0);
        Item test3 = new Item("Elixir of the Mongoose", 5, 7);
        Item test4 = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        Item test5 = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        Item test6 = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        Item test7 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        Item test8 = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        Item test9 = new Item("Conjured Mana Cake", 3, 6);

        test.add(test1);
        test.add(test2);
        test.add(test3);
        test.add(test4);
        test.add(test5);
        test.add(test6);
        test.add(test7);
        test.add(test8);
        test.add(test9);

        MiSolucion miSolucion = new MiSolucion(test);

        int days = 8;// testear con mas dias por defecto viene 2

        for (int i = 0; i < days; i++){
            System.out.println("..............Day " + i + "............" + "\n");
            System.out.println(miSolucion.toString().toString());
            miSolucion.updateQuality();
        }

    }
}
