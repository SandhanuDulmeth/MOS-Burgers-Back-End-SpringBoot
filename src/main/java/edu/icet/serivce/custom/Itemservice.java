package edu.icet.serivce.custom;

import edu.icet.Model.Item;

import java.util.ArrayList;

public interface Itemservice {
    ArrayList<Item> getItem() ;


    boolean deleteItem(String itemID);


    boolean updateItem(Item item);

    boolean addItem(Item item);
}
