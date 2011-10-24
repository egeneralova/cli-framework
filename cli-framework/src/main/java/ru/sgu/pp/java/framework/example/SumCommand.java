package ru.sgu.pp.java.framework.example;

import ru.sgu.pp.java.framework.commandline.Command;
import ru.sgu.pp.java.framework.commandline.CommandLine;
import ru.sgu.pp.java.framework.example.FirstOption;
import ru.sgu.pp.java.framework.example.SecondOption;
import ru.sgu.pp.java.framework.example.ThirdOption;
import ru.sgu.pp.java.framework.exception.CommandException;
import ru.sgu.pp.java.framework.exception.ValidationException;
import ru.sgu.pp.java.framework.option.Option;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Elena Fedorova
 */
public class SumCommand extends Command {

    private final static String description = "Sums elements with parameters f, s, and t (optional)";

    @Override
    public String getName() {
        return "sum";
    }

    @Override
    public boolean isApplicable(CommandLine commandLine) {
        return commandLine.hasOption(FirstOption.INSTANCE) && commandLine.hasOption(SecondOption.INSTANCE);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<Option> getRequiredOptions() {
        List<Option> options = new ArrayList<Option>();
        options.add(new FirstOption());
        options.add(new SecondOption());
        return options;
    }

    @Override
    public List<Option> getOptionalOptions() {
        List<Option> options = new ArrayList<Option>();
        options.add(new ThirdOption());
        return options;
    }

    @Override
    public void validate() throws ValidationException {
        Integer a = commandLine.getIntOption("first");
        Option.Value third = commandLine.getOptionValueOf("third");
        Integer b = commandLine.getIntOption("second");
        Integer c = commandLine.getIntOption("third");
        if (a == null || b == null || (third != null && c == null)) {
            throw new ValidationException();
        }
    }

    @Override
    public void run() throws CommandException {
        if (isApplicable(commandLine)) {
            int first = Integer.parseInt(commandLine.getOptionValueOf("first").getEntry());
            int second = Integer.parseInt(commandLine.getOptionValueOf("second").getEntry());
            int result = first + second;
            if (commandLine.hasOption(ThirdOption.INSTANCE)) {
                result += Integer.parseInt(commandLine.getOptionValueOf("third").getEntry());
            }
            System.out.println(result);
        } else {
            System.err.println(getHelp());
        }
    }
}
