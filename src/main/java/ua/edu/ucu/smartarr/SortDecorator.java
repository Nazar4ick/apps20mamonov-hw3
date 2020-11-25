package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.ArrayList;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private final MyComparator com;

    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);
        this.com = comparator;
    }

    @Override
    public String operationDescription() {
        if (smartArray.operationDescription().equals("No decorators are currently applied")) {
            return "Sort decorator: sorts elements according to the comparator";
        }
        return smartArray.operationDescription() + ", Sort decorator: sorts elements according to the comparator";
    }

    @Override
    public Object[] toArray() {
        return this.sortSmartArray();
    }

    @Override
    public int size() {
        return this.toArray().length;
    }

    private Object[] sortSmartArray() {
        ArrayList<Object> newList = new ArrayList<>(Arrays.asList(this.smartArray.toArray()));
        newList.sort(this.com);
        return newList.toArray();
    }
}
