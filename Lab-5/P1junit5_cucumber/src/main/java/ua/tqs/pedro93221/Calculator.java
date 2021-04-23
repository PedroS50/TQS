package ua.tqs.pedro93221;

import java.util.List;
import java.util.LinkedList;
import java.util.Deque;

import static java.util.Arrays.asList;

public class Calculator
{
    private final Deque<Number> stack = new LinkedList<Number>();
    private static final List<String> OPS = asList("-", "+", "*", "/");

    public void push(Object arg) {
        if (OPS.contains(arg)) {
            Number y = stack.removeLast();
            Number x = stack.isEmpty() ? 0 : stack.removeLast();
            Integer val = null;
            
            if ( arg.equals("-") ) {
                val = x.intValue() - y.intValue();
            } else if ( arg.equals("+") ) {
                val = x.intValue() + y.intValue();
            } else if ( arg.equals("*") ) {
                val = x.intValue() * y.intValue();
            } else if ( arg.equals("/") ) {
                val = x.intValue() / y.intValue();
            }
            push(val);
        } else {
            stack.add((Number) arg);
        }

    }

    public Number value() {
        return stack.getLast();
    }
}
