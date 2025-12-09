
/*
 * Irene Feng Nov 2022
 * This is the class where we create the Quiz and run it. It has the main method.  
 */
import java.util.Scanner;

public class Quiz {
        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) throws Exception {
                // Create Categories
                Personality monopoly = new Category("Monopoly",
                                "You are traditional, fancy, and you like to call the shots.");
                Personality catan = new Category("Catan", "You are very competitive "
                                + "but it's hidden underneath a friendly verneer. You're kinda popular but you deny it.");
                Personality ers = new Category("ERS (Egyptian Ratscrew)",
                                "You are a racket! You bring high energy and fun to any situation.");
                Personality hanabi = new Category("Hanabi", "You are a zen master. If given the choice, peace, no war.");

                Interest MandC = new Interest("Mac and Cheese", "Love mac and cheese");
                Interest Spaghetti = new Interest("Spaghetti", "Enjoy spaghetti");
                Interest CNN = new Interest("Chicken Noodle Soup");
                Interest Steak
                Interest Chess
                Interest Mario
                Interest Jenga
                Interest Jenga
                Interest HA1
                Interest HA2
                Interest Grinch
                Interest NBC

                
                // Create Questions
                Question q1 = new Question("Where are you at the pool party?");
                // Attach Answers to Questions
                q1.possibleAnswers[0] = new Answer("Outside playing catch at the pool.", ers);
                q1.possibleAnswers[1] = new Answer("I'm the host of course, and entertaining my guests with stories.",
                                monopoly);
                q1.possibleAnswers[2] = new Answer("Having everyone eat the pie I made", catan);
                q1.possibleAnswers[3] = new Answer("Eating pie and listening to a long story", hanabi);

                Question q2 = new Question("You're in a rock band. What instrument do you play?");
                q2.possibleAnswers[0] = new Answer("I'm the guitarist weeeo!", ers);
                q2.possibleAnswers[1] = new Answer("I'm the drummer, without me, the band's nothing", monopoly);
                q2.possibleAnswers[2] = new Answer("I'm the lead singer!", catan);
                q2.possibleAnswers[3] = new Answer("I'm the manager, taking care of my players behind the scenes.",
                                hanabi);

                // ... more questions here

                // For each question, ask, read input, store answer.
                gameIntro();
                Question[] qList = { q1, q2 };
                for (Question q : qList) {
                        Category c = q.ask(sc);
                        c.points++;
                }
                // Get most common category from the questions asked
                // Return Category
                Category[] cList = { monopoly, catan, ers, hanabi };
                // these need to be in the same order or the points will be incorrect!
                int index = getMostPopularCatIndex(cList);
                System.out.println("If you were a board game, you would be " + cList[index].label + ". ");
                System.out.println(cList[index].description);

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
        public static int getMostPopularCatIndex(Category[] counts) {
                int maxCount = 0;
                int maxIndex = 0;
                for (int i = 0; i < counts.length; i++) {
                        if (counts[i].points > maxCount) {
                                maxCount = counts[i].points;
                                maxIndex = i;
                        }
                }
                return maxIndex;
        }
}
