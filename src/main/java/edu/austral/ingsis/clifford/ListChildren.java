package edu.austral.ingsis.clifford;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<String> names = new ArrayList<>();
        for (Node child : children) {
            names.add(child.getName());
        }

        if (order.equals("asc")) {
            names.sort(String::compareTo);
        } else if (order.equals("desc")) {
            names.sort(Collections.reverseOrder());
        }

        return String.join( " ", names);
    }
}
