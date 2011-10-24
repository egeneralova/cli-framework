package ru.sgu.pp.java.framework.option;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Elena Fedorova
 */
public class HelpOption extends Option{

    public final static HelpOption INSTANCE = new HelpOption();
    @Override
    public List<String> getShortNames() {
        List<String> names = new ArrayList<String>();
        names.add("help");
        return names;
    }

    @Override
    public List<String> getLongNames() {
        List<String> names = new ArrayList<String>();
        names.add("help");
        return names;
    }

    @Override
    public void validate() throws ValidationException {
    }
}
