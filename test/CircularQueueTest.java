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
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(expected = Exception.class) //Assert
    public void constructorShouldThrowAnExceptionWhenCalledWithAZeroCapacity() throws
            Exception {
        //Act
        new CircularQueue<>(0);
    }

    @Test(expected = Exception.class) //Assert
    public void constructorShouldThrowAnExceptionWhenCalledWithANegativeCapacity() throws
            Exception {
        //Act
        new CircularQueue<>(-1);
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

    @Test(expected = IllegalStateException.class) //Assert
    public void addShouldThrowAnExceptionWhenAnElementIsNotSuccessfullyAddedToTheQueue()
            throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
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
    public void addShouldAddItemsToTheQueueAsPerQueueBehaviorWhenNullElementsAreAddedToTheQueue()
            throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        for (int i = 1; i <= 10; i++) {
            queue.add(null);
        }

        //Assert
        for (int i = 1; i <= 10 ; i++) {
            assertEquals(null, queue.remove());
        }
    }

    @Test
    public void elementShouldAlwaysReturnTheFirstElementInAQueueWhenCalledRepeatedly() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Act & Assert
        for (int i = 1; i <= 10; i++) {
            assertEquals("Word Number 1", queue.element());
        }
    }

    @Test
    public void elementShouldNotDecrementSizeOfQueueWhenCalledRepeatedly() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        for (int i = 9; i >= 0; i--) {
            //Act
            queue.element();

            //Assert
            assertEquals(10, queue.size());
        }
    }

    @Test(expected = NoSuchElementException.class) //Assert
    public void elementShouldThrowAnExceptionWhenCalledOnAnEmptyQueue() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
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
    public void
    offerShouldAddItemsToTheQueueAsPerQueueBehaviorWhenNullElementsAreOfferedToTheQueue()
            throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        for (int i = 1; i <= 15; i++) {
            queue.offer(null);
        }

        //Assert
        for (int i = 1; i <= 10 ; i++) {
            assertEquals(null, queue.remove());
        }
    }

    @Test
    public void peekShouldAlwaysReturnTheFirstElementInAQueueWhenCalledRepeatedly() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Act & Assert
        for (int i = 1; i <= 10; i++) {
            assertEquals("Word Number 1", queue.peek());
        }
    }

    @Test
    public void peekShouldNotDecrementSizeOfQueueWhenCalledRepeatedly() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        for (int i = 9; i >= 0; i--) {
            //Act
            queue.peek();

            //Assert
            assertEquals(10, queue.size());
        }
    }

    @Test
    public void peekShouldReturnNullWhenCalledOnAnEmptyQueue() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act & Assert
        assertEquals(null, queue.peek());
    }

    @Test
    public void pollShouldReturnElementsInTheOrderTheyWereAddedWhenCalledRepeatedly() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Act & Assert
        for (int i = 1; i <= 10; i++) {
            assertEquals("Word Number " + i, queue.poll());
        }
    }

    @Test
    public void pollShouldDecrementSizeOfQueueWhenCalledRepeatedly() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        for (int i = 9; i >= 0; i--) {
            //Act
            queue.poll();

            //Assert
            assertEquals(i, queue.size());
        }
    }

    @Test
    public void pollShouldReturnNullWhenCalledOnAnEmptyQueue() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act & Assert
        assertEquals(null, queue.poll());
    }

    @Test
    public void removeShouldReturnElementsInTheOrderTheyWereAddedWhenCalledRepeatedly() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Act & Assert
        for (int i = 1; i <= 10; i++) {
            assertEquals("Word Number " + i, queue.remove());
        }
    }

    @Test
    public void removeShouldDecrementSizeOfQueueWhenCalledRepeatedly() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        for (int i = 9; i >= 0; i--) {
            //Act
            queue.remove();

            //Assert
            assertEquals(i, queue.size());
        }
    }

    @Test(expected = NoSuchElementException.class) //Assert
    public void removeShouldThrowAnExceptionWhenCalledOnAnEmptyQueue() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        queue.remove();
    }

    @Test(expected = UnsupportedOperationException.class) //Assert
    public void addAllShouldThrowAnExceptionWhenCalled() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        Collection<String> words = new ArrayList<>();
        queue.add("Word");
        words.add("Word");

        //Act
        queue.addAll(words);
    }

    @Test
    public void clearShouldResultInSizeOfZeroWhenQueueStartsFull() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Act
        queue.clear();

        //Assert
        assertEquals(0, queue.size());
    }

    @Test
    public void clearShouldCauseToArrayToReturnAnEmptyArrayWhenQueueStartsFull() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Act
        queue.clear();

        //Assert
        assertArrayEquals(new Object[]{}, queue.toArray());
    }

    @Test(expected = UnsupportedOperationException.class) //Assert
    public void containsShouldThrowAnExceptionWhenCalled() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        queue.add("Word");

        //Act
        queue.contains("Word");
    }

    @Test(expected = UnsupportedOperationException.class) //Assert
    public void containsAllShouldThrowAnExceptionWhenCalled() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        Collection<String> words = new ArrayList<>();
        queue.add("Word");
        words.add("Word");

        //Act
        queue.containsAll(words);
    }

    @Test
    public void isEmptyShouldReturnTrueWhenQueueIsEmpty() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act & Assert
        assertTrue(queue.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseWhenQueueIsNotEmpty() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);

            //Act & Assert
            assertFalse(queue.isEmpty());
        }
    }

    @Test(expected = UnsupportedOperationException.class) //Assert
    public void iteratorShouldThrowAnExceptionWhenCalled() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        queue.iterator();
    }

    @Test(expected = UnsupportedOperationException.class) //Assert
    public void removeShouldThrowAnExceptionWhenCalledWithAnArgument() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        queue.add("Word");

        //Act
        queue.remove("Word");
    }

    @Test(expected = UnsupportedOperationException.class) //Assert
    public void removeAllShouldThrowAnExceptionWhenCalled() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        Collection<String> words = new ArrayList<>();
        queue.add("Word");
        words.add("Word");

        //Act
        queue.removeAll(words);
    }

    @Test(expected = UnsupportedOperationException.class) //Assert
    public void retainAllShouldThrowAnExceptionWhenCalled() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        Collection<String> words = new ArrayList<>();
        queue.add("Word");
        words.add("Word");

        //Act
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
            String word = "Word Number " + i;
            queue.add(word);
            objects[i - 1] = word;
            Object[] expected = new Object[i];
            System.arraycopy(objects, 0, expected, 0, i);

            //Act & Assert
            assertArrayEquals(expected, queue.toArray());
        }
    }

    @Test(expected = UnsupportedOperationException.class) //Assert
    public void toArrayShouldThrowAnExceptionWhenCalledWithAnArrayOfTheContainedType() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act
        queue.toArray(new String[queue.size()]);
    }

    @Test
    public void getQueueCapacityShouldReturnTheCapacityWhenQueueIsEmpty() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act & Assert
        assertEquals(10, queue.getQueueCapacity());
    }

    @Test
    public void getQueueCapacityShouldReturnTheCapacityWhenQueueGrowsInSize() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);

            //Act & Assert
            assertEquals(10, queue.getQueueCapacity());
        }
    }

    @Test
    public void getRemainingQueueSpaceShouldReturnTheSuppliedCapacityWhenQueueIsEmpty() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act & Assert
        assertEquals(10, queue.getRemainingQueueSpace());
    }

    @Test
    public void getRemainingQueueSpaceShouldReturnRemainingCapacityWhenQueueIsPartiallyFull() throws
            Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        for (int i = 1; i < 10; i++) {
            queue.add("Word Number " + i);

            //Act & Assert
            assertEquals(10 - i, queue.getRemainingQueueSpace());
        }
    }

    @Test
    public void getRemainingQueueSpaceShouldReturnZeroWhenQueueIsFull() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Act & Assert
        assertEquals(0, queue.getRemainingQueueSpace());
    }

    @Test
    public void isQueueFullShouldReturnFalseWhenQueueIsEmpty() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);

        //Act & Assert
        assertFalse(queue.isQueueFull());
    }

    @Test
    public void isQueueFullShouldReturnFalseWhenQueueIsOnlyPartiallyFull() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        for (int i = 1; i < 10; i++) {
            queue.add("Word Number " + i);

            //Act & Assert
            assertFalse(queue.isQueueFull());
        }
    }

    @Test
    public void isQueueFullShouldReturnTrueWhenQueueIsFull() throws Exception {
        //Arrange
        CircularQueue<String> queue = new CircularQueue<>(10);
        for (int i = 1; i <= 10; i++) {
            queue.add("Word Number " + i);
        }

        //Act & Assert
        assertTrue(queue.isQueueFull());
    }
}