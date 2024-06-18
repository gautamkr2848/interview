package com.interview.systemDesign.DesignPattern.creational;

// The Abstract Factory Pattern is a way of organizing how you create groups of things that are related to each other.
// It provides a set of rules or instructions that let you create different types of things without knowing exactly what
// those things are. This helps you keep everything organized and lets you switch between different types easily, following
// the same set of rules.
//
// Abstract Factory pattern is almost similar to Factory Pattern and is considered as another layer of abstraction over factory pattern.
// Abstract Factory patterns work around a super-factory which creates other factories.
// Abstract factory pattern implementation provides us with a framework that allows us to create objects that follow a general pattern.
// So at runtime, the abstract factory is coupled with any desired concrete factory which can create objects of the desired type.

// Abstract Factory Interface
interface CarFactory {
    Car createCar();
    CarSpecification createSpecification();
}

// Concrete Factory for North America Cars
class NorthAmericaCarFactory implements CarFactory {
    public Car createCar() {
        return new Sedan();
    }

    public CarSpecification createSpecification() {
        return new NorthAmericaSpecification();
    }
}

// Concrete Factory for Europe Cars
class EuropeCarFactory implements CarFactory {
    public Car createCar() {
        return new Hatchback();
    }

    public CarSpecification createSpecification() {
        return new EuropeSpecification();
    }
}

// Abstract Product Interface for Cars
interface Car {
    void assemble();
}

// Abstract Product Interface for Car Specifications
interface CarSpecification {
    void display();
}

// Concrete Product for Sedan Car
class Sedan implements Car {
    public void assemble() {
        System.out.println("Assembling Sedan car.");
    }
}

// Concrete Product for Hatchback Car
class Hatchback implements Car {
    public void assemble() {
        System.out.println("Assembling Hatchback car.");
    }
}

// Concrete Product for North America Car Specification
class NorthAmericaSpecification implements CarSpecification {
    public void display() {
        System.out.println("North America Car Specification: Safety features compliant with local regulations.");
    }
}

// Concrete Product for Europe Car Specification
class EuropeSpecification implements CarSpecification {
    public void display() {
        System.out.println("Europe Car Specification: Fuel efficiency and emissions compliant with EU standards.");
    }
}


// Client Code
public class AbstractFactory {
    public static void main(String[] args) {
        // Creating cars for North America
        CarFactory northAmericaFactory = new NorthAmericaCarFactory();
        Car northAmericaCar = northAmericaFactory.createCar();
        CarSpecification northAmericaSpec = northAmericaFactory.createSpecification();

        northAmericaCar.assemble();
        northAmericaSpec.display();

        // Creating cars for Europe
        CarFactory europeFactory = new EuropeCarFactory();
        Car europeCar = europeFactory.createCar();
        CarSpecification europeSpec = europeFactory.createSpecification();

        europeCar.assemble();
        europeSpec.display();
    }
}

