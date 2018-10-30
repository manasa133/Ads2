/*************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag < input.txt
 *
 *  A generic bag or multiset, implemented using a linked list.
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The <tt>Bag</tt> class represents a bag (or multiset) of generic items. It
 * supports insertion and iterating over the items in arbitrary order. <p> The
 * <em>add</em>, <em>isEmpty</em>, and <em>size</em>  operation take constant
 * time. Iteration takes time proportional to the number of items. <p> For
 * additional documentation, see <a
 * href="http://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**
     *  number of elements in bag.
     */
    private int N;
    // beginning of bag
    private Node first;

    // helper linked list class
    private class Node {
        /**
         * Item type item.
         */
        private Item item;
        /**
         * Integer value.
         */
        private int value;
        /**
         * data of next node.
         */
        private Node next;
        /**
         * Constructs the object.
         */
        Node() {

        }
        /**
         * Constructs the object.
         *
         * @param      item   The item
         * @param      value  The value
         */
        Node(Item item, int value) {
            this.item = item;
            this.value = value;
        }
    }

   /**
     * Create an empty stack.
     */
    public Bag() {
        first = null;
        N = 0;
    }

   /**
     * Is the BAG empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

   /**
     * Return the number of items in the bag.
     */
    public int size() {
        return N;
    }

   /**
     * Add the item to the bag.
     */
    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }


   /**
     * Return an iterator that iterates over the items in the bag.
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        /**
         * Starting node.
         */
        private Node current = first;
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext()  {
            return current != null;
        }
        /**
         * remove item.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * next item is defined.
         *
         * @return     { description_of_the_return_value }
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

}

