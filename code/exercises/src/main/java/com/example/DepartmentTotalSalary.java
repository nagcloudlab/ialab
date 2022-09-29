package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class DepartmentTotalSalary {
    public static void main(String[] args) {

        String[] csvReport = {"E1,IT,1000", "E2,HR,2000", "E3,IT,3000", "E4,IT,1000", "E5,SALES,2000"};

        // way-1: imperative style
        Map<String, Double> result = new HashMap<>();
        for (String record : csvReport) {
            String[] tokens = record.split(",");
            String depName = tokens[1];
            double salary = Double.parseDouble(tokens[2]);
            if (result.containsKey(depName))
                result.put(depName, result.get(depName) + salary);
            else
                result.put(depName, salary);
        }
        System.out.println(result);
        System.out.println("-".repeat(100));
        // way-2: declarative style with streams api
        System.out.println(
                Arrays.stream(csvReport)
                        .map(record -> record.split(","))
                        .collect(groupingBy(tokens -> tokens[1],
                                summingDouble(tokens -> Double.parseDouble(tokens[2]))))
        );


    }
}
