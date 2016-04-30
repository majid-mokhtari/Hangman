package com.majidmokhtari.hangman.ui.model;

/**
 * Created by majid on 4/24/2016.
 */
public class Game {
    private String mAnswer;
    private String mHits;
    private String mMisses;
    private Integer mCounter;

    public Integer getCounter() {
        return mCounter;
    }

    public void setCounter(Integer counter) {
        mCounter = counter;
    }

    public Game(String answer){
        mAnswer = answer;
        mHits = "";
        mMisses = "";
        mCounter = 0;
    }

    public boolean applyGuess(char letter){
        boolean isHit = mAnswer.indexOf(letter) >= 0;
        if(isHit){
            mHits += letter;
        } else {
            mMisses += letter;
            mCounter++;
        }
        return isHit;
    }

    public String getCurrentProgress(){
        String progress = "";
        for (char letter : mAnswer.toCharArray()){
            char display = '_';
            if (mHits.indexOf(letter) >= 0 || letter == ' '){
                display = letter;
            }
            progress += display + " ";
        }
        return progress;
    }

}
