package queues;

/**
 * @author Nicholas Shinn
 *
 * Circular array to be used for cute game type
 *
 * @param <T> queue
 */
public class ArrayQueue<T> implements IQueue<T> {
    //First index of array
    private int start;

    //Last index of array
    private int end;

    //Creates array of objects
    T[] array = (T[]) new Object[11];

    /**
     * Checks if array is empty
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty(){
        return start==end;
    }

    /**
     * Size of array
     *
     * @return array size
     */
    public int size(){
        return array.length;
    }

    /**
     * First value of array
     *
     * @return goat at index start
     */
    public T front(){
        return array[start];
    }

    /**
     * Adds goats to queue, changes end index
     *
     * @param goat goat to be added to queue
     */
    public void enqueue(T goat){
        array[end] = goat;
        end = (end+1)%size();
    }

    /**
     * Removes goat from queue, changes start index
     *
     * @return removed goat
     */
    public T dequeue(){
        T x = front();
        start = (start+1)%size();
        return x;
    }

}
