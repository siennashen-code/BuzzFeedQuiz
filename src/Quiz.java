
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;

// To read in and manipulate profile.csv
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class Quiz {
        static Scanner sc = new Scanner(System.in);
        static ArrayList<Person> others = new ArrayList<Person>();
        static Person user;

        public static Personality independent = new Personality("independent",
                        "find peace in being alone",
                        "finds peace in being alone",
                        0);
        public static Personality creative = new Personality("creative",
                        "like to see things differently from others",
                        "likes to see things differently from others",
                        1);
        public static Personality charming = new Personality("charming",
                        "naturally draw people in",
                        "naturally draws people in",
                        2);
        public static Personality adventurous = new Personality("adventurous",
                        "seek thrill and memorable experiences",
                        "seeks thrill and memorable experiences",
                        3);

        public static String file = "lib/profile.csv";

        public static void main(String[] args) throws Exception {

                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                                String[] row = line.split(",");
                                Person person = new Person(row[0], row[1]);

                                person.usr_personality[0] = Integer.parseInt(row[2]);
                                person.usr_personality[1] = Integer.parseInt(row[3]);
                                person.usr_personality[2] = Integer.parseInt(row[4]);
                                person.usr_personality[3] = Integer.parseInt(row[5]);

                                person.usr_interests.add(row[6]);
                                person.usr_interests.add(row[7]);
                                person.usr_interests.add(row[8]);

                                others.add(person);
                                reader.close();
                        }
                } catch (IOException e){
                        e.printStackTrace();
                }

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
                q8.possibleAnswers[1] = new Answer("Home Alone 2");
                q8.possibleAnswers[2] = new Answer("The Grinch");
                q8.possibleAnswers[3] = new Answer("The Nightmare Before Christmas");

                // // Initialize the others ArrayList
                // int[] array = { 1, 0, 3, 1 };
                // ArrayList<String> list = new ArrayList<String>();
                // list.add("Mac and Cheese");
                // list.add("Mario Kart");
                // list.add("Home Alone 1");

                // Person Zoe = new Person("Zoe", "1234567890", array, list);

                // int[] array1 = { 1, 2, 1, 1 };
                // ArrayList<String> list1 = new ArrayList<String>();
                // list1.add("Mac and Cheese");
                // list1.add("Mario Kart");
                // list1.add("Home Alone 1");
                // Person Oliver = new Person("Oliver", "1234567890", array1, list1);

                // others.add(Zoe);
                // others.add(Oliver);

                // Game Intro
                game_intro();

                // Ask questions
                Question[] qList = { q1, q2, q3, q4, q5, q6, q7, q8 };
                for (Question q : qList) {
                        q.ask(sc);
                }

                // Get match
                Person match = get_match();
                print_summary(match);

                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.newLine();
                writer.write(user.condense_to_string());
                writer.close();

        }

        public static void game_intro() {
                System.out.println("-------* PLAN A WINTER VACATION AND FIND YOUR BEST FRIEND *-------");
                System.out.println(
                                "             Based on your results, we will pair you with a schoolmate who also took this quiz.");
                System.out.println("Ready to begin? Press '1' to start");
                start_button();

                // Get information to initialize user's profile
                System.out.println("Enter your name:");
                String name = get_name(sc);
                System.out.println("Enter your phone number (press 'x' to skip):");
                String phone_number = get_number(sc);

                user = new Person(name, phone_number);
        }

        public static void start_button() { // Forces user to input 1 to continue
                // requires 1 to keep going
                String play = sc.next();
                if (!play.equals("1")) {
                        System.out.println("** Unidentifiable input. Please enter '1' to play:");
                        start_button();
                }

        }

        public static String get_name(Scanner sc) { // Forces user to input their name (all letters or spaces) to
                                                    // continue
                String ans = sc.next();

                if (!(Checks.all_letters(ans))) {
                        System.out.println("** Unidentifiable input. Please enter your name in  letters only:");
                        ans = get_name(sc);
                }

                return ans;
        }

        public static String get_number(Scanner sc) { // Forces user to input a 10-digit phone number or skip to
                                                      // continue
                String ans = sc.next();

                if (ans.equals("x")) {
                        ans = "NA";
                } else if (!Checks.all_digits(ans)) {
                        System.out.println(
                                        "** Unidentifiable input. Please enter your 10-digit number in digits only (or 'x' to skip)");
                        ans = get_number(sc);
                } else if (ans.length() != 10) {
                        System.out.println(
                                        "** Unidentifiable input. Enter your number in exactly 10 digits (or 'x' to skip)");
                        ans = get_number(sc);
                }

                return ans;
        }

        public static Person get_match() {
                Person match = others.get(0);
                double lowest = user.distance(others.get(0));

                for (Person other : others) {// Find closest match
                        if (user.distance(other) < lowest) {
                                lowest = user.distance(other);
                                match = other;
                        }
                }

                return match;
        }

        public static void print_personality_summary(Person user, String subject, boolean description) {
                ArrayList<Personality> top_personalities = user.get_top_personalities();

                if (subject.equals("You")) {
                        System.out.print("You are");
                } else {
                        System.out.print(subject + " is");
                }
                for (int j = 0; j < top_personalities.size(); j++) { // Print out personality labels
                        System.out.print(" " + top_personalities.get(j).label);
                        if (j == top_personalities.size() - 1) {
                                System.out.print(".");
                        } else if (j == top_personalities.size() - 2) {
                                System.out.print(", and");
                        } else {
                                System.out.print(",");
                        }
                }

                if (description) {
                        System.out.print(" " + subject);
                        for (int i = 0; i < top_personalities.size(); i++) { // Print out desciptions of top
                                                                             // personalities
                                if (subject.equals("You")) {
                                        System.out.print(" " + user.get_top_personalities().get(i).description_2nd);
                                } else {
                                        System.out.print(" " + user.get_top_personalities().get(i).description_3rd);
                                }

                                if (i == top_personalities.size() - 2) {
                                        System.out.print(", and");
                                } else if (i == top_personalities.size() - 1) {
                                        System.out.print(".");
                                } else {
                                        System.out.print(",");
                                }
                        }
                }
        }

        public static void print_summary(Person other) {
                System.out.println("---YOUR RESULTS---");
                print_personality_summary(user, "You", true);
                System.out.println("\n");

                System.out.println("---YOUR MATCH: " + other.name + "---");
                System.out.println("Their phone number: " + other.phone_number);
                print_personality_summary(other, other.name, false);
                System.out.println("\n");

                System.out.println("---EXPLANATION---");
                ArrayList<Personality> common_personalities = user.get_common_personalities(other);
                ArrayList<String> common_interests = user.get_common_interests(other);

                if (common_personalities.size() == 0) { // Print out common personalities
                        System.out.println("Although your personalities are different, our algorithm thinks that "
                                        + other.name + " suits you than the other quiztakers!");
                } else {
                        System.out.print("We think you two suit each other because you share the traits of being");
                        for (int i = 0; i < common_personalities.size(); i++) {
                                System.out.print(" " + common_personalities.get(i).label);
                                if (i == common_personalities.size() - 1) {
                                        System.out.print(".");
                                } else if (i == common_personalities.size() - 2) {
                                        System.out.print(", and");
                                } else {
                                        System.out.print(",");
                                }
                        }
                }

                if (common_interests.size() == 2) { // Print out common interests
                        System.out.print(
                                        " And guess what?! You both like " + common_interests.get(0) + " and "
                                                        + common_interests.get(1) + ".");
                } else if (common_interests.size() == 3) {
                        System.out.print("You both like ");
                        for (int i = 0; i < common_interests.size(); i++) {
                                System.out.print(' ' + common_interests.get(i));

                                if (i == 0) {
                                        System.out.print(",");
                                } else if (i == 1) {
                                        System.out.print(" and,");
                                } else if (i == 2) {
                                        System.out.print("!");
                                }
                        }

                }

        }

}
