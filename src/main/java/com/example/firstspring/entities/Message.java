package com.example.firstspring.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
public class Message implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    private String text;

    //@JsonFormat(shape = JsonFormat.Shape.STRING) fazer dps
    private Instant date;


    @JsonIgnore //used to avoid multiple calls on jsons, um fica a chamar um e outro ficar a chamar o outro
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;


    public Message() {

    }

    public Message(String text, Instant date,  User sender) {
        super();
        this.text = text;
        this.date = date;
        this.sender = sender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
}
