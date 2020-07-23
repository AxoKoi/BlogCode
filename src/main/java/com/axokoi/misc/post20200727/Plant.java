package com.axokoi.misc.post20200727;

public class Plant {
    //Mandatory
    private int id;
    //Optional
    private int size;
    private int age;
    private String color;
    private String scientificName;
    private String climate;
    private String lightPreference;

    public Plant(int id, int age, int size, String color, String scientificName, String climate, String lightPreference) {
        this.id = id;
        this.size = size;
        this.age = age;
        this.color = color;
        this.scientificName = scientificName;
        this.climate = climate;
        this.lightPreference = lightPreference;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getClimate() {
        return climate;
    }

    public String getLightPreference() {
        return lightPreference;
    }

    public static class Builder {
        private int id;
        private int age = -1;
        private int size = -1;
        private String color = "";
        private String scientificName = "";
        private String climate = "";
        private String lightPreference = "";

        public Builder(int id) {
            this.id = id;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setScientificName(String scientificName) {
            this.scientificName = scientificName;
            return this;
        }

        public Builder setClimate(String climate) {
            this.climate = climate;
            return this;
        }

        public Builder setLightPreference(String lightPreference) {
            this.lightPreference = lightPreference;
            return this;
        }

        public Plant build() {
            return new Plant(id, age, size, color, scientificName, climate, lightPreference);
        }
    }
}
