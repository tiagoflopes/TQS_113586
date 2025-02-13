package tqs;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TqsStack<T> {

    private final ArrayList<T> stack;
    private final int MAX = 5;

    public TqsStack() {
        this.stack = new ArrayList<T>();
    }

    public void push(T x) {
        if (stack.size() == MAX) {
            throw new IllegalStateException();
        }

        stack.addFirst(x);
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        }

        return stack.removeFirst();
    }

    public T popTopN(int n) {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        } else if (n >= stack.size()) {
            throw new IllegalStateException();
        }

        T top = null;
        for (int i = 0; i < n; i++) {
            top = stack.removeFirst();
        }

        return top;
    }

    public T peek() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        }

        return stack.getFirst();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

}