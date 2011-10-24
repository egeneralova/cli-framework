package ru.sgu.pp.java.framework.example;

import ru.sgu.pp.java.framework.option.Option;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Elena Fedorova
 */
public class FirstOption extends Option {

    public final static FirstOption INSTANCE = new FirstOption();

    @Override
    public List<String> getShortNames() {
        List<String> shortNames = new ArrayList<String>();
        shortNames.add("f");
        return shortNames;
    }

    @Override
    public List<String> getLongNames() {
        List<String> longNames = new ArrayList<String>();
        longNames.add("first");
        return longNames;
    }

    @Override
    public void validate() throws ValidationException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
