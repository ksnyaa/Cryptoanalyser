import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCreator {
    public FileCreator() {
    }

    public static void createFiles(String name) throws IOException {
        Path path = Path.of("resources/" + name);
        if (!(Files.exists(path))) {
            Files.createFile(path);
        }
    }
}
