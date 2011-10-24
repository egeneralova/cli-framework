package ru.sgu.pp.java.framework.example;

import ru.sgu.pp.java.framework.commandline.CommandLineFramework;

/**
 * @author Elena Fedorova
 */
public class Main {
    public static void main(String[] args) {
        CommandLineFramework commandLineFramework = new CommandLineFramework();
        commandLineFramework.addCommand(new SumCommand());
        commandLineFramework.run(args);
    }
}
