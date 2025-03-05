package edu.icet.repository.custom;

import edu.icet.Model.Admin;
import edu.icet.entity.AdminEntity;
import edu.icet.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<AdminEntity> {
    String getPassword(String email);


    Admin findByEmail(String email);

    void save(Admin user);
}
