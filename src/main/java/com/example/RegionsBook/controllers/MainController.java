package com.example.RegionsBook.controllers;

import com.example.RegionsBook.models.Region;
import com.example.RegionsBook.service.RegionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {
    public final RegionServiceImpl regionService;

    @Autowired
    public MainController(RegionServiceImpl regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllRegions() {
        return new ResponseEntity<>(regionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getRegionById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(regionService.getRegion(id), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> newRegion(@RequestBody Region region) {
        regionService.addRegion(region);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRegionById(@PathVariable("id") Long id) {
        regionService.deleteRegion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRegion(@RequestBody Region region) {
        regionService.deleteRegion(region.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateRegion(@RequestBody Region region) {
        regionService.updateRegion(region);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
