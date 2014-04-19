import java.io.File;
import java.util.regex.Pattern;

public class PathFilter {
    private long totalSize = 0L;
    private final Pattern pattern;

    public PathFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void filterAndHandle(File file) {
        String path = file.getAbsolutePath();
        if (!pattern.matcher(path).matches()) {
            if (file.isFile()) totalSize += file.length();
            System.out.println(path);
        }
    }
}
