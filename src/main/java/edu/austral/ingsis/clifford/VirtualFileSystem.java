package edu.austral.ingsis.clifford;

public class VirtualFileSystem {
    private final Directory root;
    private Directory currentDirectory;

    public VirtualFileSystem() {
        this.root = new Directory("");
        this.currentDirectory = root;
    }

    public Directory getRoot() {
        return root;
    }

    public Directory getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(Directory currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    public String execute(String command) {
        String[] commandParts = command.split(" ");
        String commandName = commandParts[0];

        return switch (commandName) {
            case "touch" -> new Touch(this, commandParts[1]).execute();
            case "ls" -> new ListChildren(this, commandParts[1]).execute();
            default -> "Command not found";
        };
    }
}
