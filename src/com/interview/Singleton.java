package com.interview;

/*Instantiation Type
    1. Eager
    2. Lazy

Example
    1. java.lang.Runtime class
    2. java.awt.Desktop

Uses
    1. DB connection
    2. Error Manager

Break Singleton Pattern Of a Class
    1. Using Reflection => we can use singleton enum to stop breaking singleton pattern
    2. Using Serialization => a. Serialization is used to convert an object of byte stream and save in
                                 a file or send over a network. Then if you de-serialize that object it
                                 will create a new instance
                               b. To ovehigh-level modules should not depend upon low-level modules; they should depend on abstractionsrcome this issue, we have to implement method readResolve() method.
    3. Using Clone => a. Using clone we can create copy of object.
                      b. To overcome this issue, override clone() method and throw an exception from clone
                         method that is CloneNotSupportedException
*/

import java.lang.reflect.Constructor;

//Eager Instantiation
class Singleton {
    public static Singleton singleton = new Singleton();
    private Singleton() { }
}

//Lazy Instantiation
class Singleton_2 {
    private static Singleton_2 singleton;
    private Singleton_2() { }

    public static Singleton_2 getInstance(){
        if(singleton == null)
            singleton = new Singleton_2();
        return singleton;
    }
}

//Double Checked Locking
class Singleton_3 {
    private static Singleton_3 singleton;
    private Singleton_3() { }

    public static Singleton_3 getInstance(){
        if(singleton == null){
            synchronized (Singleton_3.class){
                singleton = new Singleton_3();
            }
        }
        return singleton;
    }
}

//singleton with immutable with help of volatile
class Singleton_4 {
    private static volatile Singleton_4 singleton;
    private Singleton_4() { }

    public static Singleton_4 getInstance(){
        if(singleton == null)
            singleton = new Singleton_4();
        return singleton;
    }
}

class BreakSingleton{
    public void breakSingleton(){
        Singleton instance1 = Singleton.singleton;
        Singleton instance2 = null;
        try {
            Constructor[] constructors = Singleton.class.getDeclaredConstructors();
                for (Constructor constructor : constructors) {
                    // Below code will destroy the singleton pattern
                    constructor.setAccessible(true);
                    instance2 = (Singleton) constructor.newInstance();
                    break;
                }
        } catch (Exception e) {
                e.printStackTrace();
        }
        System.out.println("instance1.hashCode():- " + instance1.hashCode());
        System.out.println("instance2.hashCode():- " + instance2.hashCode());
    }
}