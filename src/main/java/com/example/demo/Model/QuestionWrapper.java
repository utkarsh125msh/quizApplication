package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class QuestionWrapper {

    public Integer id;
    public String questionTitle;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public String correctAnswer;

}
