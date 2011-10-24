package ru.sgu.pp.java.framework.commandline;


import ru.sgu.pp.java.framework.exception.CommandException;
import ru.sgu.pp.java.framework.exception.ValidationException;
import ru.sgu.pp.java.framework.option.HelpOption;
import ru.sgu.pp.java.framework.option.Option;

import java.util.List;

/**
 * @author Elena Fedorova
 */
public abstract class Command {
    protected CommandLine commandLine;
    public abstract boolean isApplicable(CommandLine commandLine);
    public abstract String getDescription();
    public abstract String getName();
    public String getHelp() {
        return getDescription();
    }
    public abstract List<Option> getRequiredOptions();
    public abstract List<Option> getOptionalOptions();

    public void setCommandLine(CommandLine commandLine) {
        this.commandLine = commandLine;
    }
    public abstract void validate() throws ValidationException;
    public abstract void run() throws CommandException;
    public boolean shouldShowHelp() {
        return commandLine.hasOption(HelpOption.INSTANCE);
    }
}
