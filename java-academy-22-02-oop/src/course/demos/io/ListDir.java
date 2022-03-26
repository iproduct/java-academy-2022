package course.demos.io;

import java.io.File;
import java.util.*;

public class ListDir {
    public static List<File> getFileList(File file, boolean recursive) {
        if (file.exists() && file.isDirectory()) {
            var children = Arrays.asList(file.listFiles());
            if (recursive) {
                var results = new ArrayList<File>();
                for (var child : children) {
                    if (child.isDirectory()) {
                        results.addAll(getFileList(child, recursive));
                    } else {
                        results.add(child);
                    }
                }
                return results;
            } else {
                return children;
            }
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        getFileList(new File("."), true).stream()
                .map(file -> String.format("| %-30.30s | %10.10s | %-20.20s",
                        file.getName(),
                        (file.isDirectory() ? "<DIR>" : file.length()),
                        new Date(file.lastModified())
                ))
                .forEach(System.out::println);
    }
}
