import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        System.out.println("/////*****/////*****/////*****/////*****/////*****/////");
        System.out.println("\t\t\t  Welcome to the Magical World of:");
        System.out.println("");
        System.out.println("\t\t\t\t\t     Magicalus");
        System.out.println("");
        System.out.println("\t\t A homemade Choose-your-own-Adventure Game");
        System.out.println("");
        System.out.println("/////*****/////*****/////*****/////*****/////*****/////");
        System.out.println("");
        System.out.println("Before we begin, you must build your character you will play as!");
        System.out.println("");

        Character player1 = new Character();

        String name = setName();
        String species = setSpecies();
        StatsController playerStats = setStats();
        playerStats.adjustSpeciesStats(species);
        int intelligence = playerStats.getIntelligence();
        int wisdom = playerStats.getWisdom();
        int charm = playerStats.getCharm();
        int strength = playerStats.getStrength();
        int perception = playerStats.getPerception();
        int luck = playerStats.getLuck();
        String charClass = setClass();

        player1.setName(name);
        player1.setSpecies(species);
        player1.setAllStats(intelligence, wisdom, charm, strength, perception, luck);
        player1.setCharacterClass(charClass);

        confirmAdventure(player1);
    }

    public static String setName() {
        System.out.println("First and foremost, enter a name for your Character: ");
        String charName = sc.nextLine();
        return charName;
    }

    public static String setSpecies() {
        int e = -1; //trivial variable to break out of while loop
        String answer = "";
        while(e < 0){ //while loop to keep asking question if user input is invalid
            System.out.println("");
            System.out.println("Next, select your Character's species. Keep in mind that some species " +
                    "have advantages over others, and this will reflect in your stats later.");
            System.out.println("A. Human");
            System.out.println("B. Elf");
            System.out.println("C. Dwarf");
            System.out.println("D. Nymph");
            answer = sc.nextLine();

            String[] acceptedAnswers = {"a", "human", "b", "elf", "c", "dwarf", "d", "nymph"};

            for (int i = 0; i < acceptedAnswers.length; i++) { //for loop to verify user input as acceptable answer
                if (answer.equalsIgnoreCase(acceptedAnswers[i])) {
                    e = 1; //break from while loop if answer is acceptable
                    break; //break out of for loop early if answer is acceptable
                }
            }

            if(e == -1) { //if answer is invalid, display error message before loop continues
                System.out.println("\nSorry, that is not a valid answer, please try again.");
            }
        }

        String species = "";
        if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("human")) { //human stats: +1 strength, +2 luck, +1 intell
            species = "Human";
        } else if(answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("elf")) { //elf stats: +1 strength, +2 wisdom, +3 charm
            species = "Elf";
        } else if(answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("dwarf")) { //dwarf stats: +3 strength, +1 intell, -1 wisdom
            species = "Dwarf";
        } else if(answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("nymph")) { //nymph stats: +1 wisdom, +2 charm, +3 perception
            species = "Nymph";
        }

        return species;
    }

    public static StatsController setStats() {
        int str = -1;
        int intel = -1;
        int wis = -1;
        int charm = -1;
        int per = -1;
        int luck = -1;

        int counter = 10; //display points left to spend to user as time goes on
        int e = -1; //break the while loop variable
        String answer = ""; //user confirmation variable

        while(e < 0) { //while loop to keep asking question if user input is invalid
            try { //try-catch bracket to catch non-numerical user input
                System.out.println("");
                System.out.println("Now we shall set your character's stats! There are six different stats in all:");
                System.out.println("Strength, Intelligence, Wisdom, Charm, Perception, and Luck");
                System.out.println("You have 10 points to spend between each category, you can spend as many as you want in each one," +
                        "but you cannot exceed 10 points or use negative numbers.");
                System.out.println("\nHow many points would you like for Strength? You have " + counter + " points left to spend.");
                str = sc.nextInt();
                counter = counter - str;

                System.out.println("\nHow many points would you like for Intelligence? You have " + counter + " points left to spend.");
                intel = sc.nextInt();
                counter = counter - intel;

                System.out.println("\nHow many points would you like for Wisdom? You have " + counter + " points left to spend.");
                wis = sc.nextInt();
                counter = counter - wis;

                System.out.println("\nHow many points would you like for Charm? You have " + counter + " points left to spend.");
                charm = sc.nextInt();
                counter = counter - charm;

                System.out.println("\nHow many points would you like for Perception? You have " + counter + " points left to spend.");
                per = sc.nextInt();
                counter = counter - per;

                System.out.println("\nLast but not least, how many points would you like for Luck? You have " + counter + " points left to spend.");
                luck = sc.nextInt();
                counter = counter - luck;
                sc.nextLine(); //Not necessary for functionality, combats bug that occurs when using nextInt() method.  https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo

                int total = str + intel + wis + charm + per + luck;
                if(total == 10) { //check for only spending 10 points
                    if (str > 0 && intel > 0 && wis > 0 && charm > 0 && per > 0 && luck > 0) { //none of the stats are negative
                        System.out.println("\nJust to confirm, these are the stats you want to play with? You cannot change them after this. (yes/no)");
                        System.out.println("Strength: " + str + "\nIntelligence: " + intel + "\nWisdom: " + wis + "\nCharm: " + charm + "\nPerception: "
                                + per + "\nLuck: " + luck);
                        counter = 10;
                        answer = sc.nextLine();

                        if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                            e = 1; //break from while loop if answer is acceptable and no numbers are negative and user accepts life choices.
                        }
                    }
                    else {
                        System.out.println("\nSorry, there was an error in tallying the stats you entered. Please reenter them," +
                                " and remember to only use positive numbers.");
                        counter = 10;
                    }
                }
                else if(total < 10) {
                    System.out.println("\nSorry, but you must spend all 10 points to proceed, you spent " + total + " points. Please try again.");
                    counter = 10;
                }
                else if(total > 10) {
                    System.out.println("\nSorry, but you must only spend 10 points, instead you spent " + total + " points. Please try again.");
                    counter = 10;
                }
            } catch(Exception ex) {
                System.out.println("\nSorry, your input is an invalid format, please try again.");
                counter = 10;
                sc.nextLine();
            }

        }

        StatsController stats = new StatsController(); //once loop has been escaped, the variables will save and be returned.
        stats.setStrength(str);
        stats.setIntelligence(intel);
        stats.setWisdom(wis);
        stats.setCharm(charm);
        stats.setPerception(per);
        stats.setLuck(luck);

        return stats;
    }

    public static String setClass() {
        int e = -1; //trivial variable to break out of while loop
        String answer = "";
        while(e < 0){ //while loop to keep asking question if user input is invalid
            System.out.println("");
            System.out.println("Congrats, you are almost done! Now you get to select your Character's" +
                    " class.\nThis will not only determine the main weapon of your choice, but also the story" +
                    "that will unfold for you.\nChoose wisely.");
            System.out.println("A. Hunter");
            answer = sc.nextLine();

            String[] acceptedAnswers = {"a", "hunter"}; //soon to come: warrior/fight, mage, priest

            for (int i = 0; i < acceptedAnswers.length; i++) { //for loop to verify user input as acceptable answer
                if (answer.equalsIgnoreCase(acceptedAnswers[i])) {
                    e = 1; //break from while loop if answer is acceptable
                    break; //break out of for loop early if answer is acceptable
                }
            }

            if(e == -1) { //if answer is invalid, display error message before loop continues
                System.out.println("\nSorry, that is not a valid answer, please try again.");
            }
        }

        String charClass = "";
        if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("hunter")) {
            charClass = "Hunter";
        }
        return charClass;
    }

    public static void confirmAdventure(Character player) { //relay all information back to user for final confirmation and then start the story!
        String answer = "";
        System.out.println("\nCongrats! You have finished making your character. But before we begin, please confirm one" +
                "\nmore time that all the information you entered is correct. This information cannot be changed once the story begins!\n");
        System.out.println("Name: " + player.getName());
        System.out.println("Species: " + player.getSpecies());
        System.out.println("Character Class: " + player.getCharacterClass());
        System.out.println("Strength: " + player.getStrength() + "\t\tIntelligence: " + player.getIntelligence());
        System.out.println("Wisdom: " + player.getWisdom() + "\t\tCharm: " + player.getCharm());
        System.out.println("Perception: " + player.getPerception() + "\tLuck: " + player.getLuck());
        answer = sc.nextLine();

        if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) { //commence story if user confirms life choices
            System.out.println("\nFantastic! And now, with your character created, you are now ready to set off on your adventure!\n");

            if (player.getCharacterClass().equalsIgnoreCase("hunter")) {
                Hunter hunterAdventure = new Hunter();
                hunterAdventure.story(player);
            } else if(player.getCharacterClass().equalsIgnoreCase("warrior")) {
                //TBC
            } else if(player.getCharacterClass().equalsIgnoreCase("mage")) {
                //TBC
            } else if(player.getCharacterClass().equalsIgnoreCase("cleric")) {
                //TBC
            }
        }
        else {
            System.out.println("\nChange your mind? No problem! We'll start over so you can change any information you'd like.");
            startGame();
        }
    }
}
