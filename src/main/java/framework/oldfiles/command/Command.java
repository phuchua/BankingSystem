package framework.oldfiles.command;

public interface Command {
    void execute();
    void undo();
    void redo();
}
