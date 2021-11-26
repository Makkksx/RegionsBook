package com.example.RegionsBook.repo;

import com.example.RegionsBook.models.Region;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface RegionMapper {
    @Select("SELECT * FROM region WHERE id = #{id}")
    Optional<Region> findById(long id);

    @Select("SELECT * FROM region")
    List<Region> findAll();

    @Delete("DELETE FROM region WHERE id = #{id}")
    void deleteById(long id);

    @Insert("INSERT INTO region(name, abbrev) VALUES (#{name}, #{abbrev})")
    void insert(Region region);

    @Update("Update region set name=#{name}, abbrev=#{abbrev} where id=#{id}")
    void update(Region region);
}
