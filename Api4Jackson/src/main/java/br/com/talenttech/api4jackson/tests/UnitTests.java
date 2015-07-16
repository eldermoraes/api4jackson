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
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author eldermoraes
 */
public class UnitTests {
    
    public static void main(String[] args) throws IOException{
        Employee emp = new Employee("John", 5000, "IT", 34);
        File file = Api4Jackson.getObjectAsJSONFile(emp);
        
        BufferedReader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
        List<String> list = reader.lines().flatMap(line -> Stream.of(line)).collect(toList());
        System.out.println("[File]: " + list);
        
        String jsonString = Api4Jackson.getObjectAsJSONString(emp);
        System.out.println("[String]: " + list);
    }
}
