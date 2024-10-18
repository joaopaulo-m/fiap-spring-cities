package com.example.helloworld.Domain.Cities;

import javax.persistence.*;
import java.time.DateTimeException;
import java.util.Date;

@Entity
@Table(name ="WATERSTATUSCITIES")
public class CitiesStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "water_status_cities_seq")
    @SequenceGenerator(name = "water_status_cities_seq", sequenceName = "water_status_cities_seq", allocationSize = 1)
    private int id;
    private  String Status;
    private String Msg;
    private Date date_updated;
    private String city;


    public int getId() {
        return id;
    }

    public String getStatus() {
        return Status;
    }

    public String getMsg() {
        return Msg;
    }

    public Date getDate_updated() {
        return date_updated;
    }

    public String getCity() {
        return city;
    }






    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public void setDate_updated(Date date_updated) {
        this.date_updated = date_updated;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CitiesStatus(int id, String status, String msg, Date date_updated, String city) {
        this.id = id;
        Status = status;
        Msg = msg;
        this.date_updated = date_updated;
        this.city = city;

    }

    public CitiesStatus() {

    }
}
