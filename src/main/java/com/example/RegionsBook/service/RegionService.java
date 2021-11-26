package com.example.RegionsBook.service;

import com.example.RegionsBook.models.Region;

import java.util.List;

public interface RegionService {
    Region getRegion(long id);

    List<Region> findAll();

    void deleteRegion(long id);

    void addRegion(Region region);

    void updateRegion(Region region);
}
