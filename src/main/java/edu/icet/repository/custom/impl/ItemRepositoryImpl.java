package edu.icet.repository.custom.impl;

import edu.icet.entity.ItemEntity;
import edu.icet.repository.custom.ItemRepository;
import edu.icet.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemRepositoryImpl implements ItemRepository {
//    String itemNo;
//    String itemType;
//    String name;
//    Double price;
//    String imageUrl;




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
                return itemEntities;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
