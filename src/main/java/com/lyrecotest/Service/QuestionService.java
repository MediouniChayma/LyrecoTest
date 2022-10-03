package com.lyrecotest.Service;

import com.lyrecotest.Common.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

public class QuestionService {
    private Logger logger = LoggerFactory.getLogger(QuestionService.class);
    private LinkedList<String> popQuestions = new LinkedList<>();
    private LinkedList<String>  scienceQuestions = new LinkedList<>();
    private LinkedList<String>  sportsQuestions = new LinkedList<>();
    private LinkedList<String>  rockQuestions = new LinkedList<>();
    public String createQuestion(String questionType,int index){
        return questionType+" Question " + index;
    }
    public QuestionService() {
        for (int i = 0; i < Const.NUMBER_QUESTION; i++) {
            popQuestions.addLast(createQuestion(Const.questionTypePop,i));
            scienceQuestions.addLast(createQuestion(Const.questionTypeScience,i));
            sportsQuestions.addLast(createQuestion(Const.questionTypeSport,i));
            rockQuestions.addLast(createQuestion(Const.questionTypeRock,i));
        }
    }
    public String currentCategory(int currentPlayer) {
        String s = Const.CATEGORY_SQUARE.get(GameService.players.get(currentPlayer).getPlace());
        s= s==null ? Const.questionTypeRock: s;
        return s;
    }

    public void askQuestion(int currentPlayer) {
        String s=this.currentCategory(currentPlayer);
        switch (s) {
            case Const.questionTypePop : logger.info(popQuestions.removeFirst().toString());
            break;
            case Const.questionTypeScience : logger.info(scienceQuestions.removeFirst().toString());
            break;
            case Const.questionTypeSport : logger.info(sportsQuestions.removeFirst().toString());
            break;
            case Const.questionTypeRock : logger.info(rockQuestions.removeFirst().toString());
            break;
            default:;
        }
    }

}
