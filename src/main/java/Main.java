import java.io.File;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            printUsage();
            return;
        }
        File root = new File(args[0]);
        PathFilter pathFilter = new PathFilter(args[1]);
        listAllFilesRecursively(root, pathFilter);

        System.out.printf("# Total size: %d\n", pathFilter.getTotalSize());
    }

    private static void printUsage() {
        System.out.print("java Main <path_to_scan> <regex_to_scan>");
    }

    private static void listAllFilesRecursively(File file, PathFilter pathFilter) {
        pathFilter.filterAndHandle(file);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null) return;
            for (File f : files) {
                listAllFilesRecursively(f, pathFilter);
            }
        }
    }
}
