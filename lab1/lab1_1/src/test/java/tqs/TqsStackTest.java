package tqs;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TqsStackTest {

    @Test
    void push() {
        TqsStack<Integer> s = new TqsStack<>();

        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        boolean thrown = false;
        try {
            s.push(5);
        } catch (IllegalStateException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    void pop() {
        TqsStack<Integer> s = new TqsStack<>();

        boolean thrown = false;
        try {
            s.pop();
        } catch (NoSuchElementException e) {
            thrown = true;
        }

        assertTrue(thrown);

        s.push(0);

        assertEquals(0, s.pop());

        s.push(1);
        s.push(2);

        assertEquals(2, s.pop());
    }

    @Test
    void popTopN() {
        TqsStack<Integer> s = new TqsStack<>();

        boolean thrown = false;
        try {
            s.popTopN(1);
        } catch (NoSuchElementException e) {
            thrown = true;
        }

        assertTrue(thrown);

        s.push(0);
        s.push(1);
        s.push(2);

        thrown = false;
        try {
            s.popTopN(4);
        } catch (IllegalStateException e) {
            thrown = true;
        }

        assertTrue(thrown);

        assertEquals(1, s.popTopN(2));
    }

    @Test
    void peek() {
        TqsStack<Integer> s = new TqsStack<>();

        boolean thrown = false;
        try {
            s.peek();
        } catch (NoSuchElementException e) {
            thrown = true;
        }

        assertTrue(thrown);

        s.push(0);

        assertEquals(0, s.peek());

        s.push(1);
        s.push(2);

        assertEquals(2, s.peek());
    }

    @Test
    void size() {
        TqsStack<Integer> s = new TqsStack<>();

        assertEquals(0, s.size());

        s.push(0);

        assertEquals(1, s.size());

        s.peek();

        assertEquals(1, s.size());

        s.pop();

        assertEquals(0, s.size());

        s.push(1);
        s.push(2);

        assertEquals(2, s.size());

        s.pop();
        s.pop();

        assertEquals(0, s.size());
    }

    @Test
    void isEmpty() {
        TqsStack<Integer> s = new TqsStack<>();

        assertTrue(s.isEmpty());

        s.push(0);
        s.push(1);
        s.push(2);

        assertFalse(s.isEmpty());
    }

}