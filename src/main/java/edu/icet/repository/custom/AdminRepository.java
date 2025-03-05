package edu.icet.repository.custom;

import edu.icet.entity.AdminEntity;
import edu.icet.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<AdminEntity> {
    String getPassword(String email);
}
