package com.example.RegionsBook.service;

import com.example.RegionsBook.models.Region;
import com.example.RegionsBook.repo.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {
    public final RegionMapper regionMapper;

    @Autowired
    public RegionServiceImpl(RegionMapper regionMapper) {
        this.regionMapper = regionMapper;
    }

    @Override
    @Cacheable(value = "regions", key = "#id")
    public Region getRegion(long id) {
        Optional<Region> region = regionMapper.findById(id);
        return region.orElseGet(Region::new);
    }

    @Override
    @Cacheable(value = "allRegions")
    public List<Region> findAll() {
        return regionMapper.findAll();
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "regions", key = "#id"),
            @CacheEvict(value = "allRegions", allEntries = true)})
    public void deleteRegion(long id) {
        regionMapper.deleteById(id);
    }

    @Override
    @CacheEvict(value = "allRegions", allEntries = true)
    public void addRegion(Region region) {
        regionMapper.insert(region);
    }

    @Override
    @Caching(
            put = {
                    @CachePut(value = "regions", key = "#region.id")
            },
            evict = {
                    @CacheEvict(value = "allRegions", allEntries = true)})
    public void updateRegion(Region region) {
        regionMapper.update(region);
    }
}
