package com.RestfulWebServices.RestfulApI.FilterBean;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

//@JsonIgnoreProperties({"field1","field2"})
@JsonFilter("SomeBeanFilter")
public class FilterExample {
    private String field1;
//    @JsonIgnore
    private String field2;
    private String field3;
    public FilterExample(String field1,String field2,String field3){
        this.field1=field1;
        this.field2=field2;
        this.field3=field3;
    }
    public String getField1(){
        return field1;
    }
    public String getField2(){
        return field2;
    }
    public String getField3(){
        return field3;
    }
}
