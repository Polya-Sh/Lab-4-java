package core;

import java.util.ArrayList;
import java.util.List;

public class DataProcessor {
    /**
     * ВАРИАНТ 6: Возвращает элементы первого списка,
     * которых нет во втором списке.
     * ({ 4, 5, 2, 1, 7, 5, 2 }, { 5, 1, 8, 9 }) → { 4, 2, 7, 2 }
     */
    public static List<Number> processVariant6(List<Number> list1, List<Number> list2) {
        List<Number> result = new ArrayList<>(list1);
        result.removeAll(list2);
        return result;
    }


    private void processPipeline(){

    }
}
