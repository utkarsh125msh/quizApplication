package com.example.demo.Service;

import com.example.demo.Model.entity;
import com.example.demo.Repo.QuesDAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class QuesService {

    @Autowired
    QuesDAO quesDAO;
	
    public ResponseEntity<List<entity>> getAllQues(){
	    try{
		    return new ResponseEntity<>(quesDAO.findAll(),  HttpStatus.OK);
	    }catch(Exception e){
		    e.printStackTrace();
	    }
	    return new ResponseEntity<>(new ArrayList<>(),  HttpStatus.BAD_REQUEST);
    }



    public ResponseEntity<String> saveQues(List<entity> entities){
	    try{
            quesDAO.saveAll(entities);
		    return new ResponseEntity<>("Successfull",  HttpStatus.OK);
	    }catch(Exception e){
		    e.printStackTrace();
	    }
	    return new ResponseEntity<>("retry",  HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> deleteAll(){
	    try{
            quesDAO.deleteAll();
		    return new ResponseEntity<>("deleated successfully",  HttpStatus.OK);
	    }catch(Exception e){
		    e.printStackTrace();
	    }
	    return new ResponseEntity<>("retry",  HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<List<entity>> getQuesByCategory(String category){
	    try{
		    return new ResponseEntity<>(quesDAO.findByTopicName(category),  HttpStatus.OK);
	    }catch(Exception e){
		    e.printStackTrace();
	    }
	    return new ResponseEntity<>(new ArrayList<>(),  HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> addQuestion(entity entity){
	    try{
            quesDAO.save(entity);
		    return new ResponseEntity<>("question added successfully",  HttpStatus.CREATED);
	    }catch(Exception e){
		    e.printStackTrace();
	    }
	    return new ResponseEntity<>("retry",  HttpStatus.BAD_REQUEST);
    }
    
}
