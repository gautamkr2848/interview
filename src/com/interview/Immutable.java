package com.interview;

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
        2. synchronization
        3. concurrency
        4. caching
        5. performance

    Note => use char[] array over a string for storing passwords in Java
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
