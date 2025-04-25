package edu.icet.controller;


import edu.icet.Model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.icet.serivce.custom.Itemservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/itemController")
@RequiredArgsConstructor
public class ItemController {

    final Itemservice itemservice;

    @PostMapping("/add-Item")
    public ResponseEntity<String> addItem(@RequestBody Item item) {
        if(itemservice.addItem(item)){
            return ResponseEntity.ok("true");
        }else{
            return ResponseEntity.badRequest().body("false");
        }
    }

    @GetMapping("/get-Items")
    public ResponseEntity<ArrayList<Item>> getItem() {
        ArrayList<Item> items = itemservice.getItem();
        if (!items.isEmpty()) {
            return ResponseEntity.ok(items);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/get-Category")
    public ResponseEntity<Map<String, Integer>> getCategory() {
        ResponseEntity<Map<String, Integer>> response = itemservice.getCategory();
        Map<String, Integer> categoryMap = response.getBody();

        if (categoryMap == null || categoryMap.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(categoryMap);
        }
    }

    @DeleteMapping("/delete-Item/{itemId}")
    public ResponseEntity<String> addItem(@PathVariable String itemId) {
        if (itemservice.deleteItem(itemId)) {
            return ResponseEntity.ok("true");
        } else {
            return ResponseEntity.badRequest().body("false");
        }
    }

    @PatchMapping("/update-Item")
    public ResponseEntity<String> updateItem(@RequestBody Item item){
        if(itemservice.updateItem(item)){
            return ResponseEntity.ok("true");
        }else{
            return ResponseEntity.badRequest().body("false");
        }
    }





}
