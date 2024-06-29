import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class WordCounter {
    static String text = """
            Press 1 for Counting Bytes,
            Press 2 for Counting Lines,
            Press 3 for Counting number of words,
            Press 4 for Counting Characters
            """;

    static String filePath = "C:\\Users\\HTM3\\Desktop\\Files\\test.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(filePath);
        Scanner sc = new Scanner(System.in);
        System.out.println(text);
        int number = sc.nextInt();
        int count = switch (number) {
            case 1 -> countBytes(file);
            case 2 -> countLines(file);
            case 3 -> countWords(file);
            case 4 -> countCharacters(file);
            default -> 0;
        };
        System.out.println(count);
    }

    private static int countBytes(File file) throws IOException {
        int count = 0;
        byte[] bytes = Files.readAllBytes((file.toPath()));
        for (byte b : bytes) {
            count++;
        }
        return count;
    }

    private static int countLines(File file) throws IOException {
        BufferedReader reader = null;
        int count = 0;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                count++;
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
        return count;
    }
    private static int countWords(File file) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new FileInputStream(file))) {
            int count = 0;
            while (sc.hasNext()) {
                sc.next();
                count++;
            }
            return count;
        }
    }

    private static int countCharacters(File file) {
        int totalCharCount;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new
                File(String.valueOf(file))))) {
            String line;
            totalCharCount = 0;
            while ((line = bufferedReader.readLine()) != null) {
                int charCount = line.split("\n").length;
                totalCharCount += charCount;
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return totalCharCount;
    }
}
