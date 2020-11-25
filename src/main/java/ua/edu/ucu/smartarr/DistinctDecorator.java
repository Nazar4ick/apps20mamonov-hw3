package ua.edu.ucu.smartarr;

import java.util.ArrayList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        return this.removeDuplicates();
    }

    @Override
    public String operationDescription() {
        if (smartArray.operationDescription().equals("No" +
                " decorators are currently applied")) {
            return "Distinct decorator: removes all duplicates in this array";
        }
        return smartArray.operationDescription() +
                ", Distinct decorator: removes all duplicates in this array";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }

    private Object[] removeDuplicates() {
        ArrayList<Object> newList = new ArrayList<>();
        for (Object o : smartArray.toArray()) {
            if (!newList.contains(o)) {
                newList.add(o);
            }
        }
        return newList.toArray();
    }
}
