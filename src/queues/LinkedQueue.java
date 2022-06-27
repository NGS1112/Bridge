package queues;

import java.util.LinkedList;

/**
 * @author Nicholas Shinn
 *
 * Creates queue for battle game type
 *
 * @param <T>
 */
public class LinkedQueue<T> implements IQueue<T>{
    //List to hold goats
    private LinkedList<T> goats = new LinkedList<>();

    /**
     * Checks if queue is empty
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty(){
        return size()==0;
    }

    /**
     * Returns size of queue
     *
     * @return queue size
     */
    public int size(){
        return goats.size();
    }

    /**
     * Returns first element in queue
     *
     * @return goat at first index in queue
     */
    public T front(){
        return goats.getFirst();
    }

    /**
     * Adds goats to queue
     *
     * @param goat goat to be added to queue
     */
    public void enqueue(T goat){
        goats.add(goat);
    }

    /**
     *Removes goats from queue
     *
     * @return goat to be removed
     */
    public T dequeue(){
        return goats.remove();
    }
}
