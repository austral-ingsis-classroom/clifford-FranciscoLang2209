package edu.austral.ingsis.clifford;

public class CreateDirectory implements Command {
  private final VirtualFileSystem fileSystem;
  private final String directoryName;

  public CreateDirectory(VirtualFileSystem fileSystem, String directoryName) {
    this.fileSystem = fileSystem;
    this.directoryName = directoryName;
  }

  @Override
  public String execute() {
    new Directory(directoryName, fileSystem.getCurrentDirectory());
    return "'" + directoryName + "' directory created";
  }
}
