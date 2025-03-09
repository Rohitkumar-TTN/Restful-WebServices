package com.RestfulWebServices.RestfulApI.Person;

public class Personv1 {
    String firstName;
    public Personv1(String firstName){
        this.firstName=firstName;
    }
    public String toString(){
        return firstName;
    }

    public String getFirstName() {  // Add this getter
        return firstName;
    }
}
