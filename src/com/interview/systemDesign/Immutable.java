package com.interview.systemDesign;

//Immutable class means that once an object is created, we cannot change its content.
// In Java, all the wrapper classes (like Integer, Boolean, Byte, Short) and String class is immutable.

/*
    1. The class must be declared as final (So that child classes can’t be created)
    2. Data members in the class must be declared as private (So that direct access is not allowed)
    3. Data members in the class must be declared as final (So that we can’t change the value of it
        after object creation)
    4. A parameterized constructor should initialize all the fields performing a deep copy (So that
        data members can’t be modified with object reference)
    5. No setters (To not have the option to change the value of the instance variable)
*/

/*
    String is immutable in Java because of the
        1. security
        2. synchronization - Being immutable automatically makes the String thread safe since they won't be changed when accessed from multiple threads.
        3. caching - The String is the most widely used data structure. Caching the String literals and reusing them saves a lot of heap space because different String variables refer to the same object in the String pool.
        4. performance - String pool exists because Strings are immutable. In turn, it enhances the performance by saving heap memory and faster access

    Note => use char[] array over a string for storing passwords in Java
    Any one who has access to memory dump can find the password in clear text and that's another reason to use encrypted
    password than plain text. So Storing password in character array clearly mitigates security risk of stealing password.
*/

public final class Immutable {

    private final String name;
    private final int regNo;

    public Immutable(String name, int regNo){
        this.name = name;
        this.regNo = regNo;
    }

    public String getName() { return name; }

    public int getRegNo() { return regNo; }
}

// Immutable class with mutable reference

final class Employee{
    private final int id;
    private final Address address;

    public Employee(int id, Address address) {
        this.id = id;
        this.address = address;
    }

    public int getId(){
        return id;
    }

    public Address getAddress() throws CloneNotSupportedException {
        return (Address)address.clone();
    }
}

class Address implements Cloneable {
    private String street;

    public String getStreet(){
        return street;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
