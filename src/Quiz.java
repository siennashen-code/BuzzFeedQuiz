
/*
 * Irene Feng Nov 2022
 * This is the class where we create the Quiz and run it. It has the main method.  
 */
import java.util.Scanner;

public class Quiz {
        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) throws Exception {
                // Create Personalities
                Personality independent = new Personality("independent", "You find peace in being alone", 0);
                Personality creative = new Personality("creative", "You like to see things differently from others", 1);
                Personality charming = new Personality("charming", "Other people are naturally drawn to you", 2);
                Personality adventurous = new Personality("adventurous", "You seek thrill and memorable experiences",
                                3);

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

                //Game Intro
                System.out.println("-------* PLAN A WINTER VACATION AND FIND YOUR BEST FRIEND *-------");
                System.out.println(
                                "    Based on your results, we will pair you with a schoolmate who also took this quiz.");
                System.out.println("Ready to begin? Press '1' to start");
                game_intro();
                
                // Get information to initialize user's profile
                System.out.println("Enter your name:");
                String name = get_name(sc);
                System.out.println("Enter your phone number (press 'x' to skip):");
                String phone_number = get_number(sc);

                Person user = new Person(name, phone_number);

                // Ask questions
                Question[] qList = { q1, q2, q3, q4, q5, q6, q7, q8 };
                for (Question q : qList) {
                        q.ask(sc, user);
                }

        }

        public static void game_intro() { // Forces user to input 1 to continue
                // requires 1 to keep going
                String play = sc.next();
                if (!play.equals("1")) {
                        System.out.println("** Unidentifiable input. Please enter '1' to play:");
                        game_intro();
                }

        }

        public static String get_name(Scanner sc) { // Forces user to input their name (all letters or spaces) to continue
                String ans = sc.next();

                if ( !(Checks.all_letters(ans)) ) {
                        System.out.println("** Unidentifiable input. Please enter your name in  letters only:");
                        ans = get_name(sc);
                }

                return ans;

        }

        public static String get_number(Scanner sc) { // Forces user to input a 10-digit phone number or skip to continue
                String ans = sc.next();

                if (ans.equals("x")) {
                        ans = "NA";
                } else if (!Checks.all_digits(ans)) {
                        System.out.println("** Unidentifiable input. Please enter your 10-digit number in digits only (or 'x' to skip)");
                        ans = get_number(sc);
                } else if (ans.length() != 10){
                        System.out.println("** Unidentifiable input. Enter your number in exactly 10 digits (or 'x' to skip)");
                        ans = get_number(sc);
                }

                return ans;
        }

}
