package com.example.shows;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="shows")
@Getter
@Setter
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;

}