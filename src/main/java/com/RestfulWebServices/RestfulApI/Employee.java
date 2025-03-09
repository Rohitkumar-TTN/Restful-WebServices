package com.RestfulWebServices.RestfulApI;

import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


public class Employee {

    private int id;

    @Size(min=2, message = "Name should have atleast 2 characters")
    private String name;

    private int age;

    public Employee( int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }
    public int getAge(){
        return age;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }

}
