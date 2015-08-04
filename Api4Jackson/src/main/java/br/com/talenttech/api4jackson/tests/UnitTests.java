/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.talenttech.api4jackson.tests;

import br.com.talenttech.api4jackson.Api4Jackson;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author eldermoraes
 */
public class UnitTests {
    
    public static void main(String[] args) throws IOException{
        Employee emp1 = new Employee("John", 5000, "IT", 34);
        Employee emp2 = new Employee("Mary", 7500, "HS", 37);
        List<Employee> listEmp = new ArrayList<>();
        listEmp.add(emp1);
        listEmp.add(emp2);
        File file = Api4Jackson.getObjectAsJSONFile(listEmp);
        
        BufferedReader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
        List<String> list = reader.lines().flatMap(line -> Stream.of(line)).collect(toList());
        System.out.println("[ObjectAsFile]: " + list);
        
        String jsonString = Api4Jackson.getObjectAsJSONString(listEmp);
        System.out.println("[ObjectAsString]: " + list);
        
        System.out.println("[FileAsObject]: " + Api4Jackson.getJSONFileAsObject(file, List.class));
        
        System.out.println("[StringAsObject]: " + Api4Jackson.getJSONStringAsObject(jsonString,List.class));
    }
}
