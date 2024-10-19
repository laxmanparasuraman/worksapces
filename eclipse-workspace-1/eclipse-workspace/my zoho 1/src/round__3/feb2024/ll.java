package round__3.feb2024;

import java.util.*;

class File {
    private String name;
    private String content;

    public File(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class Directory {
    private String name;
    private List<Directory> directories;
    private List<File> files;

    public Directory(String name) {
        this.name = name;
        this.directories = new ArrayList<>();
        this.files = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public List<File> getFiles() {
        return files;
    }

    public void createDirectory(String name) {
        directories.add(new Directory(name));
    }

    public void createFile(String name, String content) {
        files.add(new File(name, content));
    }

    public void listAll() {
        System.out.println("Directories:");
        for (Directory dir : directories) {
            System.out.println(dir.getName());
        }
        System.out.println("Files:");
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    public void updateFileContent(String fileName, String content) {
        for (File file : files) {
            if (file.getName().equals(fileName)) {
                file.setContent(content);
                return;
            }
        }
        System.out.println("File not found.");
    }

    public void updateDirectoryName(String oldName, String newName) {
        for (Directory dir : directories) {
            if (dir.getName().equals(oldName)) {
                dir.name = newName;
                return;
            }
        }
        System.out.println("Directory not found.");
    }

    public void updateFileName(String oldName, String newName) {
        for (File file : files) {
            if (file.getName().equals(oldName)) {
                file.name = newName;
                return;
            }
        }
        System.out.println("File not found.");
    }

    public void deleteDirectory(String name) {
        Iterator<Directory> iterator = directories.iterator();
        while (iterator.hasNext()) {
            Directory dir = iterator.next();
            if (dir.getName().equals(name)) {
                iterator.remove();
                return;
            }
        }
        System.out.println("Directory not found.");
    }

    public void deleteFile(String name) {
        Iterator<File> iterator = files.iterator();
        while (iterator.hasNext()) {
            File file = iterator.next();
            if (file.getName().equals(name)) {
                iterator.remove();
                return;
            }
        }
        System.out.println("File not found.");
    }
}

public class InMemoryFileSystem {
    private Directory root;

    public InMemoryFileSystem() {
        root = new Directory("root");
    }

    public void createDirectory(String path) {
        String[] parts = path.split("/");
        Directory currentDir = root;
        for (String part : parts) {
            if (!part.isEmpty()) {
                boolean found = false;
                for (Directory dir : currentDir.getDirectories()) {
                    if (dir.getName().equals(part)) {
                        currentDir = dir;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    Directory newDir = new Directory(part);
                    currentDir.createDirectory(part);
                    currentDir = newDir;
                }
            }
        }
    }

    public void createFile(String path, String fileName, String content) {
        String[] parts = path.split("/");
        Directory currentDir = root;
        for (String part : parts) {
            if (!part.isEmpty()) {
                boolean found = false;
                for (Directory dir : currentDir.getDirectories()) {
                    if (dir.getName().equals(part)) {
                        currentDir = dir;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Directory not found.");
                    return;
                }
            }
        }
        currentDir.createFile(fileName, content);
    }

    public void listAll(String path) {
        String[] parts = path.split("/");
        Directory currentDir = root;
        for (String part : parts) {
            if (!part.isEmpty()) {
                boolean found = false;
                for (Directory dir : currentDir.getDirectories()) {
                    if (dir.getName().equals(part)) {
                        currentDir = dir;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Directory not found.");
                    return;
                }
            }
        }
        currentDir.listAll();
    }

    public void updateFileContent(String path, String fileName, String content) {
        String[] parts = path.split("/");
        Directory currentDir = root;
        for (String part : parts) {
            if (!part.isEmpty()) {
                boolean found = false;
                for (Directory dir : currentDir.getDirectories()) {
                    if (dir.getName().equals(part)) {
                        currentDir = dir;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Directory not found.");
                    return;
                }
            }
        }
        currentDir.updateFileContent(fileName, content);
    }

    public void updateDirectoryName(String path, String oldName, String newName) {
        String[] parts = path.split("/");
        Directory currentDir = root;
        for (String part : parts) {
            if (!part.isEmpty()) {
                boolean found = false;
                for (Directory dir : currentDir.getDirectories()) {
                    if (dir.getName().equals(part)) {
                        currentDir = dir;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Directory not found.");
                    return;
                }
            }
        }
        currentDir.updateDirectoryName(oldName, newName);
    }

    public void updateFileName(String path, String oldName, String newName) {
        String[] parts = path.split("/");
        Directory currentDir = root;
        for (String part : parts) {
            if (!part.isEmpty()) {
                boolean found = false;
                for (Directory dir : currentDir.getDirectories()) {
                    if (dir.getName().equals(part)) {
                        currentDir = dir;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Directory not found.");
                    return;
                }
            }
        }
        currentDir.updateFileName(oldName, newName);
    }

    public void deleteDirectory(String path, String name) {
        String[] parts = path.split("/");
        Directory currentDir = root;
        for (String part : parts) {
            if (!part.isEmpty()) {
                boolean found = false;
                for (Directory dir : currentDir.getDirectories()) {
                    if (dir.getName().equals(part)) {
                        currentDir = dir;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Directory not found.");
                    return;
                }
            }
        }
        currentDir.deleteDirectory(name);
    }

    public void deleteFile(String path, String name) {
        String[] parts = path.split("/");
        Directory currentDir = root;
        for (String part : parts) {
            if (!part.isEmpty()) {
                boolean found = false;
                for (Directory dir : currentDir.getDirectories()) {
                    if (dir.getName().equals(part)) {
                        currentDir = dir;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Directory not found.");
                    return;
                }
            }
        }
        currentDir.deleteFile(name);
    }

    public static void main(String[] args) {
        InMemoryFileSystem fileSystem = new InMemoryFileSystem();
        fileSystem.createDirectory("root/folder1");
        fileSystem.createFile("root/folder1", "file1.txt", "This is file 1 content");
        fileSystem.listAll("root");
        fileSystem.createDirectory("root/folder2");
        fileSystem.createFile("root/folder2", "file2.txt", "This is file 2 content");
        fileSystem.listAll("root");
        fileSystem.updateFileContent("root/folder1", "file1.txt", "Updated content for file 1");
        fileSystem.listAll("root");
        fileSystem.updateDirectoryName("root", "folder1", "newFolder");
        fileSystem.listAll("root");
        fileSystem.updateFileName("root/folder2", "file2.txt", "newFile.txt");
        fileSystem.listAll("root");
        fileSystem.deleteDirectory("root", "folder2");
        fileSystem.listAll("root");
        fileSystem.deleteFile("root/folder1", "file1.txt");
        fileSystem.listAll("root");
    }
}

