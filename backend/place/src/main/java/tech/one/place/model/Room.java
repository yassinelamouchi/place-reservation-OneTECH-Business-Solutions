package tech.one.place.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Data

public class Room implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private int capacity=18;
    private String status;



}
