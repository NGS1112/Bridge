package queues;

/**
 * @author Nicholas Shinn
 *
 * Interface to create appropriate queue
 *
 * @param <T> queue
 */
public interface IQueue<T> {
    /**
     * Checks if queue is currently empty
     *
     * @return true if empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Size of queue
     *
     * @return queue size
     */
    int size();

    /**
     * The first item in the queue
     *
     * @return goat at first index
     */
    T front();

    /**
     * Puts goats in the queue
     *
     * @param goat goat to be added to queue
     */
    void enqueue(T goat);

    /**
     * Removes goat from queue
     *
     * @return removed goat
     */
    T dequeue();

}
