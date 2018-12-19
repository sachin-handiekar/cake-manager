package com.waracle.cakemanager.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.cakemanager.domain.Cake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

@Service
public class CakesUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CakesUtil.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private CakeService cakeService;

    @Value("${cake.url.data}")
    private String cakeUrlData;

    public void initCakes() {
        try (InputStream inputStream = new URL(cakeUrlData).openStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder buffer = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                buffer.append(line);
                line = reader.readLine();
            }

            List<Cake> myObjects = mapper.readValue(buffer.toString(), new TypeReference<List<Cake>>() {
            });


            for (Cake cake : myObjects) {
                LOGGER.debug("Inserting cake in database : " + cake);
                cakeService.saveCake(cake);
            }

        } catch (Exception ex) {

            LOGGER.error("An error occurred while initializing database.", ex);
        }
    }
}
