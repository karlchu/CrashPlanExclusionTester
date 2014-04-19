import java.io.File;

public class ResultHandler {
    private long totalSize = 0L;
    private long count = 0L;

    public void handle(File file) {
        if (file.isFile()) {
            totalSize += file.length();
            count++;
        }
        System.out.println(file.getAbsoluteFile());
    }

    public long getTotalSize() {
        return totalSize;
    }

    public long getCount() {
        return count;
    }
}
