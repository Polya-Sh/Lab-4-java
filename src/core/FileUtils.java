package core;

import java.io.*;
import java.nio.file.*;
import java.util.*;


public class FileUtils {


    public static List<String> readLines(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    public static void writeLines(String filename, List<String> lines) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public static List<Integer> readNumbers(String filename) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        List<String> lines = readLines(filename);
        for (String line : lines) {
            try {
                numbers.add(Integer.parseInt(line.trim()));
            } catch (NumberFormatException e) {
                System.err.println("Пропущена некорректная строка: " + line);
            }
        }
        return numbers;
    }

    public static void writeNumbers(String filename, List<Integer> numbers) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Integer num : numbers) {
            lines.add(String.valueOf(num));
        }
        writeLines(filename, lines);
    }
}