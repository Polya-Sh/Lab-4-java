package console;

import core.*;
import models.InputArgs;
import java.io.IOException;
import java.util.*;


public class ConsoleApp {

    public static void main(String[] args) {
        try {
            InputArgs inputArgs = new InputArgs(args);

            System.out.println("Консольное приложение обработки данных");
            System.out.println("Входной файл: " + inputArgs.getInputFile());
            if (inputArgs.hasOutputFile()) {
                System.out.println("Выходной файл: " + inputArgs.getOutputFile());
            }

            List<String> lines = FileUtils.readLines(inputArgs.getInputFile());
            System.out.println("Прочитано строк: " + lines.size());

            String[] inputArray = lines.toArray(new String[0]);
            String[] results = DataProcessor.processPipeline(inputArray);

            System.out.println("\nРезультаты обработки");
            System.out.println("Найдено элементов: " + results.length);
            System.out.println("Результаты:");
            for (String result : results) {
                System.out.println(result);
            }

            if (inputArgs.hasOutputFile()) {
                List<String> resultList = Arrays.asList(results);
                FileUtils.writeLines(inputArgs.getOutputFile(), resultList);
                System.out.println("\nРезультаты сохранены в файл: " + inputArgs.getOutputFile());
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
            printUsage();
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printUsage() {
        System.out.println("\nИспользование:");
        System.out.println("java ConsoleApp -i <входной_файл> [-o <выходной_файл>]");
        System.out.println("Пример: java ConsoleApp -i test/input01.txt -o output/result.txt");
    }
}