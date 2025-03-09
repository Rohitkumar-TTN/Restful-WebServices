package com.RestfulWebServices.RestfulApI.Controller;

import com.RestfulWebServices.RestfulApI.Person.Name;
import com.RestfulWebServices.RestfulApI.Person.Personv1;
import com.RestfulWebServices.RestfulApI.Person.Personv2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {


    @GetMapping("/v1/person")
    public Personv1 getFirstVersionOfPerson(){
        Personv1 x=new Personv1("rohit");
        return x;
    }
    @GetMapping("/v2/person")
    public Personv2 getSecondVersionOfPerson(){
        return new Personv2(new Name("Rohit","Upadhyay"));
    }


    @GetMapping(path = "/person", params = "version=1")
    public Personv1 getFirstVersionOfPersonRequestParameter() {
        return new Personv1("Rohit Upadhyay");
    }

    @GetMapping(path = "/person", params = "version=2")
    public Personv2 getSecondVersionOfPersonRequestParameter() {
        return new Personv2(new Name("Rohit", "Upadhyay"));
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public Personv1 getFirstVersionOfPersonRequestHeader() {
        return new Personv1("Rohit Upadhyay");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public Personv2 getSecondVersionOfPersonRequestHeader() {
        return new Personv2(new Name("Rohit", "Upadhyay"));
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public Personv1 getFirstVersionOfPersonAcceptHeader() {
        return new Personv1("Rohit Upadhyay");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public Personv2 getSecondVersionOfPersonAcceptHeader() {
        return new Personv2(new Name("Rohit", "Upadhyay"));
    }
}
