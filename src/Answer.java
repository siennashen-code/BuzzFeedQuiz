/*
 * Irene Feng 10/12/2022
 * This is an answer with a Category it corresponds to
 */

public class Answer {
    String label;
    Personality personality;

    // Constructors
    Answer(String label, Personality personality) { //For perosnality answers
        this.label = label; 
        this.personality = personality;
    }

    Answer(String label) { //For interest answers
        this.label = label; 
    }

}
