package tech.one.place.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Data

public class Seat implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id;
    private String status="free";

    private long idRoom;
}
