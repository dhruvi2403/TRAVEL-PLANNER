package linklist;

import java.util.*;
import Travel.*;
import stack.stacks;

public class linklist extends stacks implements Iterable<TravelPackage> {

    class node {
        TravelPackage tp;
        node next;

        node(TravelPackage tp) {
            this.tp = tp;
            this.next = null;
        }

    }

    node first = null;

    public void insertatlast(TravelPackage tp) {
        node n = new node(tp);
        if (first == null) {
            first = n;
        } else {
            node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
        
    }

    void displayll() {
        if (first == null) {
            System.out.println("empty");
        } else {
            node temp = first;
            while (temp.next != null) {
                System.out.println(temp.tp);
                temp = temp.next;
            }
            System.out.println(temp.tp);
        }
    }

    @Override
    public Iterator<TravelPackage> iterator() {//for each loop k lie
        return new Iterator<TravelPackage>() {
            private node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public TravelPackage next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                TravelPackage tp = current.tp;
                current = current.next;
                return tp;
            }
        };
        
    }

}