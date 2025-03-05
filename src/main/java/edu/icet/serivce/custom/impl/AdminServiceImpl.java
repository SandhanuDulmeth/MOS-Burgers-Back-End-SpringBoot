package edu.icet.serivce.custom.impl;

import edu.icet.entity.AdminEntity;
import edu.icet.repository.custom.AdminRepository;
import edu.icet.repository.custom.ItemRepository;
import edu.icet.serivce.custom.AdminService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Primary
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final ModelMapper mapper;


    @Override
    public String getPassword(String email) {

        return adminRepository.getPassword(email);
    }

}
