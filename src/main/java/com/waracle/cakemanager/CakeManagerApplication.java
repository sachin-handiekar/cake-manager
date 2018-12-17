package com.waracle.cakemanager;

import com.waracle.cakemanager.service.CakesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CakeManagerApplication extends SpringBootServletInitializer {

    @Autowired
    private CakesUtil cakesUtil;

    public static void main(String[] args) {
        SpringApplication.run(CakeManagerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void importCakesData() {
        cakesUtil.initCakes();
    }

}
