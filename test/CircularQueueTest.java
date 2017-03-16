import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * SE1021
 * Winter 2016
 * Brad Dennis
 * 3/9/2017
 */
@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public class CircularQueueTest {
    @Before
    public void setUp() throws Exception {
        //TODO: Put queue creation in here?
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test(expected = NoSuchElementException.class)
    public void constructorShouldThrowAnExceptionWhenCalledWithAZeroCapacity() throws
            Exception {
        //Arrange, Act, & Assert
        CircularQueue<String> queue = new CircularQueue<>(0);
    }

    @Test(expected = NoSuchElementException.class)
    public void constructorShouldThrowAnExceptionWhenCalledWithANegativeCapacity() throws
            Exception {
        //Arrange, Act, & Assert
        CircularQueue<String> queue = new CircularQueue<>(-1);
    }

    @Test
    public void addShouldReturnTrueWhenAnElementIsAddedSuccessfullyToTheQueue()
            throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        for (int i = 1; i <= 10; i++) {
            //Act
            boolean result = queue.add("Word Number " + i);

            //Assert
            assertEquals(true, result);
        }
    }

    @Test(expected = IllegalStateException.class)
    public void addShouldThrowAnExceptionWhenAnElementIsNotSuccessfullyAddedToTheQueue()
            throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act & Assert
        for (int i = 1; i <= 11; i++) {
            queue.add("Word Number " + i);
        }
    }

    @Test
    public void addShouldIncreaseTheSizeOfTheQueueWhenElementsAreSuccessfullyAddedToTheQueue()
            throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        for (int i = 1; i <= 10; i++) {
            //Act
            queue.add("Word Number " + i);

            //Assert
            assertEquals(i, queue.size());
        }
    }

    @Test
    public void addShouldAddItemsToTheQueueAsPerQueueBehaviorWhenElementsAreAddedToTheQueue()
            throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Assert
        for (int i = 1; i <= 10 ; i++) {
            assertEquals("Word Number " + i, queue.remove());
        }
    }

    @Test
    public void elementShouldAlwaysReturnTheFirstElementInAQueueWhenCalledRepeatedly() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Assert
        for (int i = 1; i <= 10; i++) {
            assertEquals("Word Number 1", queue.element());
        }
    }

    @Test
    public void elementShouldNotDecrementSizeOfQueueWhenCalledRepeatedly() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Assert
        for (int i = 9; i >= 0; i--) {
            queue.element();
            assertEquals(10, queue.size());
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void elementShouldThrowAnExceptionWhenCalledOnAnEmptyQueue() throws Exception {
        //Arrange & Act
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Assert
        queue.element();
    }

    @Test
    public void offerShouldReturnWhetherAnElementWasAddedWhenAnElementIsOfferedToTheQueue()
            throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        for (int i = 1; i <= 15; i++) {
            //Act
            boolean result = queue.offer("Word Number " + i);

            //Assert
            assertEquals(i <= 10, result);
        }
    }

    @Test
    public void offerShouldIncreaseTheSizeOfTheQueueWhenElementsAreSuccessfullyOfferedToTheQueue()
            throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        for (int i = 1; i <= 15; i++) {
            //Act
            queue.offer("Word Number " + i);

            //Assert
            assertEquals(Math.min(10, i), queue.size());
        }
    }

    @Test
    public void offerShouldAddItemsToTheQueueAsPerQueueBehaviorWhenElementsAreOfferedToTheQueue()
            throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        for (int i = 1; i <= 15; i++) {
            queue.offer("Word Number " + i);
        }

        //Assert
        for (int i = 1; i <= 10 ; i++) {
            assertEquals("Word Number " + i, queue.remove());
        }
    }

    @Test
    public void peekShouldAlwaysReturnTheFirstElementInAQueueWhenCalledRepeatedly() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Assert
        for (int i = 1; i <= 10; i++) {
            assertEquals("Word Number 1", queue.peek());
        }
    }

    @Test
    public void peekShouldNotDecrementSizeOfQueueWhenCalledRepeatedly() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Assert
        for (int i = 9; i >= 0; i--) {
            queue.peek();
            assertEquals(10, queue.size());
        }
    }

    @Test
    public void peekShouldReturnNullWhenCalledOnAnEmptyQueue() throws Exception {
        //Arrange & Act
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Assert
        assertEquals(null, queue.peek());
    }

    @Test
    public void pollShouldReturnElementsInTheOrderTheyWereAddedWhenCalledRepeatedly() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Assert
        for (int i = 1; i <= 10; i++) {
            assertEquals("Word Number " + i, queue.poll());
        }
    }

    @Test
    public void pollShouldDecrementSizeOfQueueWhenCalledRepeatedly() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Assert
        for (int i = 9; i >= 0; i--) {
            queue.poll();
            assertEquals(i, queue.size());
        }
    }

    @Test
    public void pollShouldReturnNullWhenCalledOnAnEmptyQueue() throws Exception {
        //Arrange & Act
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Assert
        assertEquals(null, queue.poll());
    }

    @Test
    public void removeShouldReturnElementsInTheOrderTheyWereAddedWhenCalledRepeatedly() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Assert
        for (int i = 1; i <= 10; i++) {
            assertEquals("Word Number " + i, queue.remove());
        }
    }

    @Test
    public void removeShouldDecrementSizeOfQueueWhenCalledRepeatedly() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Assert
        for (int i = 9; i >= 0; i--) {
            queue.remove();
            assertEquals(i, queue.size());
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void removeShouldThrowAnExceptionWhenCalledOnAnEmptyQueue() throws Exception {
        //Arrange & Act
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Assert
        queue.remove();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAllShouldThrowAnExceptionWhenCalled() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        Collection<String> words = new ArrayList<>();

        //Act
        queue.add("Word");
        words.add("Word");

        //Assert
        queue.addAll(words);
    }

    @Test
    public void clearShouldResultInSizeOfZeroWhenQueueStartsFull() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }
        queue.clear();

        //Assert
        assertEquals(0, queue.size());
    }

    @Test
    public void clearShouldCauseToArrayToReturnAnEmptyArrayWhenQueueStartsFull() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }
        queue.clear();

        //Assert
        assertArrayEquals(new Object[]{}, queue.toArray());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void containsShouldThrowAnExceptionWhenCalled() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        queue.add("Word");

        //Assert
        queue.contains("Word");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void containsAllShouldThrowAnExceptionWhenCalled() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        Collection<String> words = new ArrayList<>();

        //Act
        queue.add("Word");
        words.add("Word");

        //Assert
        queue.containsAll(words);
    }

    @Test
    public void isEmptyShouldReturnTrueWhenQueueIsEmpty() throws Exception {
        //Arrange & Act
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Assert
        assertTrue(queue.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseWhenQueueIsNotEmpty() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        for (int i = 1; i <= 10; i++) {
            //Act
            queue.add("Word Number " + i);

            //Assert
            assertFalse(queue.isEmpty());
        }
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iteratorShouldThrowAnExceptionWhenCalled() throws Exception {
        //Arrange & Act
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Assert
        queue.iterator();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeShouldThrowAnExceptionWhenCalledWithAnArgument() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        queue.add("Word");

        //Assert
        queue.remove("Word");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeAllShouldThrowAnExceptionWhenCalled() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        Collection<String> words = new ArrayList<>();

        //Act
        queue.add("Word");
        words.add("Word");

        //Assert
        queue.removeAll(words);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void retainAllShouldThrowAnExceptionWhenCalled() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        Collection<String> words = new ArrayList<>();

        //Act
        queue.add("Word");
        words.add("Word");

        //Assert
        queue.retainAll(words);
    }

    @Test
    public void toArrayShouldReturnEmptyArrayWhenQueueIsEmpty() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        Object[] objects = queue.toArray();

        //Assert
        assertArrayEquals(new Object[]{}, objects);
    }

    @Test
    public void toArrayShouldReturnArrayCorrespondingToContentsWhenQueueGrowsInContents() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        Object[] objects = new Object[10];

        for (int i = 1; i <= 10; i++) {
            //Act
            String word = "Word Number " + i;
            queue.add(word);
            objects[i - 1] = word;

            //Assert
            assertArrayEquals(objects, queue.toArray());
        }
    }

    @Test(expected = UnsupportedOperationException.class)
    public void toArrayShouldThrowAnExceptionWhenCalledWithAnArrayOfTheContainedType() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act & Assert
        Object[] objects = queue.toArray(new String[queue.size()]);
    }

    @Test
    public void getQueueCapacityShouldReturnTheCapacityWhenQueueIsEmpty() throws Exception {
        //Arrange & Act
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Assert
        assertEquals(10, queue.getQueueCapacity());
    }

    @Test
    public void getQueueCapacityShouldReturnTheCapacityWhenQueueGrowsInSize() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        for (int i = 1; i <= 10; i++) {
            //Act
            queue.add("Word Number " + i);

            //Assert
            assertEquals(10, queue.getQueueCapacity());
        }
    }

    @Test
    public void getRemainingQueueSpaceShouldReturnTheSuppliedCapacityWhenQueueIsEmpty() throws
            Exception {
        //Arrange & Act
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Assert
        assertEquals(10, queue.getRemainingQueueSpace());
    }

    @Test
    public void getRemainingQueueSpaceShouldReturnRemainingCapacityWhenQueueIsPartiallyFull() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        for (int i = 1; i < 10; i++) {
            //Act
            queue.add("Word Number " + i);

            //Assert
            assertEquals(10 - i, queue.getRemainingQueueSpace());
        }
    }

    @Test
    public void getRemainingQueueSpaceShouldReturnZeroWhenQueueIsFull() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Assert
        assertEquals(0, queue.getRemainingQueueSpace());
    }

    @Test
    public void isQueueFullShouldReturnFalseWhenQueueIsEmpty() throws Exception {
        //Arrange & Act
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Assert
        assertFalse(queue.isQueueFull());
    }

    @Test
    public void isQueueFullShouldReturnFalseWhenQueueIsOnlyPartiallyFull() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        for (int i = 1; i < 10; i++) {
            //Act
            queue.add("Word Number " + i);

            //Assert
            assertFalse(queue.isQueueFull());
        }
    }

    @Test
    public void isQueueFullShouldReturnTrueWhenQueueIsFull() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Assert
        assertTrue(queue.isQueueFull());
    }
}