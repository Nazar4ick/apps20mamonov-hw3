package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private final MyFunction func;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.func = func;
    }

    @Override
    public Object[] toArray() {
        return this.applyFunc();
    }

    @Override
    public String operationDescription() {
        if (smartArray.operationDescription().equals("No "
                + "decorators are currently applied")) {
            return "Map decorator: applies a function to all elements";
        }
        return smartArray.operationDescription() + ", "
                + "Map decorator: applies a function to all elements";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }

    private Object[] applyFunc() {
        Object[] newArray = new Object[smartArray.size()];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = func.apply(smartArray.toArray()[i]);
        }
        return newArray;
    }
}
