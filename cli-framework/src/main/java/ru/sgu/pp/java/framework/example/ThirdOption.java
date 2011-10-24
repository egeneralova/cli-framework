package ru.sgu.pp.java.framework.example;

import ru.sgu.pp.java.framework.option.Option;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Elena Fedorova
 */
public class ThirdOption extends Option {

    public final static ThirdOption INSTANCE = new ThirdOption();

    @Override
    public List<String> getShortNames() {
        List<String> shortNames = new ArrayList<String>();
        shortNames.add("t");
        return shortNames;
    }

    @Override
    public List<String> getLongNames() {
        List<String> longNames = new ArrayList<String>();
        longNames.add("third");
        return longNames;
    }

    @Override
    public void validate() throws ValidationException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
