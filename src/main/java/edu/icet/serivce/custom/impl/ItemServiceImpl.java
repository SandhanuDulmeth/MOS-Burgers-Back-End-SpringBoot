package edu.icet.serivce.custom.impl;

import edu.icet.Model.Item;
import edu.icet.entity.ItemEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import edu.icet.repository.custom.ItemRepository;
import edu.icet.serivce.custom.Itemservice;

import java.util.ArrayList;
import java.util.Map;

@Service
@Primary
@RequiredArgsConstructor
public class ItemServiceImpl implements Itemservice {

    private final ItemRepository itemRepository;
    private final ModelMapper mapper;




    @Override
    public ArrayList<Item> getItem() {

                ArrayList<Item> items = new ArrayList<>();
        itemRepository.gettAll().forEach(itemEntity -> items.add(mapper.map(itemEntity, Item.class)));
        return items;
    }

    @Override
    public boolean deleteItem(String itemId) {
        return itemRepository.delete(itemId);

    }

    @Override
    public boolean updateItem(Item item) {
      return itemRepository.update(mapper.map(item, ItemEntity.class));
    }

    @Override
    public boolean addItem(Item item) {
       return itemRepository.save(mapper.map(item, ItemEntity.class));
    }

    @Override
    public ResponseEntity<Map<String, Integer>> getCategory() {
        return itemRepository.getCategory();
    }
}
