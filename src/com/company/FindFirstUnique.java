package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstUnique {
    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 2, 6, 6};
        int[] arr2 = {4, 4, 4, 3};
        System.out.println(findFirstUnique2(arr));
    }

    public static int findFirstUnique2(int[] arr) {
        int unique = -1;
        for (int i = 0; i < arr.length; i++) {
            boolean isRepeated = false;

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j] && i != j) {
                    isRepeated = true;
                    break;
                }
            }

            if (!isRepeated){
                return arr[i];
            }
        }


        return unique;
    }

    public static int findFirstUnique(int[] arr) {
        int unique = -1;
        Map<Integer, Integer> numToOccurance = new LinkedHashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Integer num = numToOccurance.get(arr[i]);
            if (num == null) {
                numToOccurance.put(arr[i], 1);
                continue;
            }
            numToOccurance.replace(arr[i], num + 1);
        }

        for (Map.Entry<Integer, Integer> entry : numToOccurance.entrySet()) {
            if (entry.getValue() == 1) {
                unique = entry.getKey();
                break;
            }
        }
        return unique;
    }


}
