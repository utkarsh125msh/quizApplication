package com.example.demo.Controller;
import com.example.demo.Model.QuestionWrapper;
import com.example.demo.Service.QuizSrevice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@RequestMapping("/Quiz")
@CrossOrigin(origins = "https://quiz-app2024.vercel.app") // Replace with your frontend URL

public class QuizController {
    @Autowired
    QuizSrevice quizService;


    @PostMapping("/create")
    public ResponseEntity<Integer> createQuiz(@RequestParam int noOfQues, @RequestParam String topic, @RequestParam String title){
        return quizService.createQuiz(noOfQues, topic, title);// it'll return newlly created id for that quiz, so that in future he can accet that
    }
    
    @GetMapping("/get/{id}")//id = 1/2/3
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable int id){// getting quiz question using that id
        return quizService.getQuizQuestion(id);
    }

    @DeleteMapping("/Finish/{id}")
    public ResponseEntity<String> deleteQuizById(@PathVariable int id){
        return quizService.deleteQuizById(id);
    }
}
