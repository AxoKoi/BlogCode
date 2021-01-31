package com.axokoi.misc.post20200727;

public class PlantBuilder {
    private final int id;
    private int age = -1;
    private int size = -1;
    private String color = "";
    private String scientificName = "";
    private String climate = "";
    private String lightPreference = "";

    public PlantBuilder(int id) {
        this.id = id;
    }

    public PlantBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PlantBuilder setSize(int size) {
        this.size = size;
        return this;
    }

    public PlantBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public PlantBuilder setScientificName(String scientificName) {
        this.scientificName = scientificName;
        return this;
    }

    public PlantBuilder setClimate(String climate) {
        this.climate = climate;
        return this;
    }

    public PlantBuilder setLightPreference(String lightPreference) {
        this.lightPreference = lightPreference;
        return this;
    }

    public Plant build() {
        return new Plant(id, age, size, color, scientificName, climate, lightPreference);
    }
}
