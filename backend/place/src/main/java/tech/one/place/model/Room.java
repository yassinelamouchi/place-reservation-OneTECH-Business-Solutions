package tech.one.place.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Data

public class Room implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id;
    private int capacity;
    private String status;
    private long idPlace;


}
