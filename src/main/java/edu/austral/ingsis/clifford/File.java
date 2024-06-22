package edu.austral.ingsis.clifford;

public class File implements Node {
    private final String name;
    private final Directory parent;

    public File(String name, Directory parent) {
        this.name = name;
        parent.addChild(this);
        this.parent = parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Directory getParent() {
        return parent;
    }
}
