package main;

import java.util.*;

import jobs.*;
import main.Character.*;
import races.*;
import main.*;

public class CharacterCreator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Sex chosenSex = assignCharacterSex(scan);
        Job chosenJob = getJob(scan);
        Clan chosenClan = getClan(scan);
        Race chosenRace = getRace(scan);
        if (chosenRace.raceOptions() != null) {
            ArrayList<PlayerChoices> extraMenus = chosenRace.raceOptions();
            for (PlayerChoices menu : extraMenus) {
                System.out.println(menu.getQuestion());
                System.out.println(menu.getEquipmentOptions());
                String input = scan.nextLine();

                if (menu.getEquipmentOptions().contains(input)) {
                    chosenRace.chosenVariables(input);
                } else {
                    System.out.println("Invalid Choice. Please try again.");
                }
            }
            HashMap<String, Integer> finalStats = getStats(scan);

            ArrayList<PlayerChoices> jobSelection = chosenJob.addJobOptions();
            for (PlayerChoices choices : jobSelection) {
                System.out.println("\n" + choices.getQuestion());

                List<String> options = choices.getEquipmentOptions();
                for (int i = 0; i < options.size(); i++) {
                    System.out.println((i + 1) + ". " + options.get(i));
                }

                int validNumber = 0;
                boolean isValid = false;

                while (!isValid) {
                    System.out.print("Please enter a valid choice: ");
                    String choice = scan.nextLine();

                    try {
                        validNumber = Integer.parseInt(choice);
                        if (validNumber >= 1 && validNumber <= options.size()) {
                            isValid = true;
                        } else {
                            System.out.println("Invalid choice. Please type a number between 1 and " + (options.size() + "."));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please type a number.");
                    }
                }
                String selection = options.get(validNumber - 1);

                chosenJob.addEquipment(selection);
                System.out.println(selection + " was added to your starting bag");
            }
        }
    }


    private static Sex assignCharacterSex(Scanner scan) {
        Sex chosenSex = null;
        boolean validSex = false;

        while (!validSex) {
            System.out.println("Pick the sex of your character. 1 for Male, 2 for Female");
            String input = scan.nextLine();
            if (input.equals("1")) {
                chosenSex = Sex.MALE;
                validSex = true;
            } else if (input.equals("2")) {
                chosenSex = Sex.FEMALE;
                validSex = true;
            } else {
                System.out.println("Invalid option. Please pick between Male and Female.");
            }
        }
        return chosenSex;
    }

    private static HashMap<String, Integer> getStats(Scanner scan) {
        HashMap<String, Integer> stats = new HashMap<>();
        ArrayList<Integer> dice = new ArrayList<>();

        System.out.println("Now, let's roll for your stats. Four dice will be rolled, and the lowest will be dropped");
        for (int i = 0; i < 6; i++) {
            dice.add(DiceRoller.statRoll());
        }

        String[] statNames = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};

        for (String currentStat : statNames) {
            int lastChoice = dice.getFirst();
            boolean validChoice = false;
            if (dice.size() == 1) {
                System.out.println("Assigning last stat " + dice.getFirst() + " to " + currentStat);
                stats.put(currentStat, lastChoice);
                dice.remove(dice.getFirst());
                continue;
            }
            int choice;
            DiceRoller.insertionSort(dice);
            System.out.println("\nAvailable stats: " + dice);
            System.out.println("Which score do you want to assign to " + currentStat + "?");
            while (!validChoice) {
                String input = scan.nextLine();

                try {
                    choice = Integer.parseInt(input);
                    if (dice.contains(choice)) {
                        stats.put(currentStat, choice);
                        validChoice = true;
                        dice.remove(Integer.valueOf(choice));
                        System.out.println(choice + " assigned to " + currentStat);
                    } else {
                        System.out.print("Please pick a number that was rolled from the following: " + dice);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number from " + dice + ".");
                }
            }
        }
        return stats;
    }

    private static Race getRace(Scanner scan) {
        Race chosenRace = null;
        boolean validRace = false;

        while (!validRace) {
            System.out.println("Hello! Welcome to the Dungeons and Dragons x Final Fantasy XIV Character Creator! To get started, first pick your race from the list below:");
            System.out.println("1. Au Ra");
            System.out.println("2. Elezen");
            System.out.println("3. Garlean");
            System.out.println("4. Hrothgar");
            System.out.println("5. Hyur");
            System.out.println("6. Lalafell");
            System.out.println("7. Miqo'te");
            System.out.println("8. Roegadyn");
            System.out.println("9. Viera");
            String input = scan.nextLine();

            switch (input) {
                case "1":
                    chosenRace = new AuRa();
                    validRace = true;
                    break;
                case "2":
                    chosenRace = new Elezen();
                    validRace = true;
                    break;
                case "3":
                    chosenRace = new Garlean();
                    validRace = true;
                    break;
                case "4":
                    chosenRace = new Hrothgar();
                    validRace = true;
                    break;
                case "5":
                    chosenRace = new Hyur();
                    validRace = true;
                    break;
                case "6":
                    chosenRace = new Lalafell();
                    validRace = true;
                    break;
                case "7":
                    chosenRace = new Miqote();
                    validRace = true;
                    break;
                case "8":
                    chosenRace = new Roegadyn();
                    validRace = true;
                    break;
                case "9":
                    chosenRace = new Viera();
                    validRace = true;
                    break;
                default:
                    System.out.println("Invalid input. Please pick again.");
                    break;
            }
        }
        return chosenRace;
    }
}

private static Job getJob(Scanner scan) {
    Job myJob = null;
    boolean validJob = false;
    while (!validJob) {
        System.out.println("Select a job from the list below:\n(1) Astrologian\n(2) Bard\n(3) Black Mage\n(4) Dancer\n(5) Dark Knight\n(6) Dragoon\n(7) Gunbreaker\n(8) Machinist\n(9) Monk\n(10) Ninja\n(11) Paladin\n(12) Pictomancer\n(13) Reaper\n(14) Red Mage\n(15) Sage\n(16) Samurai\n(17) Scholar\n(18) Summoner\n(19) Viper\n(20) Warrior\n(21) White Mage");
        String input = scan.nextLine();
        switch (input) {
            case "1":
                myJob = new Astrologian();
                validJob = true;
                break;
            case "2":
                myJob = new Bard();
                validJob = true;
                break;
            case "3":
                myJob = new BlackMage();
                validJob = true;
                break;
            case "4":
                myJob = new Dancer();
                validJob = true;
                break;
            case "5":
                myJob = new DarkKnight();
                validJob = true;
                break;
            case "6":
                myJob = new Dragoon();
                validJob = true;
                break;
            case "7":
                myJob = new Gunbreaker();
                validJob = true;
                break;
            case "8":
                myJob = new Machinist();
                validJob = true;
                break;
            case "9":
                myJob = new Monk();
                validJob = true;
                break;
            case "10":
                myJob = new Ninja();
                validJob = true;
                break;
            case "11":
                myJob = new Paladin();
                validJob = true;
                break;
            case "12":
                myJob = new Pictomancer();
                validJob = true;
                break;
            case "13":
                myJob = new Reaper();
                validJob = true;
                break;
            case "14":
                myJob = new RedMage();
                validJob = true;
                break;
            case "15":
                myJob = new Sage();
                validJob = true;
                break;
            case "16":
                myJob = new Samurai();
                validJob = true;
                break;
            case "17":
                myJob = new Scholar();
                validJob = true;
                break;
            case "18":
                myJob = new Summoner();
                validJob = true;
                break;
            case "19":
                myJob = new Viper();
                validJob = true;
                break;
            case "20":
                myJob = new Warrior();
                validJob = true;
                break;
            case "21":
                myJob = new WhiteMage();
                validJob = true;
                break;
            default:
                System.out.println("Invalid selection. Please enter a number between 1 and 21");
                break;
        }
    }

    return myJob;
}

private AuRa auRaCreator(Scanner scanner) {
    boolean validChoice = false;
    System.out.println("""
            The Au Ra hail from the east, and are marked by their scales and horns.
            These people have a stark difference in height between the the males and females of the species. The males tend to be much taller than the females and many other races, while the females on average are shorter than many of the other races.
            The dark scaled Xaela are nomads who travel the Azim Steppe and have developed a wide variety of customs which change from tribe to tribe.
            The light scaled Raen live largely integrated into modern society, giving up their nomadic ways for peaceful coexistence with the other races.
            As an Au Ra, your Wisdom ability score will increase by 2. Base walking speed is 30ft.
            If you select the Xaela clan, your Strength will increase by 2. If you select the Raen, your Charisma will increase by 1.
            """);
    while (!validChoice) {
        System.out.println("Please pick which clan you wish to start as: (1) Xaela\n(2) Raen");
        String selectClan = scanner.nextLine().trim();
        String selectedClan = "";
        if (selectClan.equals("1") || selectClan.equalsIgnoreCase("Xaela")) {
            selectedClan = "Xaela";
        } else if (selectClan.equals("2") || selectClan.equalsIgnoreCase("Raen")) {
            selectedClan = "Raen";
        } else {
            System.out.println("Invalid input. Type 1, 2, or the name of the clan you wish to be");
            continue;
        }
        System.out.println("You have selected to make a " + selectedClan + " Au Ra.");
        System.out.println("Please confirm your choice. Press 1 to confirm, 2 to go back to clan selection, and 3 to return to the race selection");
        try {
            String clanConfirmation = scanner.nextLine();
            switch (clanConfirmation) {
                case "1" -> {
                    AuRa character = new AuRa();
                    character.pickClan(selectedClan);
                    return character;
                }
                case "2" -> System.out.println("Let's try again. Returning to race selection.");
                case "3" -> {
                    System.out.println("Returning to race selection...");
                    return null;
                }
                default -> System.out.println("Invalid input. Type 1, 2, or 3");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again");
        }
        scanner.close();
        validChoice = true;
    }

    return new AuRa();
}

private Elezen elezenCreator(Scanner scanner) {
    boolean validChoice = false;
    System.out.println("""
            The Elezen are elves who hail from Eorzea who call the lands of Gridania and Ishgard their home.
            Taller than regular elves, they have naturally good eyesight and are well intuned with the land.
            Over time they split into two groups, the Wildwood whom are light skinned and dextrous, skilled with a bow and live in either dense forests or their highly religious city-state homeland.
            Their relatives the Duskwights live in a series of twisting tunnels and ruins underground, coming up only to hunt for food or pillage before returning to their cavernous homes.
            As an Elezen, your Intelligence score increases by 2. Base walking speed is 30ft.
            If you select the Wildwood, your Dexterity increases by 1. Selecting Duskwight increases your Constitution by 1. Ishgardian increases Strength by 1.
            """);
    while (!validChoice) {
        System.out.println("Please pick which clan you wish to start as: (1) Wildwood\n(2) Duskwight\n(3) Ishgardian");
        String selectClan = scanner.nextLine().trim();
        String selectedClan = "";
        if (selectClan.equals("1") || selectClan.equalsIgnoreCase("Wildwood")) {
            selectedClan = "Wildwood";
        } else if (selectClan.equals("2") || selectClan.equalsIgnoreCase("Duskwight")) {
            selectedClan = "Duskwight";
        } else if (selectClan.equals("3") || selectClan.equalsIgnoreCase("Ishgardian")) {
            selectedClan = "Ishgardian";
        } else {
            System.out.println("Invalid input. Type 1, 2, 3, or the name of the clan you wish to be");
            continue;
        }
        System.out.println("You have selected to make a " + selectedClan + " Elezen.");
        System.out.println("Please confirm your choice. Press 1 to confirm, 2 to go back to clan selection, and 3 to return to the race selection");
        try {
            String clanConfirmation = scanner.nextLine();
            switch (clanConfirmation) {
                case "1" -> {
                    Elezen character = new Elezen();
                    character.pickClan(selectedClan);
                    return character;
                }
                case "2" -> System.out.println("Let's try again. Returning to clan selection.");
                case "3" -> {
                    System.out.println("Returning to race selection...");
                    return null;
                }
                default -> System.out.println("Invalid input. Type 1, 2, or 3");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again");
        }
        validChoice = true;
    }
    return new Elezen();
}

private Garlean garleanCreator(Scanner scanner) {
    boolean validChoice = false;
    System.out.println("""
            The Garleans are physically strong and highly intelligent people who call the land of Ilsabard their home.
            They are marked by their third eye, a gem like growth in the center of their forehead.
            Unfortunately for them, the Garleans as a whole have great difficulty channeling aether through their bodies, which despite their physicality and intelligence, found themselves bowing to many other magic wielding races.
            They were eventually able to develop technology to make up for this lack of magical aptitude and turned the tables, establishing the Garlean Empire in Ilsabard, a dominate force which sought to invade the land of Eorzea.
            """);
    return new Garlean();
}

private Hrothgar hrothgarCreator(Scanner scanner) {
    boolean validChoice = false;
    System.out.println("""
            The Hrothgar are powerful, feline people from the Northeast who had struggles when meeting the other races of the world as they were unable to speak the common tongue.
            They call Ilsabard their homeland and they walk two distinct paths, one of servitude and the other of freedom.
            These distinct paths and ways of life led to the Helions, warm coloured Hrothgar who serve in the name of their Queen, and The Lost, cool coloured Hrothgar who value freedom above all else.
            """);
    while (!validChoice) {
        System.out.println("Please pick which clan you wish to be: (1) Helion or (2) The Lost");
        String selectClan = scanner.nextLine();
        String selectedClan = "";

        if (selectClan.equals("1") || selectClan.equalsIgnoreCase("Helion")) {
            selectedClan = "Helion";
        } else if (selectClan.equals("2") || selectClan.equalsIgnoreCase("The Lost")) {
            selectedClan = "The Lost";
        }  else {
            System.out.println("Invalid input. Type 1, 2, or the name of the clan you wish to be");
            continue;
        }
        System.out.println("You have selected to make a " + selectedClan + " Hrothgar.");
        System.out.println("Please confirm your choice. Press 1 to confirm, 2 to go back to clan selection, and 3 to return to the race selection");
        try {
            String clanConfirmation = scanner.nextLine();
            switch (clanConfirmation) {
                case "1" -> {
                    Hrothgar character = new Hrothgar();
                    character.pickClan(selectedClan);
                    return character;
                }
                    case "2" -> System.out.println("Let's try again. Returning to clan selection.");
                    case "3" -> {
                        System.out.println("Returning to race selection...");
                        return null;
                    }
                default -> System.out.println("Invalid input. Type 1, 2, or 3");
                }
            } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again");
        }
        validChoice = true;
    }
    return new Hrothgar();
}


public String getName(Scanner scanner, Race race, Sex sex, HashMap<String, Integer> stats) {
    Random rand = new Random();
    String firstName;
    String lastName;
    while (true) {
        System.out.println("Time to make pick a name. You can create one yourself or one can randomly be assigned to you based on your character's race, clan, and sex. Press 1 for custom, press 2 for random");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            while (true) {
                System.out.println("Please enter your first name: ");
                firstName = scanner.next().toUpperCase();
                System.out.println("Please enter your last name: ");
                lastName = scanner.next().toUpperCase();
                if (firstName.length() <= 15 && lastName.length() <= 15 && (firstName.length() + lastName.length()) <= 20) {
                    return firstName + " " + lastName;
                } else {
                    System.out.println("Invalid input. Please try again");
                    scanner.nextLine();
                }
            }

        } else if (input.equals("2")) {
            while (true) {
                String generatedName = race.randomNameGenerator(sex, stats);
                System.out.println(generatedName + " was the name generated. Would you like to keep it? Y for yes, N for no");
                if (scanner.nextLine().equalsIgnoreCase("Y")) {
                    return generatedName;
                } else {
                    System.out.println("Rerolling name");
                }
            }

        } else {
            System.out.println("Invalid option. Please pick either 1 or 2");
            scanner.nextLine();
        }
    }
}

