package com.shang.canteenreviewsystemdemo.service.impl;

import com.shang.canteenreviewsystemdemo.model.Canteen;
import com.shang.canteenreviewsystemdemo.repository.CanteenRepository;
import com.shang.canteenreviewsystemdemo.service.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanteenServiceImpl implements CanteenService {
    @Autowired
    private CanteenRepository canteenRepository;

    @Override
    public List<Canteen> getCanteenList() {
        return canteenRepository.findAll();
    }
}
