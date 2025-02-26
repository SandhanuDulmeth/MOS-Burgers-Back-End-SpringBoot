package edu.icet.controller;


import edu.icet.Model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.icet.serivce.custom.Itemservice;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/itemController")
@RequiredArgsConstructor
public class ItemController {

    final Itemservice itemservice;

    @GetMapping("/get-Items")
    public ArrayList<Item> getItem() {

        return itemservice.getItem();}


}
