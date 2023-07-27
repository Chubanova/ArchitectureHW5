package com.chubanova;

import com.chubanova.exception.CommandException;

import java.util.Queue;

public class MacroCommand implements Command{

    public MacroCommand(Queue<Command> q) {
        this.q = q;
    }

    Queue<Command> q;
    @Override
    public void execute() {
        while (!q.isEmpty()){
            var cmd = q.poll();
            try {
                cmd.execute();
            } catch (Exception e) {
                throw new CommandException(e.getMessage());
            }
        }

    }
}
