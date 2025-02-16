package tqs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TqsStackTest {

    private TqsStack<Integer> myStack;

    @BeforeEach
    void setup() {
        myStack = new TqsStack<>();
    }

    @Test
    void push() {
        TqsStack<Integer> myBoundedStack = new TqsStack<>(3);
        myBoundedStack.push(0);
        myBoundedStack.push(1);
        myBoundedStack.push(2);
        assertThrowsExactly(IllegalStateException.class, () -> myBoundedStack.push(3));
    }

    @Test
    void pop() {
        assertThrowsExactly(NoSuchElementException.class, myStack::pop);

        myStack.push(0);
        assertEquals(0, myStack.pop());
    }

    @Test
    void popTopN() {
        assertThrowsExactly(NoSuchElementException.class, () -> myStack.popTopN(1));

        myStack.push(0);
        myStack.push(1);
        myStack.push(2);
        assertEquals(1, myStack.popTopN(2));
    }

    @Test
    void peek() {
        assertThrowsExactly(NoSuchElementException.class, myStack::peek);

        myStack.push(0);
        assertEquals(0, myStack.peek());
    }

    @Test
    void size() {
        assertEquals(0, myStack.size());

        myStack.push(0);
        myStack.push(1);
        myStack.push(2);
        assertEquals(3, myStack.size());

        myStack.pop();
        assertEquals(2, myStack.size());

        myStack.peek();
        assertEquals(2, myStack.size());

        myStack.pop();
        myStack.pop();
        assertEquals(0, myStack.size());
    }

    @Test
    void isEmpty() {
        assertTrue(myStack.isEmpty());

        myStack.push(0);
        myStack.push(1);
        myStack.push(2);
        assertFalse(myStack.isEmpty());

        myStack.pop();
        myStack.pop();
        myStack.pop();
        assertTrue(myStack.isEmpty());
    }

}