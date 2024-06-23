package edu.austral.ingsis;

import edu.austral.ingsis.clifford.Directory;
import edu.austral.ingsis.clifford.VirtualFileSystem;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FileTests {
  @Test
  public void testListChildrenEmpty() {
    VirtualFileSystem fileSystem = new VirtualFileSystem();
    assert (fileSystem.getCurrentDirectory().getChildren().isEmpty());
  }

  @Test
  public void testListChildrenNotEmpty() {
    VirtualFileSystem fileSystem = new VirtualFileSystem();
    Directory dir1 = new Directory("dir1", fileSystem.getCurrentDirectory());
    Directory dir2 = new Directory("dir2", fileSystem.getCurrentDirectory());
    assert (fileSystem.getCurrentDirectory().getChildren().size() == 2);
  }

  @Test
  public void testInsideDirectory() {
    VirtualFileSystem fileSystem = new VirtualFileSystem();
    Directory dir1 = new Directory("dir1", fileSystem.getCurrentDirectory());
    Directory dir2 = new Directory("dir2", dir1);
    assert (fileSystem.getCurrentDirectory().getChildren().equals(List.of(dir1)));
    assert (dir1.getChildren().equals(List.of(dir2)));
  }

  @Test
  public void testRemoveChild() {
    VirtualFileSystem fileSystem = new VirtualFileSystem();
    Directory dir1 = new Directory("dir1", fileSystem.getCurrentDirectory());
    Directory dir2 = new Directory("dir2", dir1);
    Directory dir3 = new Directory("dir3", dir1);
    assert (dir1.getChildren().equals(List.of(dir2, dir3)));
    dir1.removeChild(dir2);
    assert (dir1.getChildren().equals(List.of(dir3)));
  }
}
