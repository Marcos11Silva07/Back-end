package com.cofre.controller;

import com.cofre.model.CofreItem;
import com.cofre.repository.CofreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cofre")
public class CofreController {

    @Autowired
    private CofreRepository cofreRepository;

    @PostMapping("/add")
    public ResponseEntity<CofreItem> addCofreItem(@RequestBody CofreItem cofreItem) {
        // Verifique se o 'value' está sendo enviado no request
        if (cofreItem.getValue() == null || cofreItem.getValue().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CofreItem savedItem = cofreRepository.save(cofreItem);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping("/items")
    public ResponseEntity<List<CofreItem>> getAllCofreItems() {
        List<CofreItem> items = cofreRepository.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/total")
    public ResponseEntity<Double> getTotalValue() {
        List<CofreItem> items = cofreRepository.findAll();
        double totalValue = items.stream().mapToDouble(item -> Double.parseDouble(item.getValue())).sum();
        return new ResponseEntity<>(totalValue, HttpStatus.OK);
    }
}
