package tech.one.place.model;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;
import java.util.Date;

@Entity
@Data

public class Reservation implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id;
    private long idSeat;
    @Id
    private long idUser;
    @Id
    private Date date;
}
