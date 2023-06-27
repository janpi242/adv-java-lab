import java.io.*;

public class FileCopying {
    public static void copyFileUsingStreams(String sourcePath, String destinationPath) throws IOException {
        long startTime = System.currentTimeMillis();

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(sourcePath);
            outputStream = new FileOutputStream(destinationPath);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Czas kopiowania pliku (InputStream/OutputStream): " + (endTime - startTime) + " ms");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public static void copyFileUsingFileReaderWriter(String sourcePath, String destinationPath) throws IOException {
        long startTime = System.currentTimeMillis();

        FileReader reader = null;
        FileWriter writer = null;

        try {
            reader = new FileReader(sourcePath);
            writer = new FileWriter(destinationPath);

            char[] buffer = new char[1024];
            int length;
            while ((length = reader.read(buffer)) > 0) {
                writer.write(buffer, 0, length);
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Czas kopiowania pliku (FileReader/FileWriter): " + (endTime - startTime) + " ms");
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static void copyFileUsingBufferedReaderWriter(String sourcePath, String destinationPath) throws IOException {
        long startTime = System.currentTimeMillis();

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(sourcePath));
            writer = new BufferedWriter(new FileWriter(destinationPath));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Czas kopiowania pliku (BufferedReader/BufferedWriter): " + (endTime - startTime) + " ms");
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            String sourcePath = "G:/code/sourceFile.txt";
            String destinationPath = "G:/code/destinationFile.txt";

            copyFileUsingStreams(sourcePath, destinationPath);
            copyFileUsingFileReaderWriter(sourcePath, destinationPath);
            copyFileUsingBufferedReaderWriter(sourcePath, destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// Wyniki 1MB txt:
//    Czas kopiowania pliku (InputStream/OutputStream): 14 ms
//    Czas kopiowania pliku (FileReader/FileWriter): 29 ms
//    Czas kopiowania pliku (BufferedReader/BufferedWriter): 39 ms
// Wnioski:
// Najszybsze są strumienie