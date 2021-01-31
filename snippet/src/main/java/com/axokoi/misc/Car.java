/*
This is a file belonging to an axokoi project. The source code has been released under a MPL 2.0 license.
For more information, visit www.axokoi.com or www.github.com/axokoi
*/
package com.axokoi.misc;

/**
 * This is the javadoc for the Car class
 */
public final class Car {
    public static final int NUMBER_OF_WHEELS = 4;
    public static final int NUMBER_OF_WINDOWS;

    private final int numberOfDoors;
    private final double maxSpeed;
    private double currentSpeed;

    static {
        System.out.println("This block get executed when the class is loaded.");

        NUMBER_OF_WINDOWS = CarUtility.getNumberOfWindows();
    }

    //Initializer block;
    {
        System.out.println("This block get executed before each constructor call.");
        this.currentSpeed = 0;
    }

    public Car(int numberOfDoors, double maxSpeed) {
        this.numberOfDoors = numberOfDoors;
        this.maxSpeed = maxSpeed;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    /**
     * This is the the javadoc for the method
     * @param currentSpeed The speed of the car in absolute units.
     */
    public void setCurrentSpeed(double currentSpeed) {
        if(currentSpeed<0){
            throw new IllegalArgumentException("Speed must be positive");
        }
        this.currentSpeed = currentSpeed;
    }

}

class CarUtility {

    public static int getNumberOfWindows() {
        return 6;
    }
}
