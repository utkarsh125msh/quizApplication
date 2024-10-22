package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//this is M from MVC, this is question table
@Entity
@Table(name = "entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class entity {
    // class field is table column   -->   ORM(JPA in our case)
    // object of entity is row

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String questionTitle;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public String correctAnswer;
    public String difficultyLevel;
    public String topicName;
    

}
