import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            printUsage();
            return;
        }
        File root = new File(args[0]);
        ArrayList<String> resultList = new ArrayList<String>();
        listAllFilesRecursively(root, resultList);

        long totalSize = 0L;

        Pattern pattern = Pattern.compile(args[1]);
        for (String path : resultList) {
            if (!pattern.matcher(path).matches()) {
                File file = new File(path);
                if (file.isFile()) totalSize += file.length();
                System.out.println(path);
            }
        }

        System.out.printf("# Total size: %d\n", totalSize);
    }

    private static void printUsage() {
        System.out.print("java Main <path_to_scan> <regex_to_scan>");
    }

    private static void listAllFilesRecursively(File file, ArrayList<String> resultList) {
        resultList.add(file.getAbsolutePath());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null) return;
            for (File f : files) {
                listAllFilesRecursively(f, resultList);
            }
        }
    }
}
