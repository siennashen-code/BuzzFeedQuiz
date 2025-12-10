
/*
 * Irene Feng Nov 2022
 * This is the class where we create the Quiz and run it. It has the main method.  
 */
import java.util.Scanner;

public class Quiz {
        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) throws Exception {
                //Declare Person object
                Person user;
                
                //Create Personalities
                Personality independent = new Personality("independent", "You find peace in being alone", 0);
                Personality creative = new Personality("creative", "You like to see things differently from others", 1);
                Personality charming = new Personality("charming", "Other people are naturally drawn to you", 2);
                Personality adventurous = new Personality("adventurous", "You seek thrill and memorable experiences", 3);
                
                // Create Questions
                Question q1 = new Question("1. Where will you be going?");
                q1.possibleAnswers[0] = new Answer("I'm staying home", independent);
                q1.possibleAnswers[1] = new Answer("to Europe", creative);
                q1.possibleAnswers[2] = new Answer("to somewhere warm in the Southern Hemisphere", charming);
                q1.possibleAnswers[3] = new Answer("to Antarctica", adventurous);

                Question q2 = new Question("2. What song will you be listening to?");
                q2.possibleAnswers[0] = new Answer("All I Want for Christmas is You", charming);
                q2.possibleAnswers[1] = new Answer("Rockin' Around the Christmas Tree", creative);
                q2.possibleAnswers[2] = new Answer("White Christmas", independent);
                q2.possibleAnswers[3] = new Answer("Jingle Bell Rock", adventurous);

                Question q3 = new Question("3. What will you be doing during the day?");
                q3.possibleAnswers[0] = new Answer("Skiing", independent);
                q3.possibleAnswers[1] = new Answer("Snowboarding", adventurous);
                q3.possibleAnswers[2] = new Answer("Watching movies", creative);
                q3.possibleAnswers[3] = new Answer("Baking", charming);

                Question q4 = new Question("4. What pet will accompany you on your vacation?");
                q4.possibleAnswers[0] = new Answer("A siberian husky", adventurous);
                q4.possibleAnswers[1] = new Answer("A reindeer", creative);
                q4.possibleAnswers[2] = new Answer("A goldfish", independent);
                q4.possibleAnswers[3] = new Answer("A shorthair cat", charming);

                Question q5 = new Question("5. Who will you eat dinner with");
                q5.possibleAnswers[0] = new Answer("My favorite actor", charming);
                q5.possibleAnswers[1] = new Answer("My favorite artist", creative);
                q5.possibleAnswers[2] = new Answer("My favorite athlete", adventurous);
                q5.possibleAnswers[3] = new Answer("My favorite author", independent);

                Question q6 = new Question("6. What will you be eating?");
                q6.possibleAnswers[0] = new Answer("Mac and Cheese");
                q6.possibleAnswers[1] = new Answer("Spaghetti");
                q6.possibleAnswers[2] = new Answer("Chicken noodle soup");
                q6.possibleAnswers[3] = new Answer("Steak");

                Question q7 = new Question("7. What game will you play with your dinner-mate after?");
                q7.possibleAnswers[0] = new Answer("Chess");
                q7.possibleAnswers[1] = new Answer("Mario Kart");
                q7.possibleAnswers[2] = new Answer("Jenga");
                q7.possibleAnswers[3] = new Answer("Roblox");

                Question q8 = new Question("8. What movie will you watch at night?");
                q8.possibleAnswers[0] = new Answer("Home Alone 1");
                q8.possibleAnswers[1] = new Answer("Home ALone 2");
                q8.possibleAnswers[2] = new Answer("The Grinch");
                q8.possibleAnswers[3] = new Answer("The Nightmare Before Christmas");

                // For each question, ask, read input, store answer.
                gameIntro();
                
                Question[] qList = { q1, q2, q3, q4, q5, q6, q7, q8};
                for (Question q : qList) {
                        q.ask(sc);
                }

                // Get most common category from the questions asked
                // Return Category
                // Category[] cList = { monopoly, catan, ers, hanabi };
                // // these need to be in the same order or the points will be incorrect!
                // int index = getMostPopularCatIndex(cList);
                // System.out.println("If you were a board game, you would be " + cList[index].label + ". ");
                // System.out.println(cList[index].description);

        }

        public static void gameIntro() {
                // requires 1 to keep going
                System.out.println("Which Board Game Are You?");
                System.out.println("You get to choose numbers 1-4 for every question. Enter '1' to play!");
                int play = sc.nextInt();
                if (play != 1) {
                        System.out.println("Unidentifiable input. Please enter '1' to play");
                        gameIntro();
                }
        }

        // returns the index that is the max
        // the tie breaker is the first Category that has the count is the "max" :/ 
        // public static int getMostPopularCatIndex(Category[] counts) {
        //         int maxCount = 0;
        //         int maxIndex = 0;
        //         for (int i = 0; i < counts.length; i++) {
        //                 if (counts[i].points > maxCount) {
        //                         maxCount = counts[i].points;
        //                         maxIndex = i;
        //                 }
        //         }
        //         return maxIndex;
        // }
}
