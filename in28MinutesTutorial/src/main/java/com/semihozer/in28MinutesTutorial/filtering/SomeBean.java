package com.semihozer.in28MinutesTutorial.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
//@JsonIgnoreProperties("field2")
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    //@JsonIgnore
    private String field1;
    private String field2;
    //@JsonProperty("field_3")
    private String field3;
}
