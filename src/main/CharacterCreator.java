package main;

import java.util.*;

import jobs.*;
import main.Character.*;
import races.*;

public class CharacterCreator {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Race chosenRace = getRace(scan);
        Job chosenJob = null;
        String characterName = null;
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
        }
        Sex chosenSex = assignCharacterSex(scan);
        HashMap<String, Integer> finalStats = getStats(scan);
        chosenJob = getJob(scan);
        chosenJob.applyJob();
        characterName = getName(scan, chosenRace, chosenSex, finalStats);

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
        if (chosenRace instanceof Garlean) {
            ((Garlean) chosenRace).getGarleanTitle();


        }
        System.out.println("Congrats, your " + chosenRace.getName() + " " + chosenJob.getJobName() + " named " + characterName + " has been created!");
        chosenJob.printInventory();

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
                    chosenRace = auRaCreator(scan);
                    if (chosenRace != null) {
                        validRace = true;
                    }
                    break;
                case "2":
                    chosenRace = elezenCreator(scan);
                    if (chosenRace != null) {
                        validRace = true;
                    }
                    break;
                case "3":
                    chosenRace = garleanCreator(scan);
                    if (chosenRace != null) {
                        validRace = true;
                    }
                    break;
                case "4":
                    chosenRace = hrothgarCreator(scan);
                    if (chosenRace != null) {
                        validRace = true;
                    }
                    break;
                case "5":
                    chosenRace = hyurCreator(scan);
                    if (chosenRace != null) {
                        validRace = true;
                    }
                    break;
                case "6":
                    chosenRace = lalafellCreator(scan);
                    if (chosenRace != null) {
                        validRace = true;
                    }
                    break;
                case "7":
                    chosenRace = miqoteCreator(scan);
                    if (chosenRace != null) {
                        validRace = true;
                    }
                    break;
                case "8":
                    chosenRace = roegadynCreator(scan);
                    if (chosenRace != null) {
                        validRace = true;
                    }
                    break;
                case "9":
                    chosenRace = vieraCreator(scan);
                    if (chosenRace != null) {
                        validRace = true;
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please pick again.");
                    break;
            }
        }
        return chosenRace;
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

    private static AuRa auRaCreator(Scanner scanner) {
        System.out.println("""
                The Au Ra hail from the east, and are marked by their scales and horns.
                These people have a stark difference in height between the the males and females of the species. The males tend to be much taller than the females and many other races, while the females on average are shorter than many of the other races.
                The dark scaled Xaela are nomads who travel the Azim Steppe and have developed a wide variety of customs which change from tribe to tribe.
                The light scaled Raen live largely integrated into modern society, giving up their nomadic ways for peaceful coexistence with the other races.
                As an Au Ra, your Wisdom ability score will increase by 2. Base walking speed is 30ft.
                If you select the Xaela clan, your Strength will increase by 2, you gain proficiency in survival skills, and when scoring critical hits with a melee weapon, you can roll one of the weapon's damage dice one additional time and add it to the extra damage of the critical hit.
                If you select the Raen, your Charisma will increase by 1, you gain proficiency in Persuasion, and have advantage on saving throws against being charmed.
                """);
        while (true) {
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
        }
    }

    private static Elezen elezenCreator(Scanner scanner) {
        System.out.println("""
                The Elezen are elves who hail from Eorzea who call the lands of Gridania and Ishgard their home.
                Taller than regular elves, they have naturally good eyesight and are well intuned with the land.
                Over time they split into two groups, the Wildwood whom are light skinned and dextrous, skilled with a bow and live in either dense forests or their highly religious city-state homeland.
                Their relatives the Duskwights live in a series of twisting tunnels and ruins underground, coming up only to hunt for food or pillage before returning to their cavernous homes.
                As an Elezen, your Intelligence score increases by 2. Base walking speed is 30ft.
                If you select the Wildwood, your Dexterity increases by 1.
                Selecting Duskwight increases your Constitution by 1.
                Ishgardian increases Strength by 1.
                """);
        while (true) {
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
            scanner.close();
        }
    }

    private static Garlean garleanCreator(Scanner scanner) {
        System.out.println("""
                The Garleans are physically strong and highly intelligent people who call the land of Ilsabard their home.
                They are marked by their third eye, a gem like growth in the center of their forehead.
                Unfortunately for them, the Garleans as a whole have great difficulty channeling aether through their bodies, which despite their physicality and intelligence, found themselves bowing to many other magic wielding races.
                They were eventually able to develop technology to make up for this lack of magical aptitude and turned the tables, establishing the Garlean Empire in Ilsabard, a dominate force which sought to invade the land of Eorzea.
                Garleans do not have clans, but rather titles that state their hierarchy in the Empire.
                """);
        while (true) {
            System.out.println("You have selected to make a Garlean.");
            System.out.println("Please confirm your choice. Press 1 to confirm, or 2 to return to the race selection:");

            try {
                String confirmation = scanner.nextLine();
                switch (confirmation) {
                    case "1" -> {
                        return new Garlean();
                    }
                    case "2" -> {
                        System.out.println("Returning to race selection...");
                        return null;
                    }
                    default ->
                            System.out.println("Invalid input. Please press 1 to confirm, or 2 to return to the race selection.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }


    private static Hrothgar hrothgarCreator(Scanner scanner) {
        System.out.println("""
                The Hrothgar are powerful, feline people from the Northeast who had struggles when meeting the other races of the world as they were unable to speak the common tongue.
                They call Ilsabard their homeland and they walk two distinct paths, one of servitude and the other of freedom.
                These distinct paths and ways of life led to the Helions, warm coloured Hrothgar who serve in the name of their Queen, and The Lost, cool coloured Hrothgar who value freedom above all else.
                As a Hrothgar, your Strength increases by 2, and your walking speed is 30ft.
                If you select a Helion, your Dexterity increases by 1.
                If you select The Lost, your Constitution increases by 1.
                """);
        while (true) {
            System.out.println("Please pick which clan you wish to be: (1) Helion or (2) The Lost");
            String selectClan = scanner.nextLine();
            String selectedClan = "";

            if (selectClan.equals("1") || selectClan.equalsIgnoreCase("Helion")) {
                selectedClan = "Helion";
            } else if (selectClan.equals("2") || selectClan.equalsIgnoreCase("The Lost")) {
                selectedClan = "The Lost";
            } else {
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
            scanner.close();
        }
    }


    private static Hyur hyurCreator(Scanner scanner) {
        System.out.println("""
                The Hyur have spread across the entirety of the world, making it difficult to trace what their homeland truly is.
                There are the average sized Midlanders, named for the elevation in which their sub species lived for many years, and the taller, more muscular highlanders, who lived in the high mountains for their declared homeland.
                Lastly, there are the exceedingly rare Padjal, revered because they were chosen by the elementals at birth.
                Padjals have white hued animal horns growing from their head and stop aging around their teens, having a natural latent power for conjury.
                As a Hyur, you get to increase any ability score of your choice by 1. Your base walking speed is 30ft.
                If you select a Midlander, your Intelligence increases by 2.
                If you select a Highlander, your Strength increases by 2.
                If you select Padjal, your Wisdom increases by 2.
                """);
        while (true) {
            System.out.println("Please pick which clan you wish to start as: (1) Midlander, (2) Highlander, or (3) Padjal");
            String selectClan = scanner.nextLine();
            String selectedClan = "";
            if (selectClan.equals("1") || selectClan.equalsIgnoreCase("Midlander")) {
                selectedClan = "Midlander";
            } else if (selectClan.equals("2") || selectClan.equalsIgnoreCase("Highlander")) {
                selectedClan = "Highlander";
            } else if (selectClan.equals("3") || selectClan.equalsIgnoreCase("Padjal")) {
                selectedClan = "Padjal";
            } else {
                System.out.println("Invalid input. Type 1, 2, 3, or the name of the clan you wish to be");
                continue;
            }
            System.out.println("You have selected to make a " + selectedClan + " Hyur");
            System.out.println("Please confirm your choice. Press 1 to confirm, 2 to go back to clan selection, and 3 to return to the race selection");
            try {
                String clanConfirmation = scanner.nextLine();
                switch (clanConfirmation) {
                    case "1" -> {
                        Hyur character = new Hyur();
                        character.pickClan(selectedClan);
                        return character;
                    }
                    case "2" -> {
                        System.out.println("Let's try again. Returning to clan selection.");
                    }
                    case "3" -> {
                        System.out.println("Returning to race selection...");
                        return null;
                    }
                    default -> System.out.println("Invalid input. Type 1, 2, or 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again");
            }
        }
    }

    private static Lalafell lalafellCreator(Scanner scanner) {
        System.out.println("""
                The Lalafell immigrated from Southern islands to Eorzea forming two distinct groups based on the geography their ancestors settled in.
                The darker skinned Dunesfolk formed the city state of Ul’dah in the deserts of Thanalan, while the lighter skinned Planesfolk settled and farmed the lands of La Noscea, a large island off the mainland of Eorzea.
                Both of these naturally charming folk found great success as merchants through history.
                As a Lalafell, your Charisma increases by 1, and your base walking speed is 25.
                If you select a Dunesfolk, your Intelligence increases by 1.
                If you select a Plainsfolk, your Dexterity will increase by 1.
                """);
        while (true) {
            System.out.println("Please pick which clan you wish to start as: (1) Dunesfolk or (2) Plainsfolk");
            String selectClan = scanner.nextLine();
            String selectedClan = "";
            if (selectClan.equals("1") || selectClan.equalsIgnoreCase("Dunesfolk")) {
                selectedClan = "Dunesfolk";
            } else if (selectClan.equals("2") || selectClan.equalsIgnoreCase("Plainsfolk")) {
                selectedClan = "Plainsfolk";
            } else {
                System.out.println("Invalid input. Type 1, 2, 3, or the name of the clan you wish to be");
                continue;
            }
            System.out.println("You have selected to make a " + selectedClan + " Lalafell");
            System.out.println("Please confirm your choice. Press 1 to confirm, 2 to go back to clan selection, and 3 to return to the race selection");
            try {
                String clanConfirmation = scanner.nextLine();
                switch (clanConfirmation) {
                    case "1" -> {
                        Lalafell character = new Lalafell();
                        character.pickClan(selectedClan);
                        return character;
                    }
                    case "2" -> {
                        System.out.println("Let's try again. Returning to clan selection.");
                    }
                    case "3" -> {
                        System.out.println("Returning to race selection...");
                        return null;
                    }
                    default ->
                            System.out.println("Invalid input. Type 1, 2, 3, or the name of the clan you wish to be");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again");
            }
        }
    }

    private static Miqote miqoteCreator(Scanner scanner) {
        System.out.println("""
                 The Miqo'te are a second group of feline people who traveled to Eorzea across a frozen sea long ago.
                 These proud people find pride in their natural hunting ability and have split into two distinct ethnic groups who worship the sun and moon respectively.
                 The Seekers of the Sun live in warmer climates in patriarchal societies.
                 The Keepers of the Moon live in dense forests, their tribes centering on matriarchs.
                 As a Miqo'te, your Wisdom increases by 2 and your base walking speed is 30ft.
                 Seekers of the Sun increase their Charisma by 1.
                 Keepers of the Moon increase their Wisdom by 1.
                """);
        while (true) {
            System.out.println("Please pick which clan you wish to be: (1) Seekers of the Sun or (2) Keepers of the Moon");
            String selectClan = scanner.nextLine();
            String selectedClan = "";
            if (selectClan.equals("1") || selectClan.equalsIgnoreCase("Seekers of the Sun")) {
                selectedClan = "Seekers of the Sun";
            } else if (selectClan.equals("2") || selectClan.equalsIgnoreCase("Keepers of the Moon")) {
                selectedClan = "Keepers of the Moon";
            } else {
                System.out.println("Invalid input. Type 1, 2, or the name of the clan you wish to be");
                continue;
            }
            System.out.println("You have selected to make a " + selectedClan + " Miqo'te");
            System.out.println("Please confirm your choice. Press 1 to confirm, 2 to go back to clan selection, and 3 to return to the race selection");
            try {
                String clanConfirmation = scanner.nextLine();
                switch (clanConfirmation) {
                    case "1" -> {
                        Miqote miqote = new Miqote();
                        miqote.pickClan(selectedClan);
                        return miqote;
                    }
                    case "2" -> {
                        System.out.println("Let's try again. Returning to clan selection.");
                    }
                    case "3" -> {
                        System.out.println("Returning to race selection...");
                        return null;
                    }
                    default -> System.out.println("Invalid input. Please try again");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again");
            }
        }
    }

    private static Roegadyn roegadynCreator(Scanner scanner) {
        System.out.println("""
                The Roegadyn are large, hulking people who hail from the mountains and the sea.
                The Sea Wolves are known as famed pirates and settled the coastal city state Limsa Lominsa, while the Hellsguard live in villages atop mountains and volcanoes, acting as keepers of the land, believing such locations to be portals to other worlds.
                As a Roegadyn, your Constitution increases by 2.
                If you select a Seawolf, your Strength increases by 1.
                If you select a Hellsguard, your Charisma increases by 1.
                """);
        while (true) {
            System.out.println("Please pick which clan you wish to be: (1) Sea Wolf or (2) Hellsguard");
            String selectClan = scanner.nextLine();
            String selectedClan = "";
            if (selectClan.equals("1") || selectClan.equalsIgnoreCase("Sea Wolf")) {
                selectedClan = "Sea Wolf";
            } else if (selectClan.equals("2") || selectClan.equalsIgnoreCase("Hellsguard")) {
                selectedClan = "Hellsguard";
            } else {
                System.out.println("Invalid input. Type 1, 2, or the name of the clan you wish to be");
                continue;
            }
            System.out.println("You have selected to make a " + selectedClan + " Roegadyn");
            System.out.println("Please confirm your choice. Press 1 to confirm, 2 to go back to clan selection, and 3 to return to the race selection");
            try {
                String clanConfirmation = scanner.nextLine();
                switch (clanConfirmation) {
                    case "1" -> {
                        Roegadyn roegadyn = new Roegadyn();
                        roegadyn.pickClan(selectedClan);
                        return roegadyn;
                    }
                    case "2" -> {
                        System.out.println("Let's try again. Returning to clan selection.");
                    }
                    case "3" -> {
                        System.out.println("Returning to race selection...");
                        return null;
                    }
                    default -> System.out.println("Invalid input. Type 1, 2, or the name of the clan you wish to be");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again");
            }
        }
    }

    private static Viera vieraCreator(Scanner scanner) {
        System.out.println("""
                he Viera are lapine people who live in dense forests and act as the protectors of their home.
                With their more secluded nature, they generally avoid contact with the outside world, happily protecting the Golmore Jungles and Skatay Range, both found in the east.
                There are two distinct groups of Viera who developed slightly differently based on their homes, the Rava having darker skin while the Veena have far fairer skin, both groups blending into their respective environments better thanks to these adaptations.
                As a Viera, your Dexterity increases by 2.
                If you select a Rava, your Wisdom increases by 1.
                If you select a Veena, your Intelligence increases by 1.
                """);
        while (true) {
            System.out.println("Please select which clan you wish to be: (1) Rava or (2) Veena");
            String selectClan = scanner.nextLine();
            String selectedClan = "";
            if (selectClan.equals("1") || selectClan.equalsIgnoreCase("Rava")) {
                selectedClan = "Rava";
            } else if (selectClan.equals("2") || selectClan.equalsIgnoreCase("Veena")) {
                selectedClan = "Veena";
            } else {
                System.out.println("Invalid input. Type 1, 2, or the name of the clan you wish to be");
                continue;
            }
            System.out.println("You have selected to make a " + selectedClan + " Viera");
            System.out.println("Please confirm your choice. Press 1 to confirm, 2 to go back to clan selection, and 3 to return to the race selection");
            try {
                String clanConfirmation = scanner.nextLine();
                switch (clanConfirmation) {
                    case "1" -> {
                        Viera character = new Viera();
                        character.pickClan(selectedClan);
                        return character;
                    }
                    case "2" -> {
                        System.out.println("Let's try again. Returning to clan selection.");
                    }
                    case "3" -> {
                        System.out.println("Returning to race selection...");
                        return null;
                    }
                    default ->
                            System.out.println("Invalid input. Please press 1 to confirm, 2 to go back to clan selection, or 3 to return to the race selection");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again");
            }
        }
    }


    public static String getName(Scanner scanner, Race race, Sex sex, HashMap<String, Integer> stats) {
        String firstName;
        String lastName;
        while (true) {
            System.out.println("Time to make pick a name. You can create one yourself or one can randomly be assigned to you based on your character's race, clan, and sex. Press 1 for custom, press 2 for random. Your custom name will be limited to 20 characters total, and the first and last name can have no more than 15 characters each");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                while (true) {
                    System.out.println("Please enter your first name: ");
                    firstName = scanner.nextLine();
                    if (firstName.matches("[a-zA-Z]'?[a-zA-Z]+-?")) {
                        firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
                        if (race instanceof Garlean) {
                            System.out.println("Garleans have military and social titles for anyone in the Empire. Please pick a title:");
                            for (Garlean.GarleanTitles titles : Garlean.GarleanTitles.values()) {
                                System.out.println(titles.name() + " " + titles.getTitleDescription());
                            }
                            while (true) {
                                try {
                                    String title = scanner.nextLine();
                                    race.chosenVariables(title);
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.out.println("That's not a valid title. Please try again");
                                }
                            }
                        }
                    } else {
                        System.out.println("Names cannot contain numbers or symbols except an apostrophe or hyphen");
                        continue;
                    }

                    System.out.println("Please enter your last name: ");
                    lastName = scanner.nextLine();
                    if (lastName.matches("[a-zA-Z]+'?-?")) {
                        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();

                        if (firstName.length() <= 15 && firstName.length() >= 2 && lastName.length() <= 15 && lastName.length() >= 2 && (firstName.length() + lastName.length()) <= 20) {
                            if (race instanceof Garlean) {
                                return firstName + " " + ((Garlean) race).getGarleanTitle().name().toLowerCase() + " " + lastName;
                            } else {
                                return firstName + lastName;
                            }
                        } else {
                            System.out.println("Name is too long!");
                            scanner.nextLine();
                        }
                    } else {
                        System.out.println("Names cannot contain numbers or symbols except an apostrophe or hyphen");
                        continue;
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
}


