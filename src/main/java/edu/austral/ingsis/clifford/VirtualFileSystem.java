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

    switch (commandName) {
      case "touch" -> {
        String fileName = commandParts[1];
        return new Touch(this, fileName).execute();
      }
      case "ls" -> {
        String order = commandParts.length > 1 ? commandParts[1].split("=")[1] : null;
        return new ListChildren(this, order).execute();
      }
      case "cd" -> {
        String directoryName = commandParts[1];
        return new ChangeDirectory(this, directoryName).execute();
      }
      case "pwd" -> {
        return new PrintPath(this).execute();
      }
      case "mkdir" -> {
        String directoryName = commandParts[1];
        return new CreateDirectory(this, directoryName).execute();
      }
      case "rm" -> {
        String name;
        boolean recursive = false;
        if (commandParts.length > 2) {
          name = commandParts[2];
          recursive = commandParts[1].equals("--recursive");
        } else {
          name = commandParts[1];
        }
        return new Remove(this, name, recursive).execute();
      }
      default -> {
        return "Command: " + commandName + "not found";
      }
    }
  }
}
