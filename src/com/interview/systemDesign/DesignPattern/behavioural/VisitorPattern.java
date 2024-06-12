package com.interview.systemDesign.DesignPattern.behavioural;

public class VisitorPattern {
}

/*
Visitor Pattern
         It is used when we have to perform an operation on a group of similar kind of Objects.

         The visitor pattern consists of two parts:
             1. visitor class having visit() method and is called for every element in
                the data structure
             2. visitable classes (interface) having accept() methods that accept an object of visitor class

         eg -

         Fruits - mango, apple, guava
         Electronics - mobile, tv, laptop

         In place of giving discount on each item, give discount as 10% on electronics and 5% on fruits

Advantages :

If the logic of operation changes, then we need to make change only in the visitor implementation rather than doing it in all the item classes.
Adding a new item to the system is easy, it will require change only in visitor interface and implementation and existing item classes will not be affected.

Disadvantages :

We should know the return type of visit() methods at the time of designing otherwise we will have to change the interface and all of its implementations.
If there are too many implementations of visitor interface, it makes it hard to extend.
 */


class ShoppingCartClient {

    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[]{new Book(20, "1234"),
                new Book(100, "5678"), new Fruit(10, 2, "Banana"),
                new Fruit(5, 5, "Apple")};

        int total = calculatePrice(items);
        System.out.println("Total Cost = "+total);
    }

    private static int calculatePrice(ItemElement[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum=0;
        for(ItemElement item : items)
            sum = sum + item.accept(visitor);

        return sum;
    }

}

interface ShoppingCartVisitor {
    int visit(Book book);
    int visit(Fruit fruit);
}

interface ItemElement {     //visitable
    int accept(ShoppingCartVisitor visitor);
}

class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

    @Override
    public int visit(Book book) {
        int cost=0;
        if(book.getPrice() > 50)    //apply 5$ discount if book price is greater than 50
            cost = book.getPrice()-5;
        else
            cost = book.getPrice();

        System.out.println("Book ISBN::"+book.getIsbnNumber() + " cost ="+cost);
        return cost;
    }

    @Override
    public int visit(Fruit fruit) {
        int cost = fruit.getPricePerKg()*fruit.getWeight();
        System.out.println(fruit.getName() + " cost = "+cost);
        return cost;
    }

}

class Book implements ItemElement {
    private int price;
    private String isbnNumber;

    public Book(int cost, String isbn) {
        this.price=cost;
        this.isbnNumber=isbn;
    }

    public int getPrice() {
        return price;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }

}

class Fruit implements ItemElement {
    private int pricePerKg;
    private int weight;
    private String name;

    public Fruit(int priceKg, int wt, String nm) {
        this.pricePerKg=priceKg;
        this.weight=wt;
        this.name = nm;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }

}
