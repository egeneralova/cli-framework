package ru.sgu.pp.java.framework.option;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * @author Elena Fedorova
 */
public abstract class Option {

    protected Option() {
    }

    public abstract List<String> getShortNames();

    public abstract List<String> getLongNames();

    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public abstract void validate() throws ValidationException;

    public static final class Value {
        private String key;
        private String entry;

        public Value(String key, String entry) {
            this.key = key;
            this.entry = entry;
        }

        public String getKey() {
            return key;
        }

        public String getEntry() {
            return entry;
        }
    }
}
