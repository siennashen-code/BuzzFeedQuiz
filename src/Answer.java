/*
 * Irene Feng 10/12/2022
 * This is an answer with a Category it corresponds to
 */

public class Answer {
    String label;
    Personality personality;
    String interest;

    // Constructors
    Answer(String label, Personality personality) {
        this.label = label; 
        this.personality = personality;
    }

    Answer(String label, String interest) {
        this.label = label; 
        this.interest = interest;
    }

}
