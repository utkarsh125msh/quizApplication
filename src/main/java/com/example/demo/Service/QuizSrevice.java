package com.example.demo.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import com.example.demo.Model.QuestionWrapper;
import com.example.demo.Model.Quiz;
import com.example.demo.Model.entity;
import com.example.demo.Repo.QuesDAO;
import com.example.demo.Repo.QuizDAO;


@Service
public class QuizSrevice {


    @Autowired
    QuizDAO quizDAO;

    @Autowired
    QuesDAO quesDAO;

    public ResponseEntity<Integer> createQuiz(int noOfQues, String category, String title) {
        try {
            Pageable limit = PageRequest.of(0, noOfQues);
            List<entity> questions = quesDAO.findRandomQuestionByCategory(limit, category);
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);
            quizDAO.save(quiz);
            return new ResponseEntity<>(quiz.getId(), HttpStatus.OK);
        } catch (Exception e) {

            System.out.println();
            e.printStackTrace();
            System.out.println();
        }
        return new ResponseEntity<>(-1, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id) {
       
       
       try {
        Optional<Quiz> ques = quizDAO.findById(id);
        List<entity> quesFromDb = ques.get().getQuestions();
        List<QuestionWrapper> quesForUser = new ArrayList<>();
        for (entity e: quesFromDb) {
            QuestionWrapper qw = new QuestionWrapper(e.getId(), e.getQuestionTitle(), e.getOption1(), e.getOption2(), e.getOption3(), e.getOption4(), e.getCorrectAnswer());
            quesForUser.add(qw);
        }
        return  new ResponseEntity<>(quesForUser, HttpStatus.OK);
       } catch (Exception e) {
            e.printStackTrace();
        } 
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteQuizById(int id) {
        try {
            System.out.println(quizDAO.findById(id));
            quizDAO.deleteById(id);
            System.out.println(quizDAO.findById(id));
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }   
        return new ResponseEntity<>("Failed", HttpStatus.NOT_FOUND);
    }
}
