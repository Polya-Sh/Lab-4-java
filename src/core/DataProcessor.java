package core;

import java.util.*;

public class DataProcessor {


    public static String[] processPipeline(String[] inputLines) {
        try {
            List<Integer> numbers1 = new ArrayList<>();
            List<Integer> numbers2 = new ArrayList<>();

            boolean isSecondList = false;
            for (String line : inputLines) {
                String trimmed = line.trim();
                if (trimmed.isEmpty()) {
                    isSecondList = true;
                    continue;
                }

                try {
                    int num = Integer.parseInt(trimmed);
                    if (!isSecondList) {
                        numbers1.add(num);
                    } else {
                        numbers2.add(num);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка преобразования строки в число: " + line);
                }
            }

            List<Integer> resultNumbers = processVariant6(numbers1, numbers2);

            String[] resultStrings = new String[resultNumbers.size()];
            for (int i = 0; i < resultNumbers.size(); i++) {
                resultStrings[i] = String.valueOf(resultNumbers.get(i));
            }

            return resultStrings;

        } catch (Exception e) {
            System.err.println("Ошибка при обработке данных: " + e.getMessage());
            return new String[0];
        }
    }


    public static List<Integer> processVariant6(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();

        Set<Integer> set2 = new HashSet<>(list2);

        for (Integer num : list1) {
            if (!set2.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

    public static List<Integer> stringsToIntegers(String[] strings) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : strings) {
            try {
                numbers.add(Integer.parseInt(s.trim()));
            } catch (NumberFormatException e) {
                // Игнорируем некорректные строки
            }
        }
        return numbers;
    }

    public static String[] integersToStrings(List<Integer> numbers) {
        String[] strings = new String[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            strings[i] = String.valueOf(numbers.get(i));
        }
        return strings;
    }
}