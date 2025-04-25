package edu.icet.repository.custom.impl;

import edu.icet.entity.ItemEntity;
import edu.icet.repository.custom.ItemRepository;
import edu.icet.util.CrudUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    @Override
    public boolean save(ItemEntity entity) {
        try {
            return CrudUtil.execute("INSERT INTO item (itemno, itemtype, name, price, imageUrl) VALUES (?, ?, ?, ?, ?);",
                    entity.getItemNo(), entity.getItemType(), entity.getName(), entity.getPrice(), entity.getImageUrl());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean delete(String id) {
        try {
           return CrudUtil.execute("DELETE FROM item WHERE itemno = ?;", id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<ItemEntity> gettAll() {
        ArrayList<ItemEntity> itemEntities=new ArrayList<>();
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT * FROM item;");
            while (resultSet.next()) {
                itemEntities.add(new ItemEntity(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getString(5)
                ));
            }
            return itemEntities.isEmpty() ? null : itemEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean update(ItemEntity entity) {
        try {
            return CrudUtil.execute("UPDATE item SET itemtype = ?, name = ?, price = ?, imageUrl = ? WHERE itemno = ?;",
                    entity.getItemType(),
                    entity.getName(),
                    entity.getPrice(),
                    entity.getImageUrl(),
                    entity.getItemNo()
                    );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<Map<String, Integer>> getCategory() {
        Map<String, Integer> categoryMap = new HashMap<>();
        try {
            // Execute the query and get the ResultSet
            ResultSet resultSet = CrudUtil.execute("SELECT itemtype, COUNT(*) AS item_count FROM item GROUP BY itemtype");

            // Iterate through the ResultSet and populate the map
            while (resultSet.next()) {
                String itemType = resultSet.getString("itemtype");
                int count = resultSet.getInt("item_count");
                categoryMap.put(itemType, count);
            }

            // Return the map wrapped in a ResponseEntity
            return ResponseEntity.ok(categoryMap);
        } catch (SQLException e) {
            // Handle exceptions appropriately
            throw new RuntimeException("Failed to fetch item categories", e);
        }
    }
}
