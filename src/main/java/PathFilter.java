import java.io.File;
import java.util.regex.Pattern;

public class PathFilter {
    private final Pattern exclusionPattern;

    public PathFilter(String exclusionRegex) {
        exclusionPattern = Pattern.compile(exclusionRegex);
    }

    public boolean permit(File file) {
        String path = file.getAbsolutePath();
         return !exclusionPattern.matcher(path).matches();
    }
}
