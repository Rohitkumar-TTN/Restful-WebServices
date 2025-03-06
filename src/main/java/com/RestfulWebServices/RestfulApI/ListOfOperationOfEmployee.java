package com.RestfulWebServices.RestfulApI;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@Validated
public class ListOfOperationOfEmployee {
    List<Employee> allEmployees = new ArrayList<>(Arrays.asList(
            new Employee(1, "Rohit", 22),
            new Employee(2, "Anurag", 22),
            new Employee(3, "Anant", 25)
    ));
    @GetMapping("/get-users")
    public List<Employee> getAllEmployees(){
        return allEmployees;
    }
    @GetMapping("/get-user/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return allEmployees.stream().filter((e)->e.getId()==id).findFirst().orElse(null);
    }
    @PostMapping("add-user/post")
    public void addUser( @Validated @RequestBody Employee e){
        allEmployees.add(e);
    }
    @DeleteMapping("del-user/{id}")
    public void delUserById(@PathVariable int id){
//        List<Employee> demo=allEmployees.stream().filter((e)->e.getId()!=id).toList();
//        allEmployees=demo;
        allEmployees.removeIf((e)->e.getId()==id);
    }
    @PutMapping("update-user/{id}")
    public void updateUser(@PathVariable int id,@RequestBody Employee e){
        int j= IntStream.range(0,allEmployees.size()).filter((i)->allEmployees.get(i).getId()==id).findFirst().orElse(-1);
        allEmployees.set(j,e);
    }
}
