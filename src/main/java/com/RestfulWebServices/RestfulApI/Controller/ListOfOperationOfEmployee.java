package com.RestfulWebServices.RestfulApI.Controller;

import com.RestfulWebServices.RestfulApI.Employee;
import com.RestfulWebServices.RestfulApI.Exception.UserNotFoundException;
import jakarta.validation.Valid;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController

public class ListOfOperationOfEmployee {
    List<Employee> allEmployees = new ArrayList<>(Arrays.asList(
            new Employee(1, "Rohit", 22),
            new Employee(2, "Anurag", 22),
            new Employee(3, "Anant", 25)
    ));


    @GetMapping(path = "/get-users", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Employee> getAllEmployees(){
        return allEmployees;
    }


    @GetMapping("/get-user/{id}")
    public EntityModel<Employee> getEmployeeById(@PathVariable int id){
        Employee user= allEmployees.stream().filter((e)->e.getId()==id).findFirst().orElse(null);
        if(user==null)
            throw new UserNotFoundException("id:"+id);
        EntityModel<Employee> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).getAllEmployees());
        entityModel.add(link.withRel("all-users"));

        return entityModel;

    }


    @PostMapping("add-user/post")
    public void addUser( @Valid @RequestBody Employee e){
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
//    @GetMapping("/all-users")
//    public List<Employee> getAllEmployees() {
//        return allEmployees;
//    }


}
