import java.io.File;
import java.util.regex.Pattern;

public class Handler {
    private long totalSize = 0L;
    private final Pattern pattern;

    public Handler(String regex) {
        pattern = Pattern.compile(regex);
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void handle(File file) {
        String path = file.getAbsolutePath();
        if (!pattern.matcher(path).matches()) {
            if (file.isFile()) totalSize += file.length();
            System.out.println(path);
        }
    }
}
