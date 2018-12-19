package com.waracle.cakemanager.service;

import com.waracle.cakemanager.domain.Cake;

import java.util.List;

public interface CakeService {

    List<Cake> getAllCakes();

    void saveCake(Cake cake);

}
