package com.danielyoon.foodfourmood;

import java.util.HashMap;

public class Questions {

    private String[] moodQuestions = {
      "How did you wake up this morning?",
      "What interests you the most out of these?",
      "What type of music would you listen to right now?",
      "Would you read any of these?",
            "Feel like meeting people today?",
            "How was your appetite recently?",
            "How old do you feel right now?",
            "Best vacation destination right now?",
            "Mode of transportation?",
            "How was this experience?"
    };

    private String[][] answerChoices = {
            {"Energetic!", "More tired than before", "Same old same old", "Hungry"},
            {"Exercising", "Eating", "Sleeping", "Something spontaneous!"},
            {"Rock/Rap/Pop", "Blues/Jazz/Ballad", "Classical", "Music of silence"},
            {"A Textbook", "Magazine", "Casual Book", "Who reads?"},
            {"Yes!", "Nope", "I'm indifferent to it", "Only my close friends"},
            {"I've been getting fat", "Just 3 meals a day", "Haven't really been eating", "No appetite at all"},
            {"Too old to be alive", "Young and wild!", "Just about the right age", "It depends"},
            {"Home!", "Somewhere warm and sunny", "Somewhere cold and snowy", "I'm content where I am"},
            {"Lion", "Horse", "Car", "Walking"},
            {"Great!", "Horrible", "Meh, I'm just hungry", "Could've been better!"}};

    HashMap<String, String> moodIdentifier;

    {
        moodIdentifier = new HashMap<>();
        moodIdentifier.put("Energetic!", "r");
        moodIdentifier.put("More tired than before", "y");
        moodIdentifier.put("Same old same old", "b");
        moodIdentifier.put("Hungry", "w");
        moodIdentifier.put("Exercising", "r");
        moodIdentifier.put("Sleeping", "y");
        moodIdentifier.put("Eating", "b");
        moodIdentifier.put("Something spontaneous!", "w");
        moodIdentifier.put("Rock/Rap/Pop", "r");
        moodIdentifier.put("Music of silence", "y");
        moodIdentifier.put("Blues/Jazz/Ballad", "b");
        moodIdentifier.put("Classical", "w");
        moodIdentifier.put("Magazine", "r");
        moodIdentifier.put("Casual Book", "y");
        moodIdentifier.put("Who reads?", "b");
        moodIdentifier.put("A Textbook", "w");
        moodIdentifier.put("Yes!", "r");
        moodIdentifier.put("I'm indifferent to it", "y");
        moodIdentifier.put("Nope", "b");
        moodIdentifier.put("Only my close friends", "w");
        moodIdentifier.put("I've been getting fat", "r");
        moodIdentifier.put("Haven't really been eating", "y");
        moodIdentifier.put("No appetite at all", "b");
        moodIdentifier.put("Just 3 meals a day", "w");
        moodIdentifier.put("Young and wild!", "r");
        moodIdentifier.put("It depends", "y");
        moodIdentifier.put("Too old to be alive", "b");
        moodIdentifier.put("Just about the right age", "w");
        moodIdentifier.put("Somewhere warm and sunny", "r");
        moodIdentifier.put("Home!", "y");
        moodIdentifier.put("Somewhere cold and snowy", "b");
        moodIdentifier.put("I'm content where I am", "w");
        moodIdentifier.put("Lion", "r");
        moodIdentifier.put("Horse", "y");
        moodIdentifier.put("Walking", "b");
        moodIdentifier.put("Car", "w");
        moodIdentifier.put("Great!", "r");
        moodIdentifier.put("Could've been better!", "y");
        moodIdentifier.put("Horrible", "b");
        moodIdentifier.put("Meh, I'm just hungry", "w");
    }

    public String getQuestion(int x) {
        String question = moodQuestions[x];
        return question;
    }

    public String getChoices(int x, int y) {
        String choice = answerChoices[x][y];
        return choice;
    }

    public String getColor(String x) {
        String color = moodIdentifier.get(x);
        return color;
    }
}
