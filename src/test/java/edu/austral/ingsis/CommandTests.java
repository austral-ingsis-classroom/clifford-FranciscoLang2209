package edu.austral.ingsis;

import edu.austral.ingsis.clifford.*;
import org.junit.jupiter.api.Test;

public class CommandTests {
  @Test
  public void testListChildrenEmpty() {
    VirtualFileSystem fileSystem = new VirtualFileSystem();
    ListChildren ls = new ListChildren(fileSystem, null);
    assert (ls.execute().isEmpty());
  }

  @Test
  public void testListDirectories() {
    VirtualFileSystem fileSystem = new VirtualFileSystem();
    Directory dir1 = new Directory("dir1", fileSystem.getRoot());
    Directory dir2 = new Directory("dir2", fileSystem.getRoot());
    ListChildren ls = new ListChildren(fileSystem, null);
    assert (ls.execute().equals("dir1 dir2"));
  }

  @Test
  public void testCreateDirectory() {
    VirtualFileSystem fileSystem = new VirtualFileSystem();
    CreateDirectory mkdir = new CreateDirectory(fileSystem, "dir1");
    assert (mkdir.execute().equals("'dir1' directory created"));
  }

  @Test
  public void testTouch() {
    VirtualFileSystem fileSystem = new VirtualFileSystem();
    Touch touch = new Touch(fileSystem, "file1");
    assert (touch.execute().equals("'file1' file created"));
  }

  @Test
  public void testChangeDirectory() {
    VirtualFileSystem fileSystem = new VirtualFileSystem();
    Directory dir1 = new Directory("dir1", fileSystem.getRoot());
    ChangeDirectory cd = new ChangeDirectory(fileSystem, "dir1");
    assert (cd.execute().equals("moved to directory 'dir1'"));
  }

  @Test
  public void testRemove() {
    VirtualFileSystem fileSystem = new VirtualFileSystem();
    Directory dir1 = new Directory("dir1", fileSystem.getRoot());
    Remove rm = new Remove(fileSystem, "dir1", true);
    assert (rm.execute().equals("'dir1' removed"));
  }

  @Test
  public void testPrintPath() {
    VirtualFileSystem fileSystem = new VirtualFileSystem();
    Directory dir1 = new Directory("dir1", fileSystem.getRoot());
    fileSystem.setCurrentDirectory(dir1);
    PrintPath pwd = new PrintPath(fileSystem);
    assert (pwd.execute().equals("/dir1"));
  }
}
