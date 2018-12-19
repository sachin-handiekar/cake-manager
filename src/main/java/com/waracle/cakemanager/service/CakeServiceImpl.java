package com.waracle.cakemanager.service;

import com.waracle.cakemanager.domain.Cake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("cakeService")
@Transactional
public class CakeServiceImpl implements CakeService {

    @Autowired
    private CakeRepository cakeRepository;

    @Override
    public List<Cake> getAllCakes() {
        return cakeRepository.findAll();
    }

    @Override
    public void saveCake(Cake cake) {
        cakeRepository.saveAndFlush(cake);
    }

}
