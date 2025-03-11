package edu.icet.repository.custom.impl;

import edu.icet.entity.ItemEntity;
import edu.icet.repository.custom.ItemRepository;
import edu.icet.util.CrudUtil;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
@Repository
public class ItemRepositoryImpl implements ItemRepository {

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

}
