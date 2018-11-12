package com.example.ferna.mytesty;

import java.io.Serializable;


//Doubly Linked List Nonsense
//0 is Multiple Choice, 1 is True False, 2 is Free Response
public class Quiz implements Serializable
{
    Question head;
    Question current;
    int questionCount;

    Quiz()
    {
        Question head = null;
        Question current = null;
        questionCount = 0;
    }

    void addQuest(int questType, String qQuestion, String corAns, String wroAns1, String wroAns2, String wroAns3, Boolean tF)
    {
        Question newQuest = new Question(questType, qQuestion, corAns, wroAns1, wroAns2, wroAns3, tF);
        if(head == null)
        {
            head = newQuest;
            current = head;
        }
        else
        {
            current.next = newQuest;
            newQuest.previous = current;
            current = newQuest;
        }
    }

    void reset()
    {
        current = null;
    }

    void nextQuestion()
    {
        if(current == null)
            current = head;
        else if(current.next == null)
            ;
        else
            current = current.next;
    }

    void previousQuestion()
    {
        if(current == null)
            current = head;
        else if(current.previous == null)
            ;
        else
            current = current.previous;
    }

    class Question implements Serializable
    {
        private int quesType;
        private String quizQuestion;
        private String corrAns;
        private String wrongAns1;
        private String wrongAns2;
        private String wrongAns3;
        private Boolean truFal;
        private Boolean answeredCorrect;
        private String savedAnswer;
        private Boolean checkRandom;
        Question previous, next;

        Question(int questType, String qQuestion, String corAns, String wroAns1, String wroAns2, String wroAns3, Boolean tF)
        {
            setQuesType(questType);
            setQuizQuestion(qQuestion);
            setCorrAns(corAns);
            setWrongAns1(wroAns1);
            setWrongAns2(wroAns2);
            setWrongAns3(wroAns3);
            setTruFal(tF);
            setAnsweredCorrect(false);
            setSavedAnswer("zzzzqqqq1");
            setCheckRandom(false);
            previous = null;
            next = null;
        }

        public String getQuizQuestion() {
            return quizQuestion;
        }

        public void setQuizQuestion(String quizQuestion) {
            this.quizQuestion = quizQuestion;
        }

        public int getQuesType() {
            return quesType;
        }

        public void setQuesType(int quesType) {
            this.quesType = quesType;
        }

        public String getCorrAns() {
            return corrAns;
        }

        public void setCorrAns(String corrAns) {
            this.corrAns = corrAns;
        }

        public String getWrongAns1() {
            return wrongAns1;
        }

        public void setWrongAns1(String wrongAns1) {
            this.wrongAns1 = wrongAns1;
        }

        public String getWrongAns2() {
            return wrongAns2;
        }

        public void setWrongAns2(String wrongAns2) {
            this.wrongAns2 = wrongAns2;
        }

        public String getWrongAns3() {
            return wrongAns3;
        }

        public void setWrongAns3(String wrongAns3) {
            this.wrongAns3 = wrongAns3;
        }

        public Boolean getTruFal() {
            return truFal;
        }

        public void setTruFal(Boolean truFal) {
            this.truFal = truFal;
        }

        public Boolean getAnsweredCorrect() {
            return answeredCorrect;
        }

        public void setAnsweredCorrect(Boolean answeredCorrect) {
            this.answeredCorrect = answeredCorrect;
        }

        public String getSavedAnswer() {
            return savedAnswer;
        }

        public void setSavedAnswer(String savedAnswer) {
            this.savedAnswer = savedAnswer;
        }

        public Boolean getCheckRandom() {
            return checkRandom;
        }

        public void setCheckRandom(Boolean checkRandom) {
            this.checkRandom = checkRandom;
        }
    }


}
