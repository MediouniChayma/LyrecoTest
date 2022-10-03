package com.lyrecotest;

import com.lyrecotest.Common.Const;
import com.lyrecotest.Service.PlayerService;
import com.lyrecotest.Service.QuestionService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class QuestionTest {
    private final Logger logger = LoggerFactory.getLogger(PlayerTest.class);
    QuestionService questionService=new QuestionService();
    PlayerService playerService=new PlayerService();

    @Test
    public void createQuestions(){
        String questionType = Const.questionTypeRock;
        String Expectedresult = questionType+" Question " + 1;
        assertEquals(Expectedresult,questionService.createQuestion(questionType,1));
    }

    @Test
    public void askQuestions(){
        playerService.add("Chayma");
        playerService.add("Safia");
        questionService.askQuestion(1);
    }

}
