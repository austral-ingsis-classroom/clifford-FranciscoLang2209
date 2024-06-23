package edu.austral.ingsis;

import edu.austral.ingsis.clifford.VirtualFileSystem;
import java.util.ArrayList;
import java.util.List;

public class FileSystemRunnerImpl implements FileSystemRunner {
  @Override
  public List<String> executeCommands(List<String> commands) {
    VirtualFileSystem fileSystem = new VirtualFileSystem();
    List<String> results = new ArrayList<>();

    for (String command : commands) {
      String result = fileSystem.execute(command);
      results.add(result);
    }

    return results;
  }
}
