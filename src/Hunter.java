import java.util.Scanner;

/**
 * This class executes the story for the hunter class
 *
 * Plot: hunter wakes up in small forest village with his/her fellow hunters and begins a regular day of training
 * young hunters. Afterwards, an elder approaches with news of a nearby town requesting assistance of the village,
 * and the player is the natural pick based on their skills. Meet an emissary of the town who tells the tale of a
 * horrid beast that has been thinning flocks of sheep and cattle, even a stray dog or two. You must track it and
 * kill it without getting killed yourself.
 */
public class Hunter {

    public Character hero;
    public static Scanner sc = new Scanner(System.in);
    public String answer = "";
    int e = -1; //trivial variable to break out of while loop

    public Hunter() {}

    public void story(Character player) {
        this.hero = player;

        System.out.println("/////*****/////*****/////*****/////*****/////*****/////\n");
        System.out.println("Great choice! You decided to make your character a hunter! As a hunter, you not only " +
                "\nhave a bow and quiver full of arrows at your disposal, but you also have your trusty hunting knife and" +
                "\nthe company of your faithful familiar: Ferang the wolf.\n");

        System.out.println("And now, without further ado, let us begin!\n");
        System.out.println("/////*****/////*****/////*****/////*****/////*****/////\n");

        System.out.println("You wake to the sound of chirping birds and rays of sunshine\n" +
                "pouring through your bedroom window. As you start to sit up and\n" +
                "rub the sleep from your eyes, Ferang greets you with a whine\n" +
                "and a small tail wag from his hide bed in the corner of the room.\n");

        System.out.println("\"Good morning Ferang, sleep well boy?\" you say as you stretch\n" +
                "your arms out, releasing the tension from your shoulder joints. Ferang\n" +
                "wags his tail a little harder in response. Finally you get out\n" +
                "of bed and walk to your wardrobe, you throw on your hunter garb:\n" +
                "a set of dark, cotton trousers and a cotton undershirt with a fur\n" +
                "coat (Simple, yet light and quiet).\n");

        System.out.println("Press Enter to Continue..."); //wait for user input to continue story
        try {System.in.read();}
        catch (Exception e) {e.printStackTrace();}

        System.out.println("As you grab your satchel, Ferang gets up, stretches briefly, and \n" +
                "walks out of the bedroom into the den to wait patiently for breakfast\n" +
                "as he does every morning. You smile and follow suit, walking into the\n" +
                "rest of the cottage. It is a small cottage, but nonetheless brightly lit \n" +
                "with the warmth of the morning sun coming in through the windows. There's\n" +
                "a fireplace with a couch and table in front of it on one side of the room,\n" +
                "and a set of cupboards, a firewood stove, and small dining table on the other.\n" +
                "Close to the back wall of the cottage, near the kitchen, is a floor hatch to\n" +
                "access the food cellar. There are small personal trinkets scattered\n" +
                "around the room, sitting on shelves, hanging on walls, and the like.\n");

        System.out.println("You see Ferang sitting patiently by his food bowl next to the kitchen\n" +
                "counter. You walk over and open the cellar door, descending down\n" +
                "the wooden steps to the dark, cool cellar. With the light of the sun\n" +
                "behind you, you scan the shelves and retrieve a jar of venison broth from\n" +
                "yesterday evening's dinner. You return to the kitchen, twist open the jar,\n" +
                "and pour the broth into Ferang's bowl.\n");

        while(e < 0) { //while loop to keep asking question if user input is invalid
            System.out.println("As Ferang starts devouring his light meal, you ponder getting yourself some\n" +
                    "food too... you decide to:\n");

            System.out.println("A) Make breakfast");
            System.out.println("B) Skip breakfast");
            answer = sc.nextLine();

            String[] acceptedAnswers1 = {"a", "b"};

            e = verifyAnswer(acceptedAnswers1, answer);

            if(e == -1) { //if answer is invalid, display error message before loop continues
                System.out.println("\nSorry, that is not a valid answer, please try again.\n");
            }
        }

        if (answer.equalsIgnoreCase("a")) {
            System.out.println("\nYou decide to start the day with a nice meal of bread, cheese, \n" +
                    "and some smoked salmon from the cellar. You eat together with your companion,\n" +
                    "and you both feel energized and ready to start the day!\n" +
                    "You gain +1 Perception!\n");
            hero.setPerception(hero.perception + 1);
            e = -1; //reset loop variable for next user prompt

        } else if (answer.equalsIgnoreCase("b")) {
            System.out.println("\nYou decide to skip the most important meal of the day and instead\n" +
                    "spend your time lounging on the couch, you lazy bum.\n");
            e = -1; //reset loop variable for next user prompt
        }

        System.out.println("Once Ferang finishes eating, you take his bowl and take it outside, using\n" +
                "the loose dirt to scrape out the remnants and clean it. The sun has\n" +
                "climbed a bit higher in the sky, heralding another new day in Drustvar,\n" +
                "your village.\n");

        System.out.println("Drustvar is a village of hunters that have chosen to live in harmony with the\n" +
                "forest ecosystem that surrounds it. While the hunters of Drustvar find their\n" +
                "livelihoods in the forest itself, they are also its devoted protectors. For\n" +
                "centuries, the hunters of Drustvar have worked to maintain the delicate balance\n" +
                "of the forest ecosystem by keeping the populations of both predators and prey\n" +
                "in check; ensuring that neither beast or innocent doe would disrupt the balance\n" +
                "and bring chaos to the forest.\n");

        System.out.println("Press Enter to Continue..."); //wait for user input to continue story
        try {System.in.read();}
        catch (Exception e) {e.printStackTrace();}

        while(e < 0) { //while loop to keep asking question if user input is invalid
            System.out.println("As you listen to the birds sing in the trees around you, you realize you have\n" +
                    "some time to spare before it is time to go visit _____, the village chief, for \n" +
                    "the morning report. You decide to use this spare time to:\n");

            System.out.println("A) Practice your archery skills");
            System.out.println("B) Spend time with Ferang");
            System.out.println("C) Maintain your hunting equipment");
            System.out.println("D) Go for a stroll around Drustvar");
            answer = sc.nextLine();

            String[] acceptedAnswers2 = {"a", "b", "c", "d"};

            e = verifyAnswer(acceptedAnswers2, answer);

            if (e == -1) { //if answer is invalid, display error message before loop continues
                System.out.println("\nSorry, that is not a valid answer, please try again.\n");
            }
        }

        if (answer.equalsIgnoreCase("a")) {
            System.out.println("You wander back inside, placing Ferang's food dish back");
            e = -1; //reset loop variable for next user prompt

        } else if (answer.equalsIgnoreCase("b")) {
            System.out.println("");
            e = -1; //reset loop variable for next user prompt
        }
        else if (answer.equalsIgnoreCase("c")) {
            System.out.println("");
            e = -1; //reset loop variable for next user prompt
        }
        else if (answer.equalsIgnoreCase("d")) {
            System.out.println("");
            e = -1; //reset loop variable for next user prompt
        }

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    public void interactWithCompanion() {} //have randon quirks from companion during story?

    public void maze() {} //forest maze to hunt the beast

    public void finalFight() {} //final beast fight, once started there is NO ESCAPE (mwahahaha). Seriously, either win and end the story or die.

    public void death(String cause) {} //print game-over based on cause of death (there are several kinds including dying during training)

    public int verifyAnswer(String[] acceptedAnswers, String userAnswer) {
        int x = -1; //trivial variable to break out of while loop

        for (int i = 0; i < acceptedAnswers.length; i++) { //for loop to verify user input as acceptable answer
            if (userAnswer.equalsIgnoreCase(acceptedAnswers[i])) {
                x = 1; //break from while loop if answer is acceptable
                break; //break out of for loop early if answer is acceptable
            }
        }

        return x;
    }
    //NOTE: maybe have seperate death class for death-related text and potential death calculations?
    //NOTE: maybe have seperate class for fight encounters? Methods for number of enemies?
    //NOTE: Implement a karma system? Ex: shoot animal instead of target than have worse karma for fight encounters?
    //NOTE: Companions have seperate stats?
}
