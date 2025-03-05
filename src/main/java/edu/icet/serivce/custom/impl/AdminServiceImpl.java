package edu.icet.serivce.custom.impl;

import edu.icet.entity.AdminEntity;
import edu.icet.repository.custom.AdminRepository;
import edu.icet.repository.custom.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Primary
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminRepository {
    private final AdminRepository adminRepository;
    private final ModelMapper mapper;


    @Override
    public String getPassword(String email) {
        return adminRepository.getPassword(email);
    }

    @Override
    public ArrayList<AdminEntity> gettAll() {
        return null;
    }
}
