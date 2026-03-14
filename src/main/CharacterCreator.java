/*
@startuml
class CharacterCreator {
-getStats (scan : Scanner): HashMap<String, Integer>
-auRaCreator (scan : Scanner): AuRa
-elezenCreator (scan : Scanner): Elezen
-garleanCreator (scan : Scanner): Garlean
-hyurCreator (scan : Scanner): Hyur
-lalafellCreator (scan : Scanner): Lalafell
-miqoteCreator (scan : Scanner): Miqote
-roegadynCreator (scan : Scanner): Roegadyn
-vieraCreator (scan : Scanner): Viera
+getName (scanner: Scanner, race : Race, sex : Sex, stats : HashMap<String, Integer>): String
+printSpellBook (job : Job): void
}

abstract class Job {
#name : String
#description : String
#hitDice : String
#baseHP : int
#savingThrows : String
#proficiences : ArrayList<String>
#startingEquipment : ArrayList<String>
#knownCantrips : ArrayList<String>
#firstLevelSpells : ArrayList<String>
#numCantrips : int
#spellSlots : int[]
#numSpells : int
+getMartialWeaponsList() : ArrayList<String>
+getSimpleWeaponsList() : ArrayList<String>
+getValidSimpleWeaponsChoice() : PlayerChoices
+getArtisanToolsList() : ArrayList<String>
+getMusicalInstrumentsList() : ArrayList<String>
+Job()
+getJobName() : String
+getHP(conModifier : int): int
{abstract} + addJobOptions() : ArrayList<PlayerChoices>
+addEquipment(item : String): void
{abstract} + applyJob(): void
+printInventory() : void
+getSavingThrows() : String
+getDescription() : String
+startingSpells() : void
+loadFromFile(filePath : String, tag: String):ArrayList<String>
~pickRandomSpell(spellList : ArrayList<String>, slot : int): ArrayList<String>
+getKnownCantrips() : ArrayList<String>
+getFirstLevelSpells() : ArrayList<String>
}

class Astrologian {
+Astrologian()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class Bard {
+Bard()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class BlackMage {
+BlackMage()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class Dancer {
+Dancer()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class DarkKnight {
+DarkKnight()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class Dragoon {
+Dragoon()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class Gunbreaker {
+Gunbreaker()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class Machinist {
+Machinist()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class Monk {
+Monk()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class Ninja {
+Ninja()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class Paladin {
+Paladin()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class Pictomancer {
+Pictomancer()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class Reaper {
+Reaper()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class RedMage {
+RedMage()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class Sage {
+Sage()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class Samurai {
+Samurai()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class Scholar {
+Scholar()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class Summoner {
+Summoner()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class Viper {
+Viper()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class Warrior {
+Warrior()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}
class WhiteMage {
+WhiteMage()
+addJobOptions() : ArrayList<PlayerChoices>
+applyJob() : void
}

abstract class Race {
#name : String
#description : String
#walkingSpeed : int
#statBonuses : Map<Stat, Integer>
#initialRaceBonuses : Map<Stat,Integer>
#darkVisionRadius : int
{abstract} + randomNameGenerator(sex : Sex, stats : HashMap<String, Integer>): String
+getDarkVisionRadius() : int
+Race()
#startingStats() : void
+getName() : String
+getDescription() : String
+getWalkingSpeed() : int
+getBonusFor(clan : String): int
{abstract} + pickClan(clan : String): void
{abstract} + clanBonuses() : void
{abstract} + raceOptions() : ArrayList<PlayerChoices>
{abstract} + chosenVariables(input : String): void
#addBonus(stat : Stat, quantity : int): void
}

class AuRa {
-raenMNames : ArrayList<String>
-raenFNames : ArrayList<String>
-xaelaMNames : ArrayList<String>
-xaelaFNames : ArrayList<String>
-clanNames : ArrayList<String>
-familyNames : ArrayList<String>
#raceStats() : void
}

class Elezen {
-elezenMNames : ArrayList<String>
-elezenFNames : ArrayList<String>
-elezenSurnames : ArrayList<String>
}

class Garlean {
-title : GarleanTitles
+Garlean()
+setGarleanTitle(title : GarleanTitles) : void
+getGarleanTitle() : GarleanTitles
+randomNameGenerator(sex : Sex, stats : HashMap<String, Integer>) : String
+pickClan(clan : String) : void
+clanBonuses() : void
+raceOptions() : ArrayList<PlayerChoices>
+chosenVariables(input : String) : void
}

class Hrothgar {
-clanChoice : HrothgarClan
-hrothMNames : ArrayList<String>
-hrothFNames : ArrayList<String>
-helionNames : ArrayList<String>
-theLostNames : ArrayList<String>
+Hrothgar()
+randomNameGenerator(sex : Sex, stats : HashMap<String, Integer>) : String
#raceStats() : void
+pickClan(clan : String) : void
+clanBonuses() : void
+raceOptions() : ArrayList<PlayerChoices>
+chosenVariables(input : String) : void
}

class Hyur {
-clanChoice : HyurClan
-midMNames : ArrayList<String>
-midFNames : ArrayList<String>
-highMNames : ArrayList<String>
-highFNames : ArrayList<String>
-midSurnames : ArrayList<String>
-highSurnames : ArrayList<String>
+Hyur()
+randomNameGenerator(sex : Sex, stats : HashMap<String, Integer>) : String
+pickClan(clan : String) : void
+clanBonuses() : void
+raceOptions() : ArrayList<PlayerChoices>
+hyurBonus(choice : Stat) : void
+chosenVariables(input : String) : void
}

class Lalafell {
-plainsMNames : ArrayList<String>
-plainsFNames : ArrayList<String>
-dunesMNames : ArrayList<String>
-dunesFNames : ArrayList<String>
-clanChoice : LalafellClan
+Lalafell()
+randomNameGenerator(sex : Sex, stats : HashMap<String, Integer>) : String
#raceStats() : void
+pickClan(clan : String) : void
+clanBonuses() : void
+raceOptions() : ArrayList<PlayerChoices>
+chosenVariables(input : String) : void
}

class Miqote {
-sunTribeChars : ArrayList<String>
-sunMNames : ArrayList<String>
-sunFNames : ArrayList<String>
-moonMNames : ArrayList<String>
-moonFNames : ArrayList<String>
-moonSurnames : ArrayList<String>
-clanChoice : MiqoteClan
+Miqote()
+randomNameGenerator(sex : Sex, stats : HashMap<String, Integer>) : String
#raceStats() : void
+pickClan(clan : String) : void
+clanBonuses() : void
+raceOptions() : ArrayList<PlayerChoices>
+chosenVariables(input : String) : void
}

class Roegadyn {
-clanChoice : RoegadynClan
-roeMSeaWolvesNames : ArrayList<String>
-roeFSeaWolvesNames : ArrayList<String>
-roeMHellNames : ArrayList<String>
-roeFHellNames : ArrayList<String>
+Roegadyn()
+randomNameGenerator(sex : Sex, stats : HashMap<String, Integer>) : String
#raceStats() : void
+pickClan(clan : String) : void
+clanBonuses() : void
+raceOptions() : ArrayList<PlayerChoices>
+chosenVariables(input : String) : void
}

class Viera {
-clanChoice : VieraClan
-vieraMNames : ArrayList<String>
-vieraFNames : ArrayList<String>
+Viera()
+randomNameGenerator(sex : Sex, stats : HashMap<String, Integer>) : String
#raceStats() : void
+pickClan(clan : String) : void
+clanBonuses() : void
+raceOptions() : ArrayList<PlayerChoices>
+chosenVariables(input : String) : void
}

class Character {
    - name : String
    - sex : Sex
    - race : Race
    - job : Job
    + Character()
    + setRace(race : Race) : void
    + getRace() : Race
    + setJob(job : Job) : void
    + setSex(sex : Sex) : void
    + setName(name : String) : void
}

enum Sex {
    MALE
    FEMALE
}

enum Alignment {
    LAWFUL_GOOD
    NEUTRAL_GOOD
    CHAOTIC_GOOD
    LAWFUL_NEUTRAL
    TRUE_NEUTRAL
    CHAOTIC_NEUTRAL
    LAWFUL_EVIL
    NEUTRAL_EVIL
    CHAOTIC_EVIL
    - cleanAlignment : String
    + Alignment(cleanAlignment : String)
    + toString() : String
}

enum Stat {
    STRENGTH
    DEXTERITY
    CONSTITUTION
    INTELLIGENCE
    WISDOM
    CHARISMA
}

enum GarleanTitles {
    ZOS
    YAE
    WIR
    VAN
    TOL
    SAS
    REM
    QUO
    PYR
    OEN
    NAN
    MAL
    LUX
    KIR
    JEN
    IYL
    HET
    GOE
    FAE
    EIR
    DUS
    CEN
    BAS
    AAN
    VIATOR
    -titleDescription : String
    +getTitleDescription() : String
}

enum HrothgarClan {
    HELIONS
    THE_LOST
}

enum HyurClan {
    MIDLANDERS
    HIGHLANDERS
    PADJAL
}

enum LalafellClan {
    PLAINSFOLK
    DUNESFOLK
}

enum MiqoteClan {
    SEEKERS_OF_THE_SUN
    KEEPERS_OF_THE_MOON
}

enum RoegadynClan {
    SEA_WOLVES
    HELLSGUARD
}

enum VieraClan {
    RAVA
    VEENA
}

class DiceRoller {
    + {static} statRoll() : int
    + {static} insertionSort(dice : ArrayList<Integer>) : void
}

class PlayerChoices {
    - question : String
    - equipmentOptions : List<String>
    - isItem : boolean
    - followQs : Map<String, List<PlayerChoices>>
    + PlayerChoices(question : String, equipmentOptions : List<String>)
    + PlayerChoices(question : String, equipmentOptions : List<String>, isItem : boolean)
    + fQuestion(answer : String, followQuestions : PlayerChoices) : void
    + getQuestion() : String
    + getEquipmentOptions() : List<String>
    + isItem() : boolean
    + getFollowQs() : Map<String, List<PlayerChoices>>
}

' === RELATIONSHIPS & ARROWS ===

' Nesting Enums inside Character
Character +-- Sex
Character +-- Alignment

' General Enums/Races
Race +-- Stat
Garlean +-- GarleanTitles
Hrothgar +-- HrothgarClan
Hyur +-- HyurClan
Lalafell +-- LalafellClan
Miqote +-- MiqoteClan
Roegadyn +-- RoegadynClan
Viera +-- VieraClan

' Aggregation (Character HAS a Job and HAS a Race)
Character o-- Job
Character o-- Race

' Inheritance for Jobs
Job <|-- Astrologian
Job <|-- Bard
Job <|-- BlackMage
Job <|-- Dancer
Job <|-- DarkKnight
Job <|-- Dragoon
Job <|-- Gunbreaker
Job <|-- Machinist
Job <|-- Monk
Job <|-- Ninja
Job <|-- Paladin
Job <|-- Pictomancer
Job <|-- Reaper
Job <|-- RedMage
Job <|-- Sage
Job <|-- Samurai
Job <|-- Scholar
Job <|-- Summoner
Job <|-- Viper
Job <|-- Warrior
Job <|-- WhiteMage

' Inheritance for Races
Race <|-- AuRa
Race <|-- Elezen
Race <|-- Garlean
Race <|-- Hrothgar
Race <|-- Hyur
Race <|-- Lalafell
Race <|-- Miqote
Race <|-- Roegadyn
Race <|-- Viera
Job ..> PlayerChoices : "returns list of"
Race ..> PlayerChoices : "returns list of"
CharacterCreator ..> DiceRoller : "calls statRoll()"
CharacterCreator ..> Character : "instantiates"
@enduml
 */
package main;

import java.io.IOException;
import java.util.*;

import jobs.*;
import main.Character.*;
import races.*;

/** The main class, where the user is prompted and the character is created */
public class CharacterCreator {
    /**The main method*/
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
        Alignment chosenAlignment = chooseAlignment(scan);

        characterName = getName(scan, chosenRace, chosenSex, finalStats);

        ArrayList<PlayerChoices> jobSelection = chosenJob.addJobOptions();
        for (int i = 0; i < jobSelection.size(); i++) {
            PlayerChoices choices = jobSelection.get(i);
            System.out.println("\n" + choices.getQuestion());

            List<String> options = choices.getEquipmentOptions();


            int validNumber = 0;

            if (options.size() == 1) {
                validNumber = 1;
            } else {
                for (int j = 0; j < options.size(); j++) {
                    System.out.println((j + 1) + ". " + options.get(j));
                }

                boolean isValid = false;

                while (!isValid) {
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
            }
            String selection = options.get(validNumber - 1);
            if (choices.isItem()) {
                chosenJob.addEquipment(selection);
                System.out.println(selection + " was added to your starting bag");
            }
            if (choices.getFollowQs().containsKey(selection)) {
                jobSelection.addAll(i + 1, choices.getFollowQs().get(selection));
            }
        }
        if (chosenRace instanceof Garlean) {
            ((Garlean) chosenRace).getGarleanTitle();
        }
        System.out.println("Congrats, your " + chosenRace.getName() + " " + chosenJob.getJobName() + " named " + characterName + " aligned as " + chosenAlignment + " has been created!");
        chosenJob.printInventory();
        String[] stats = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
        System.out.println("\nHere are your stats");
        for (String name : stats) {
            int baseStat = finalStats.get(name);
            int bonusStat = chosenRace.getBonusFor(Race.Stat.valueOf(name.toUpperCase()));
            System.out.println(name + ": " + baseStat + " + " + bonusStat + " (Total: " + (baseStat + bonusStat) + ")");

        }

        int conMod = ((finalStats.get("Constitution") - 10) / 2);
        int maxHP = chosenJob.getHP(conMod);
        System.out.println("Lastly, your vitals");
        System.out.println("Max HP: " + maxHP);
        System.out.println("Walking speed: " + chosenRace.getWalkingSpeed() + "ft");
        if (chosenRace.getDarkVisionRadius() > 0) {
            System.out.println("Darkvision radius: " + chosenRace.getDarkVisionRadius() + "ft");
        } else {
            System.out.println();
        }
        System.out.println("Saving throws: " + chosenJob.getSavingThrows());

        printSpellBook(chosenJob);

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
        DiceRoller.insertionSort(dice);

        System.out.println("Your dice rolls are: " + dice);
        System.out.println("You can manually assign them, or let fate decide your stats. Press 1 for manual, 2 for random");

        String randomDiceChoice = "";
        while (true) {
            randomDiceChoice = scan.nextLine().trim();
            if (randomDiceChoice.equals("1") || randomDiceChoice.equals("2")) {
                break;
            }
            System.out.println("Please press 1 for manual or 2 for random");
        }

        if (randomDiceChoice.equals("2")) {
            System.out.println("Randomly assigning stats...");
            Collections.shuffle(dice);

            for (int i = 0; i < statNames.length; i++) {
                stats.put(statNames[i], dice.get(i));
                System.out.println(statNames[i] + ": " + dice.get(i));
            }
            return stats;
        }

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
        Race[] availableRaces = {new AuRa(), new Elezen(), new Garlean(), new Hrothgar(), new Hyur(), new Lalafell(), new Miqote(), new Roegadyn(), new Viera()};
        Race chosenRace = null;
        boolean validRace = false;

        while (!validRace) {
            System.out.println("\nHello! Welcome to the Dungeons and Dragons x Final Fantasy XIV Character Creator! To get started, first pick your race from the list below:");
            for (int i = 0; i < availableRaces.length; i++) {
                System.out.println((i + 1) + ". " + availableRaces[i].getName());
                System.out.println("    " + availableRaces[i].getDescription() + "\n");
            }
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

    private static Job getJob(Scanner scan) throws NumberFormatException {
        Job[] chooseJob = {new Astrologian(), new Bard(), new BlackMage(), new Dancer(), new DarkKnight(), new Gunbreaker(), new Machinist(), new Monk(), new Ninja(), new Paladin(), new Pictomancer(), new Reaper(), new RedMage(), new Sage(), new Samurai(), new Scholar(), new Summoner(), new Viper(), new Warrior(), new WhiteMage()};
        Job chosenJob = null;
        boolean validJob = false;
        while (!validJob) {
            System.out.println("\nSelect a job from the list below:");
            for (int i = 0; i < chooseJob.length; i++) {
                System.out.println((i + 1) + ". " + chooseJob[i].getJobName() + " - " + chooseJob[i].getDescription());
            }
            String input = scan.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= chooseJob.length) {
                    chosenJob = chooseJob[choice - 1];
                    chosenJob.applyJob();
                    validJob = true;
                } else {
                    System.out.println("Please enter a number between 1 and " + (chooseJob.length - 1));
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Invalid input. Please enter a number");
                ;
            }
        }
        return chosenJob;
    }


    private static AuRa auRaCreator(Scanner scanner) {
        System.out.println("""
                As an Au Ra, your Wisdom ability score will increase by 2. Base walking speed is 30ft.
                If you select the Xaela clan, your Strength will increase by 2.
                If you select the Raen, your Charisma will increase by 1.
                """);
        while (true) {
            System.out.println("Please pick which clan you wish to start as:\n(1) Xaela\n(2) Raen");
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
        }
    }

    private static Elezen elezenCreator(Scanner scanner) {
        System.out.println("""
                As an Elezen, your Intelligence score increases by 2. Base walking speed is 30ft.
                If you select the Wildwood, your Dexterity increases by 1.
                Selecting Duskwight increases your Constitution by 1.
                Ishgardian increases Strength by 1.
                """);
        while (true) {
            System.out.println("Please pick which clan you wish to start as:\n(1) Wildwood\n(2) Duskwight\n(3) Ishgardian");
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
        }
    }

    private static Garlean garleanCreator(Scanner scanner) {
        System.out.println("""
                Garleans do not have clans, but rather titles that state their hierarchy in the Empire.
                As a Garlean, your Strength increases by 2, and your Intelligence increases by 1.
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
                As a Hrothgar, your Strength increases by 2, and your walking speed is 30ft.
                If you select a Helion, your Dexterity increases by 1.
                If you select The Lost, your Constitution increases by 1.
                """);
        while (true) {
            System.out.println("Please pick which clan you wish to be:\n(1) Helion\n(2) The Lost");
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
        }
    }


    private static Hyur hyurCreator(Scanner scanner) {
        System.out.println("""
                As a Hyur, you get to increase any ability score of your choice by 1. Your base walking speed is 30ft.
                If you select a Midlander, your Intelligence increases by 2.
                If you select a Highlander, your Strength increases by 2.
                If you select Padjal, your Wisdom increases by 2.
                """);
        while (true) {
            System.out.println("Please pick which clan you wish to start as:\n(1) Midlander\n(2) Highlander\n(3) Padjal");
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
                As a Lalafell, your Charisma increases by 1, and your base walking speed is 25.
                If you select a Dunesfolk, your Intelligence increases by 1.
                If you select a Plainsfolk, your Dexterity will increase by 1.
                """);
        while (true) {
            System.out.println("Please pick which clan you wish to start as:\n(1) Dunesfolk\n(2) Plainsfolk");
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
                 As a Miqo'te, your Wisdom increases by 2 and your base walking speed is 30ft.
                 Seekers of the Sun increase their Charisma by 1.
                 Keepers of the Moon increase their Wisdom by 1.
                """);
        while (true) {
            System.out.println("Please pick which clan you wish to be:\n(1) Seekers of the Sun\n(2) Keepers of the Moon");
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
                As a Roegadyn, your Constitution increases by 2.
                If you select a Seawolf, your Strength increases by 1.
                If you select a Hellsguard, your Charisma increases by 1.
                """);
        while (true) {
            System.out.println("Please pick which clan you wish to be:\n(1) Sea Wolf\n(2) Hellsguard");
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
                As a Viera, your Dexterity increases by 2.
                If you select a Rava, your Wisdom increases by 1.
                If you select a Veena, your Intelligence increases by 1.
                """);
        while (true) {
            System.out.println("Please select which clan you wish to be:\n(1) Rava\n(2) Veena");
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

    /**
     * Creates the name for the character being created by asking a series of questions. Can randomly assign a name
     * based on race and sex. Garlean titles are assigned based on stats, if chosen at random
     * @param scanner The input from the player
     * @param race The race of the character being created
     * @param sex The sex of the character being created
     * @param stats The stats pertaining to the character, used for generating Garlean title
     * @return The name of the character in the order of first name, (optional) title, and last name
     */
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
                                return firstName + " " + lastName;
                            }
                        } else {
                            System.out.println("Name is too long!");
                        }
                    } else {
                        System.out.println("Names cannot contain numbers or symbols except an apostrophe or hyphen");
                    }
                }
            } else if (input.equals("2")) {
                String generatedName = race.randomNameGenerator(sex, stats);
                System.out.println(generatedName + " was the name generated. Would you like to keep it? Y for yes, N for no");
                if (scanner.nextLine().equalsIgnoreCase("Y")) {
                    return generatedName;

                } else {
                    System.out.println("Rerolling name");
                    continue;
                }
            } else {
                System.out.println("Invalid option. Please pick either 1 or 2");
                scanner.nextLine();

            }

        }
    }

    /**
     * Asks the player what alignment their character is going to be
     * @param scan The input from the user
     * @return The alignment of the character
     */
    public static Alignment chooseAlignment(Scanner scan) {
        while (true) {
            System.out.println("Pick your alignment: ");
            for (int i = 0; i < Alignment.values().length; i++) {
                System.out.println((i + 1) + ". " + Alignment.values()[i]);
            }
            String alignmentSelection = scan.nextLine().trim();
            try {
                int choice = Integer.parseInt(alignmentSelection);
                if (choice < 1 || choice > Alignment.values().length) {
                    System.out.println("Please pick a number between 1 and " + Alignment.values().length);
                } else {
                    return Alignment.values()[choice - 1];
                }
            } catch (NumberFormatException e) {
                System.out.println("Please type a number.");
            }
        }
    }

    /**
     * Prints the spells and cantrips chosen at random
     * @param job The character's job, which specifies what cantrips or spells the character gets access to
     */
    public static void printSpellBook(Job job) {
        if (job.getKnownCantrips().isEmpty() && job.getFirstLevelSpells().isEmpty()) {
            return;
        }
        System.out.println("\nYour spells and cantrips are:\n");
        if (!job.getKnownCantrips().isEmpty()) {
            System.out.println("Cantrips: ");
            System.out.println(String.join(", ", job.getKnownCantrips()));
        }
        if (!job.getFirstLevelSpells().isEmpty()) {
            System.out.println("First level spells: ");
            System.out.println(String.join(", ", job.getFirstLevelSpells()));
        }
    }
}
