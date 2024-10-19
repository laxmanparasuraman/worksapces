package round__3.feb2024;

//public class Directory {import java.util.*;

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
    public static void main(String[] args) {
        Directory root = new Directory("root");
        root.createDirectory("docs");
        root.createFile("notes.txt", "This is a sample file.");

        root.listAll();

        root.updateFileContent("notes.txt", "Updated content.");

        root.listAll();

        root.createFile("report.docx", "Report content.");
        root.updateDirectoryName("docs", "documents");
        root.updateFileName("notes.txt", "important_notes.txt");

        root.listAll();

        root.deleteFile("report.docx");
        root.deleteDirectory("documents");

        root.listAll();
    }
}
