package com.example.RegionsBook.models;

import lombok.Data;

@Data
public class Region {
    private Long id;
    private String name;
    private String abbrev;

    public Region() {
    }

    public Region(String name, String abbrev) {
        this.name = name;
        this.abbrev = abbrev;
    }

    public Region(Long id, String name, String abbrev) {
        this.id = id;
        this.name = name;
        this.abbrev = abbrev;
    }


}
