package com.majidmokhtari.hangman.ui.model;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

/**
 * Created by majid on 4/30/2016.
 */
public class Answer {
    private String mWord;
    private Locale[] mLocales = Locale.getAvailableLocales();
    private ArrayList<String> mCountries = new ArrayList<String>();
    private String[] mAnimals;

    final Random rand = new Random();

    public Answer(String answer){

        //get the list countries
        for (Locale locale : mLocales) {
            String country = locale.getDisplayCountry();
            if (country.trim().length() > 0 && !mCountries.contains(country)) {
                mCountries.add(country);
            }
        }

        loadAnimals();

        if (answer.equals("Countries")){
            mWord = mCountries.get(rand.nextInt(mCountries.size() - 1) + 1).toUpperCase();
        } else if (answer.equals("Animals")){
            mWord = mAnimals[rand.nextInt((mAnimals.length - 1) + 1)].toUpperCase();
        }
    }

    public String getWord() {
        return mWord;
    }

    public void setWord(String word) {
        mWord = word;
    }

    public void loadAnimals(){
        mAnimals = new String[]{
            "Red Panda",
            "Giant Coconut Crab",
            "Red Velvet Ant",
            "Sloth",
            "Aye Aye",
            "Geoduck",
            "Giraffe Weevil",
            "Tapir",
            "Slender Loris",
            "Monkfish",
            "Sea Pig",
            "Stick Bug",
            "Giant Isopod",
            "Glass Frog",
            "Mata Mata",
            "Giant Weta",
            "Wrinkle-Faced Bat",
            "Walking Leaf",
            "Leafy Seadragon",
            "Blobfish",
            "Spiney Orbweaver Spider",
            "Rosey-Lipped Batfish",
            "Mantis Shrimp",
            "The Star-Nosed Mole",
            "Camel Spider"
        };
    }
}

