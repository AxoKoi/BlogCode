package com.axokoi.misc.post20200727;

public class PlantWithTelescopicConstructors {
    //Mandatory
    private int id;
    //Optional
    private int age;
    private int size;
    private String color;
    private String scientificName;
    private String climate;
    private String lightPreference;

    public PlantWithTelescopicConstructors(int id) {
        this(id, -1);
    }

    public PlantWithTelescopicConstructors(int id, int age) {
        this(id, age, -1);
    }

    public PlantWithTelescopicConstructors(int id, int age, int size) {
        this(id, age, size, "");
    }

    public PlantWithTelescopicConstructors(int id, int age, int size, String color) {
        this(id, age, size, color, "");
    }

    public PlantWithTelescopicConstructors(int id, int age, int size, String color, String scientificName) {
        this(id, age, size, color, scientificName, "");
    }

    public PlantWithTelescopicConstructors(int id, int age, int size, String color, String scientificName, String climate) {
        this(id, age, size, color, scientificName, climate, "");
    }

    public PlantWithTelescopicConstructors(int id, int age, int size, String color, String scientificName, String climate, String lightPreference) {
        this.id = id;
        this.size = size;
        this.age = age;
        this.color = color;
        this.scientificName = scientificName;
        this.climate = climate;
        this.lightPreference = lightPreference;
    }
}
