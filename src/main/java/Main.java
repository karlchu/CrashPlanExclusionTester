import java.io.File;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            printUsage();
            return;
        }
        File root = new File(args[0]);
        Handler handler = new Handler(args[1]);
        listAllFilesRecursively(root, handler);

        System.out.printf("# Total size: %d\n", handler.getTotalSize());
    }

    private static void printUsage() {
        System.out.print("java Main <path_to_scan> <regex_to_scan>");
    }

    private static void listAllFilesRecursively(File file, Handler handler) {
        handler.handle(file);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null) return;
            for (File f : files) {
                listAllFilesRecursively(f, handler);
            }
        }
    }
}
