package edu.austral.ingsis.clifford;

public class Touch implements Command {
    private final VirtualFileSystem fileSystem;
    private final String fileName;

    public Touch(VirtualFileSystem fileSystem, String fileName) {
        this.fileSystem = fileSystem;
        this.fileName = fileName;
    }

    @Override
    public String execute() {
        new File(fileName, fileSystem.getCurrentDirectory());
        return "File created";
    }
}
