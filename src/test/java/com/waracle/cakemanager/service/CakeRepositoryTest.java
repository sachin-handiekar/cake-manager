package com.waracle.cakemanager.service;

import com.waracle.cakemanager.domain.Cake;
import com.waracle.cakemanager.service.CakeRepository;
import com.waracle.cakemanager.service.CakesUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CakeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;


    @Autowired
    private CakeRepository cakeRepository;

    @Test
    public void testCakePersistAndSearch() {

        Cake cake = new Cake();

        cake.setDescription("Dummy description");
        cake.setImage("http://localhost:8080/img.src");
        cake.setTitle("Dummy Title");

        entityManager.persist(cake);
        entityManager.flush();

        List<Cake> cakeList = cakeRepository.findAll();

        assertNotNull(cakeList);
    }


    @Test
    public void testJPADelete() {

        Cake cake = new Cake();

        cake.setDescription("Dummy description");
        cake.setImage("http://localhost:8080/img.src");
        cake.setTitle("Dummy Title");

        entityManager.persist(cake);
        entityManager.flush();

        List<Cake> cakeList = cakeRepository.findAll();


        assertEquals(cakeList.size(), 1);

        cakeRepository.deleteAll();

        cakeList = cakeRepository.findAll();

        assertEquals(cakeList.size(), 0);


    }
}
