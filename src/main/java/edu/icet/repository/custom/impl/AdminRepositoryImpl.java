package edu.icet.repository.custom.impl;

import edu.icet.entity.AdminEntity;
import edu.icet.repository.custom.AdminRepository;
import edu.icet.util.CrudUtil;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
@Repository
public class AdminRepositoryImpl implements AdminRepository {
    @Override
    public ArrayList<AdminEntity> gettAll() {
        return null;
    }

    @Override
    public String getPassword(String email) {
        try {
             ResultSet resultSet= CrudUtil.execute("SELECT PASSWORD * ADMIN WHERE EMAIL = ?",email);
             resultSet.next();
             return resultSet.getString(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
