package com.example.testingsystemproject.repositories;
import com.example.testingsystemproject.dao.QuestionDao;
import com.example.testingsystemproject.database.AppDatabase;
import com.example.testingsystemproject.models.Question;
import com.example.testingsystemproject.models.QuestionWithAnswer;

import java.util.List;

import javax.inject.Singleton;

@Singleton
public class QuestionRepository {
    private final QuestionDao dao;
    public QuestionRepository(AppDatabase appDatabase) {
        dao = appDatabase.questionDao();
    }
    public List<Question> getByCategoryId(int categoryId, int n){
        return dao.getByCategoryId(categoryId, n);
    }

    public List<QuestionWithAnswer> getQuestion(){
        return dao.getQuestion();
    }
}