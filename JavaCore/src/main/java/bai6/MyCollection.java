package bai6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MyCollection {
    public static void main(String[] args) {
        Collection<Double> collection = new ArrayList<>();
        collection.add(1.0);
        collection.add(2.0);
        collection.add(3.0);
        collection.add(4.0);
        collection.add(5.0);
        collection.add(6.0);
        System.out.println("Collection: " + collection);
        collection.remove(3.0);
        System.out.println("Collection after removing 3.0: " + collection);
        double max = Collections.max(collection);
        System.out.println("Max value in collection: " + max);
        var list = new ArrayList<>(collection);
        // reverse the list
        Collections.reverse(list);
        System.out.println("Reversed list: " + list);
    }
}