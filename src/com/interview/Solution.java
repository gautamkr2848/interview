package com.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {

    class Person{
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o){

            if(o == null || (o.getClass() != this.getClass()))
                return Boolean.FALSE;

            Person p = (Person) o;

            if(o == this || (p.name.equals(this.name) && p.age == this.age))
                return Boolean.TRUE;
            else
                return Boolean.FALSE;
        }

        /*@Override
        public Integer hashCode(Object o){

        }*/
    }

    void test() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("A", 1));
        persons.add(new Person("B", 2));

        List<Person> anotherSetOfPersons = new ArrayList<>();
        anotherSetOfPersons.add(new Person("A", 1));
        anotherSetOfPersons.add(new Person("B", 2));

        if (persons.containsAll(anotherSetOfPersons)) {
            System.out.println("All present");
        } else {
            System.out.println("All not present");
        }
    }
}

/*



    public static void main(String[] args) {
        Solution s = new Solution();
        s.test();
    }
}*/
