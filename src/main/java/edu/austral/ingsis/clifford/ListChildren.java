package edu.austral.ingsis.clifford;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListChildren implements Command {
  private final VirtualFileSystem fileSystem;
  private final String order;

  public ListChildren(VirtualFileSystem fileSystem, String order) {
    this.fileSystem = fileSystem;
    this.order = order;
  }

  @Override
  public String execute() {
    List<Node> children = fileSystem.getCurrentDirectory().getChildren();
    List<String> names = children.stream().map(Node::getName).collect(Collectors.toList());

    if (order != null) {
      if (Objects.equals(order, "asc")) {
        names.sort(String::compareTo);
      } else if (order.equals("desc")) {
        names.sort(Collections.reverseOrder());
      }
    }

    return String.join(" ", names);
  }
}
