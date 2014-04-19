import java.io.File;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            printUsage();
            return;
        }
        File root = new File(args[0]);
        PathFilter pathFilter = new PathFilter(args[1]);
        ResultHandler resultHandler = new ResultHandler();
        processAllFilesRecursively(root, pathFilter, resultHandler);

        System.out.printf("# Total count: %d\n", resultHandler.getCount());
        System.out.printf("# Total size:  %d\n", resultHandler.getTotalSize());
    }

    private static void printUsage() {
        System.out.print("java Main <path_to_scan> <regex_to_scan>");
    }

    private static void processAllFilesRecursively(File file, PathFilter pathFilter, ResultHandler resultHandler) {
        if (pathFilter.permit(file)) {
            resultHandler.handle(file);
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null) return;
            for (File f : files) {
                processAllFilesRecursively(f, pathFilter, resultHandler);
            }
        }
    }
}
