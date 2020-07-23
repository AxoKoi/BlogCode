package com.axokoi.misc.post20200727;

import org.junit.Assert;
import org.junit.Test;

public class PlantBuilderTest {

    @Test
    public void createPlant() {
        Plant plant = new PlantBuilder(1001)
                .setAge(5)
                .setColor("Green")
                .setSize(105)
                .build();

        Assert.assertEquals(1001, plant.getId());
        Assert.assertEquals(5, plant.getAge());
        Assert.assertEquals("Green", plant.getColor());
        Assert.assertEquals(105, plant.getSize());
    }
    @Test
    public void createPlant2() {
        Plant plant = new Plant.Builder(1001)
                .setAge(5)
                .setColor("Green")
                .setSize(105)
                .build();

        Assert.assertEquals(1001, plant.getId());
        Assert.assertEquals(5, plant.getAge());
        Assert.assertEquals("Green", plant.getColor());
        Assert.assertEquals(105, plant.getSize());

       Plant plant3 = new Plant.Builder(1001).setColor("").build();
    }
}
