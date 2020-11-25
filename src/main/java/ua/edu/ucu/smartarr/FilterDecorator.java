package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private final MyPredicate func;

    public FilterDecorator(SmartArray smartArray, MyPredicate func) {
        super(smartArray);
        this.func = func;
    }

    @Override
    public Object[] toArray() {
        return this.filterSmartArray();
    }

    @Override
    public String operationDescription() {
        if (smartArray.operationDescription().equals("No "
                + "decorators are currently applied")) {
            return "Filter decorator: removes elements "
                    + "which don't satisfy the predicate";
        }
        return smartArray.operationDescription() + ", Filter "
                + "decorator: removes elements which don't "
                + "satisfy the predicate";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }

    private Object[] filterSmartArray() {
        ArrayList<Object> newList = new ArrayList<>();
        for (Object o: smartArray.toArray()) {
            if (func.test(o)) {
                newList.add(o);
            }
        }
        return newList.toArray();
    }
}
