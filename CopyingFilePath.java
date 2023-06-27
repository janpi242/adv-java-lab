import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyingFilePath {
    public static void copyFileUsingPaths(String sourcePath, String destinationPath) throws IOException {
        long startTime = System.currentTimeMillis();

        Path source = Paths.get(sourcePath);
        Path destination = Paths.get(destinationPath);

        Files.copy(source, destination);

        long endTime = System.currentTimeMillis();
        System.out.println("Czas kopiowania pliku (Paths/Files): " + (endTime - startTime) + " ms");
    }

    public static void main(String[] args) {
        try {
            String sourcePath = "G:/code/sourceFile.txt";
            String destinationPath = "G:/code/destinationFile.txt";

            copyFileUsingPaths(sourcePath, destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

