package edu.icet.serivce.custom;

import edu.icet.Model.Item;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Map;

public interface Itemservice {
    ArrayList<Item> getItem() ;


    boolean deleteItem(String itemID);


    boolean updateItem(Item item);

    boolean addItem(Item item);

    ResponseEntity<Map<String, Integer>> getCategory();
}
