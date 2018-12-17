package com.waracle.cakemanager.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.cakemanager.domain.CakeEntity;
import com.waracle.cakemanager.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CakeController {

    @Autowired
    private CakeService cakeService;

    @GetMapping({"/", "/cakes"})
    public ModelAndView index() {
        List<CakeEntity> cakeEntityList = cakeService.getAllCakes();
        Map<String, Object> model = new HashMap<>();
        model.put("cakes", cakeEntityList);
        model.put("cake", new CakeEntity());

        return new ModelAndView("index", model);
    }

    @GetMapping({"/insertCake"})
    public ModelAndView insertCake() {

        Map<String, Object> model = new HashMap<>();
        model.put("cake", new CakeEntity());

        return new ModelAndView("insertCake", model);
    }

    @GetMapping(path = "/cakes", headers = {"Accept=application/json"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String cakeDataAsJSON() {
        List<CakeEntity> cakeEntityList = cakeService.getAllCakes();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInString;
        try {
            jsonInString = objectMapper.writeValueAsString(cakeEntityList);
        } catch (JsonProcessingException e) {
            jsonInString = "{ error : 'An error occurred' }";
        }

        return jsonInString;
    }

    @PostMapping("/cakes")
    public String addCake(@Valid @ModelAttribute("cake") CakeEntity cakeEntity,
                          BindingResult result, ModelMap model) {
        cakeService.saveCake(cakeEntity);
        model.addAttribute("success.save", "Cake Succesfully Inserted...");
        return "index";
    }
}
