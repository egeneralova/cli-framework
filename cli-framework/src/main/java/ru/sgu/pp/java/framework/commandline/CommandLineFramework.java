package ru.sgu.pp.java.framework.commandline;

import ru.sgu.pp.java.framework.exception.CommandException;
import ru.sgu.pp.java.framework.exception.ValidationException;

import java.util.ArrayList;
import java.util.List;

/**
  * @author Elena Fedorova
 */
public class CommandLineFramework {
    private List<Command> commands = new ArrayList<Command>();
    private String help;

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void setHelp(String help) {
        this.help = help;
    }

    boolean shouldShowHelp() {
        if (help != null) {
            return true;
        }
        for (Command command : commands) {
            if (command.shouldShowHelp()) {
                return true;
            }
        }
        return false;
    }

    public void run(String[] args) {
        CommandLine commandLine = new CommandLine();
        commandLine.parse(args);
        if (commandLine.satisfyArguments()) {
            Command command = findCommandByCommandName(commandLine.getArgument(0));
            command.setCommandLine(commandLine);
            try {
                command.validate();
                command.run();
            } catch (CommandException e) {
                System.err.println(e.getMessage());
                return;
            } catch (ValidationException e) {
                System.err.println(command.getHelp());
            }
        } else {
            for (Command command : commands) {
                System.err.println(command.getHelp());
            }
        }
    }

    private Command findCommandByCommandName(String commandName) {
        for (Command command : commands) {
            if (commandName.equals(command.getName())) {
                return command;
            }
        }
        return null;
    }

}
