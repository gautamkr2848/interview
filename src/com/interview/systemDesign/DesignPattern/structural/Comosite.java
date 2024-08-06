package com.interview.systemDesign.DesignPattern.structural;

//Composite pattern is used where we need to treat a group of objects in similar way as a single object. Composite
// pattern composes objects in term of a tree structure to represent part as well as whole hierarchy.

import java.util.ArrayList;
import java.util.List;

// Step-by-Step Implementation
// Component Interface: Define the interface for all objects in the composition.
// Leaf Class: Represents the leaf objects in the composition (e.g., File).
// Composite Class: Represents a composite object (e.g., Directory) that can have children.

public class Comosite {

    public static void main (String[] args) {
        // Creating leaf objects (files)
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("file3.txt");

        // Creating composite objects (directories)
        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");

        // Adding files to directory
        dir1.addComponent(file1);
        dir1.addComponent(file2);

        // Adding directory to another directory
        dir2.addComponent(dir1);
        dir2.addComponent(file3);

        // Showing details
        dir2.showDetails();
    }
}

interface FileSystemComponent {
    void showDetails();
}

class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }
}