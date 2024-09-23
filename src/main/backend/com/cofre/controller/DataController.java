package com.cofre.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cofre")
public class DataController {
    private List<Double> items = new ArrayList<>();

    @GetMapping("/items")
    public List<Double> getItems() {
        return items;
    }

    @PostMapping("/add")
    public void addItem(@RequestBody Double value) {
        items.add(value);
    }

    @GetMapping("/total")
    public Double getTotal() {
        return items.stream().mapToDouble(Double::doubleValue).sum();
    }
}
