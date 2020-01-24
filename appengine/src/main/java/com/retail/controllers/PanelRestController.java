package com.retail.controllers;

import com.retail.domain.Panel;
import com.retail.repos.PanelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PanelRestController {
    @Autowired
    private PanelRepo panelRepo;

    @GetMapping("/panels/")
    public Iterable<Panel> getAllPanels() {
        return panelRepo.findAll();
    }

    @GetMapping("/panels/{id}/")
    public Optional<Panel> getPanelById(@PathVariable(value = "id") Integer id) {
        return panelRepo.findById(id);
    }

    @PostMapping("/panels")
    public Panel createPanel(@Valid @RequestBody Panel panel) {
        return panelRepo.save(panel);
    }

    @PutMapping("/panels/{id}/")
    public Panel updatePanel(@PathVariable(value = "id") Integer id,
                             @Valid @RequestBody Panel panel) {
        panel.setId(id);

        return panelRepo.save(panel);

    }

    @DeleteMapping("/panels/{id}/")
    void deletePanel(@PathVariable Integer id) {
        panelRepo.deleteById(id);
    }
}