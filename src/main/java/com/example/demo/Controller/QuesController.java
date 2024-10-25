package com.example.demo.Controller;
import com.example.demo.Model.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.QuesService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;



@RestController
@RequestMapping("Question")
@CrossOrigin(origins = "https://quiz-app2024.vercel.app") // Replace with your frontend URL

public class QuesController {
    
    @Autowired
    private QuesService quesService;


    @GetMapping("/GetQues")
    public ResponseEntity<List<entity>> getQuestion() {
        return quesService.getAllQues();
    }
    
    @PostMapping("/SavaQues")
    public ResponseEntity<String> SaveQuestion(@RequestBody List<entity> entity) {
        return quesService.saveQues(entity);
        
    }
    
    @DeleteMapping()
    public ResponseEntity<String> DeleteAll(){
        return quesService.deleteAll();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<entity>> GetQuestByCategory(@PathVariable String category){
        return quesService.getQuesByCategory(category);
    }

    @PostMapping("/addQues")
    public ResponseEntity<String> addQuestion(@RequestBody entity entity) {
        return quesService.addQuestion(entity);
    }
    
}
