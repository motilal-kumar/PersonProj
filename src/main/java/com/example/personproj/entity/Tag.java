package com.example.personproj.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tag_id;

    private String tag;

}
