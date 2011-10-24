package ru.sgu.pp.java.framework.commandline;

import ru.sgu.pp.java.framework.option.Argument;
import ru.sgu.pp.java.framework.option.Option;
import ru.sgu.pp.java.framework.util.CLIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Elena Fedorova
 */
public class CommandLine {

    private final List<Argument> arguments = new ArrayList<Argument>();
    private final List<Option.Value> optionValues = new ArrayList<Option.Value>();

    public List<Argument> getArguments() {
        return arguments;
    }

    public List<Option.Value> getOptionValues() {
        return optionValues;
    }

    public void parse(String[] parameters) {
        for (int index = 0; index < parameters.length; index++) {
            String parameter = parameters[index];
            int dashes = getLeadingDashCount(parameter);
            if (dashes == 0) {
                arguments.add(new Argument(parameter));
            } else if (dashes == 1) {
                if (index + 1 == parameters.length) {
                    throw new IllegalArgumentException("can't find the value for " + parameter + " parameter");
                } else {
                    optionValues.add(new Option.Value(parameter.substring(1), parameters[index + 1]));
                    index++;
                }
            } else if (dashes >= 2) {
                String option = parameter.substring(2);
                if (option.contains("=")) {
                    int pos = option.indexOf("=");
                    String name = option.substring(0, pos);
                    String value = option.substring(pos + 1);
                    optionValues.add(new Option.Value(name, value));
                } else {
                    optionValues.add(new Option.Value(option, null));
                }
            }
        }
    }

    private int getLeadingDashCount(String token) {
        int result = 0;
        for (int i = 0; i < token.length(); i++) {
            if (token.charAt(i) == '-') {
                ++result;
            } else {
                break;
            }
        }
        return result;
    }

    public boolean hasOption(Option option) {
        for (Option.Value optionValue : optionValues) {
            if (option.getShortNames().contains(optionValue.getKey()) ||
                    option.getLongNames().contains(optionValue.getKey())) {
                return true;
            }
        }
        return false;
    }

    boolean satisfyArguments() {
        return true;
    }

    public String getArgument(int n) {
        return arguments.get(n).getValue();
    }

    public Integer getArgumentInteger(int n) {
        return CLIUtils.getValueAsInteger(arguments.get(n).getValue());
    }

    Double getArgumentDouble(int n) {
        return CLIUtils.getValueAsDouble(arguments.get(n).getValue());
    }

    public Integer getIntOption(String option) {
        for (Option.Value value: optionValues) {
            if (value.getKey().equals(option))
                return CLIUtils.getValueAsInteger(value.getEntry());
        }
        return null;
    }

    public Option.Value getOptionValueOf(String name) {
        for (Option.Value optionValue : optionValues) {
            if (optionValue.getKey().equals(name)) {
                return optionValue;
            }
        }
        return null;
    }

}
