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

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\HTM3\\Desktop\\Files\\test.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println(text);
        int number = sc.nextInt();
        int count;
        switch (number) {
            case 1:
                count = countBytes(file);
                break;
            case 2:
                count = countLines(file);
                break;
            case 3:
                count = countWords(file);
                break;
            case 4:
                count = countCharacters(file);
                break;
        }


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

    private static int countWords(File file) {
    }

    private static int countCharacters(File file) {

    }


}
