package ru.sgu.pp.java.framework.example;

import ru.sgu.pp.java.framework.option.Option;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Elena Fedorova
 */
public class SecondOption extends Option {

    public final static SecondOption INSTANCE = new SecondOption();

    @Override
    public List<String> getShortNames() {
        List<String> shortNames = new ArrayList<String>();
        shortNames.add("s");
        return shortNames;
    }

    @Override
    public List<String> getLongNames() {
        List<String> longNames = new ArrayList<String>();
        longNames.add("second");
        return longNames;
    }

    @Override
    public void validate() throws ValidationException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
