package org.personal.mason.axon;

import org.personal.mason.common.code.gen.template.java.JavaFieldPart;

/**
 * Created by mason on 12/13/14.
 */
public class CommandGen extends BaseGen {

    private String commandName;

    private CommandGen() {
    }

    @Override
    public void generate() {

    }

    public static CommandGen getInstance() {
        return new CommandGen();
    }

    public CommandGen withName(String commandName) {
        this.commandName = commandName;
        return this;
    }

    public CommandGen withFieldPart(JavaFieldPart javaFieldPart) {

        return this;
    }

}
