package edu.icet.repository.custom.impl;

import edu.icet.Model.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.repository.custom.CustomerRepository;
import edu.icet.util.CrudUtil;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class customerRepositoryImpl implements CustomerRepository {
    @Override
    public boolean delete(String id) {
        try {
            return CrudUtil.execute("DELETE FROM customers WHERE id = ?;", id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ArrayList<CustomerEntity> gettAll() {
        ArrayList<CustomerEntity> CustomerEntities = new ArrayList<>();
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT * FROM customers;");
            while (resultSet.next()) {
                CustomerEntities.add(new CustomerEntity(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));
            }
            return CustomerEntities.isEmpty() ? null : CustomerEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean update(CustomerEntity entity) {
        try {
            return CrudUtil.execute("UPDATE customers SET  name = ?, email = ?, phone = ? ,address= ? WHERE itemno = ?;",
                    entity.getName(),
                    entity.getEmail(),
                    entity.getPhone(),
                    entity.getAddress()
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


