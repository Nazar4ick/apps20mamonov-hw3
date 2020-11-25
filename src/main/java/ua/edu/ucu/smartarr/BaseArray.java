package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private final Object[] items;
    public BaseArray(Object[] items) {
        this.items = items.clone();
    }

    @Override
    public Object[] toArray() {
        return items;
    }

    @Override
    public String operationDescription() {
        return "No decorators are currently applied";
    }

    @Override
    public int size() {
        return items.length;
    }
}
