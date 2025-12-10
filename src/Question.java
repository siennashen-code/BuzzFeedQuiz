
/* Irene Feng 10/12/2022
A question class with Answers.
*/
import java.util.Scanner;

public class Question {
    // Fields
    String label;
    Answer[] possibleAnswers = new Answer[4];

    Question(String label) {
        this.label = label;
    }

    // ask a question, and return the category that corresponds to the answer
    void ask(Scanner sc, Person user) {
        System.out.println(this.label);
        
        // prints out all the answer choices
        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            System.out.println("[" + choice + "]:" +
                    this.possibleAnswers[i].label);
        }

        // stores the number that user inputs
        int ans = get_int(sc, user);
        Answer their_answer = possibleAnswers[ans - 1];

        // updates user profile based on answer
        if (their_answer.personality != null) {
            user.usr_personality[their_answer.personality.index]++;
        } else {
            user.usr_interests.add(their_answer.label);
        }
    }

    int get_int(Scanner sc, Person user){ //get user to input an acceptable integer
        int ans;

        if (!(sc.hasNextInt())) { //if user enters a non-integer
            System.out.println("Please enter an integer between 1 and 4.");
            sc.next();
            ans = get_int(sc, user);
        } else {
            ans = sc.nextInt();
        }
        
        if(ans<1||ans>4){ //if user's integer is out of bounds
            System.out.println("Please enter an integer between 1 and 4.");
            ans = get_int(sc, user);
        }

        return ans;
    }



}
