package com.waracle.cakemanager.service;

import com.waracle.cakemanager.domain.CakeEntity;

import java.util.List;

public interface CakeService {

    List<CakeEntity> getAllCakes();

    void saveCake(CakeEntity cake);

}
