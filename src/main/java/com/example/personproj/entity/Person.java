package com.example.personproj.entity;



import lombok.Data;

import javax.persistence.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;


@Entity
@Table(name = "person_data")
@Data
public class Person {

    @Id
    @Column(nullable = false)
    private Long id;
    private String first_name;
    private String last_name;

    public String getFullName() {
        return Stream.of(first_name, last_name)
                .filter(x -> x != null && !x.isEmpty())
                .collect(joining(" "));
    }

   /* public String getFullName(){
        first_name = first_name!=null?first_name:"";
        last_name = last_name!=null?last_name:"";

        return (first_name + " " + last_name).trim();
    }*/

}
