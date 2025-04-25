package edu.icet.repository.custom;

import edu.icet.entity.ItemEntity;
import edu.icet.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Map;

public interface ItemRepository extends CrudRepository<ItemEntity> {


    ResponseEntity<Map<String, Integer>> getCategory();
}
