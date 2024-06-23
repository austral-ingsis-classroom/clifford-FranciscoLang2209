package edu.austral.ingsis.clifford;

public class PrintPath implements Command {
  private final VirtualFileSystem fileSystem;

  public PrintPath(VirtualFileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public String execute() {
    StringBuilder path = new StringBuilder();
    Node current = fileSystem.getCurrentDirectory();
    while (current != null) {
      path.insert(0, current.getName());
      if (current.getParent() != null) {
        path.insert(0, "/");
      }
      current = current.getParent();
    }

    return path.toString();
  }
}
