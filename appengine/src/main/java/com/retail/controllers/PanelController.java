package com.retail.controllers;

import com.retail.domain.Panel;
import com.retail.repos.PanelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PanelController {
    @Autowired
    private PanelRepo panelRepo;

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Panel> panels = panelRepo.findAll();

        model.put("panels", panels);

        return  "main";

    }

    @PostMapping
    public String add(@RequestParam String name, @RequestParam int amount, @RequestParam String section,
                      @RequestParam String manufacturer, @RequestParam String technicalCharacteristics,
                      @RequestParam String address, @RequestParam String image, Map<String, Object> model){
        Panel panel = new Panel(name,amount,section,manufacturer,technicalCharacteristics,address, image);

        panelRepo.save(panel);

        Iterable<Panel> panels = panelRepo.findAll();

        model.put("panels", panels);

        return "main";
    }

}

