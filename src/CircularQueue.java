import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author schilling This class will implement a circular queue. The user can
 *         use this class to store items in an efficient manner.
 */
public class CircularQueue<E> implements FixedSizeQueueInterface<E> {
	/*
	 * The following variable determines how much data can be stored in this
	 * queue.
	 */
	private int capacity;
	
	/* This array stores the actual data within the queue. */
	private E dataArray[];
	
	/*
	 * This variable holds an integer index which represents the end of the
	 * array onto which items are added.
	 */
	private int tail;
	
	/*
	 * This variable holds an integer index which represents the location from
	 * which items are removed from the queue.
	 */
	private int head;
	
	/*
	 * This variable represents the number of items placed on the queue at the
	 * current time.
	 */
	private int size;

	/**
	 * This constructor will instantiate a new circular queue of the size given
	 * as an attribute.
	 * 
	 * @param maxQueueSize
	 *            This is the capacity of the circular queue.
	 * @throws Exception
	 *             An exception will be thrown if an invalid capacity is passed
	 *             into the method. The capacity must be greater than zero for a
	 *             proper queue structure to be built.
	 */
	public CircularQueue(int maxQueueSize) throws Exception {
		super();
		if (maxQueueSize < 1) {
			throw new Exception("Queue capacity invalid.");
		}
		capacity = maxQueueSize;
		clear();
	}

	/**
	 * This method will throw an Illegal state exception if the queue is full.
	 */
	@Override
	public boolean add(E arg0) throws  IllegalStateException{
		if (isQueueFull()) {
			// The queue is full. Throw an appropriate exception.
			throw new IllegalStateException("The queue is full.");
		} else {
			offer(arg0);
		}
		return true;
	}

	@Override
	/**
	 * This method will throw a NoSuchElementException if an attempt is made to obtain the element and the queue is empty.
	 */
	public E element() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException("Circular queue is empty.");
		} else {
			return dataArray[head];
		}
	}

	@Override
	public boolean offer(E arg0) {
		boolean retVal = false;
		if (this.size < this.capacity) {
			this.dataArray[tail] = arg0;
			tail = (tail + 1) % capacity;
			this.size++;
			retVal = true;
		}
		return retVal;
	}

	@Override
	public E peek() {
		if (size == 0) {
			return null;
		} else {
			return dataArray[head];
		}
	}

	@Override
	public E poll() {
		E retVal = null;
		if (size == 0) {
			// DO nothing.
		} else {
			retVal = dataArray[head];
			dataArray[head] = null;
			head = (head + 1) % capacity;
			size--;
		}
		return retVal;

	}

	@Override
	/**
	 * This method will throw a NoSuchElementException if an attempt is made to obtain the element and the queue is empty.
	 */
	public E remove() {
		if (size == 0) {
			throw new NoSuchElementException("Circular queue is empty.");
		} else {
			E retVal = dataArray[head];
			dataArray[head] = null;
			head = (head + 1) % capacity;
			size--;

			return retVal;
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		dataArray = ((E[]) new Object[capacity]);
		tail = 0;
		head = 0;
		size = 0;
	}

	@Override
	public boolean contains(Object arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * This method is unsupported and will throw an UnsupportedOperationException if invoked.
	 */
	@Override
	public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Method not yet supported.");
	}

	/**
	 * This method is unsupported and will throw an UnsupportedOperationException if invoked.
	 */
	@Override
	public boolean remove(Object arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	/**
	 * This method is unsupported and will throw an UnsupportedOperationException if invoked.
	 */
	@Override
	public boolean removeAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	/**
	 * This method is unsupported and will throw an UnsupportedOperationException if invoked.
	 */
	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Object[] toArray() {
		Object retVal[] = new Object[size];

		for (int index = 0; index < size; index++) {
			int myOffset = (head + index) % this.capacity;
			retVal[index] = this.dataArray[myOffset];
		}
		return retVal;
	}

	/**
	 * This method is unsupported and will throw an UnsupportedOperationException if invoked.
	 */
	@Override
	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public int getQueueCapacity() {
		return this.capacity;
	}

	@Override
	public int getRemainingQueueSpace() {
		return this.capacity - this.size;
	}

	@Override
	public boolean isQueueFull() {
		return (this.size >= this.capacity);
	}

}
