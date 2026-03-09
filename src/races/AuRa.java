package races;
import main.PlayerChoices;
import java.util.*;

public class AuRa extends Race {
	private AuRaClan clanChoice;
	private ArrayList<String> raenMNames = new ArrayList<>(Arrays.asList("Osetu", "Keimei" , "Rakuyo", "Hien", "Genbu", "Fugetsu", "Unzan", "Masatsuchi",
			"Izuna", "Sagan", "Karaku", "Chikamasa", "Rokuyari", "Tanehiro" , "Yoshikore" , "Hidetake", "Norishig"));
	private ArrayList<String> raenFNames = new ArrayList<>(Arrays.asList("Yachiyo", "Kikyo", "Awayuki", "Narumi", "Azami", "Kurenai", "Tsubaki", "Chidori", "Suzume", "Mizuki", "Ibuki"));
	private ArrayList<String> xaelaMNames = new ArrayList<>(Arrays.asList("Arslang", "Agasiletai", "Chaghagan", "Chuacenur", "Bayan", "Luvsan", "Bujeg",
			"Khalja", "Charakha", "Khaishan", "Chigu", "Jebke", "Cirina", "Narangerel", "Ogul", "Altan"));
	private ArrayList<String> xaelaFNames = new ArrayList<>(Arrays.asList("Boragchin", "Narengawa", "Chotan", "Qoyar", "Khorchi", "Ogul", "Checheyigen", "Altun", "Eji",
			"Baguchi", "Odchigin", "Khorghosun", "Yesun", "Ariunbold", "Bayar"));
	private ArrayList<String> clanNames = new ArrayList<>(Arrays.asList("Adarkim", "Angura", "Arulaq", "Avagnar", "Bairon", "Bayaqud", "Bolir", "Borlaa", "Buduga", "Dalamiq", "Iriq", "Jhungid", "Kharlu", "Khatayin", "Malqir", "Mankhad", "Mierqid",
			"Noykin", "Olkund", "Dazkar", "Oronir", "Oroq", "Qerel", "Torgud", "Tumet", "Ugund", "Uyagir", "Dhoro", "Orben", "Ejinn", "Dotharl", "Hotgo", "Sagahl", "Kahkol", "Kha", "Mol", "Gesi",
			"Kagon", "Goro", "Gharl", "Dataq", "Haragin", "Ura", "Moks", "Geneq", "Horo", "Himaa", "Malaguld", "Urumet", "Qalli"));
	private ArrayList<String> familyNames = new ArrayList<>(Arrays.asList("Yuzuka", "Obinata", "Yuzuka", "Yatsurugi", "Rokuyari", "Godo", "Tabito", "Yumishi", "Musa"));
	public enum AuRaClan {
		RAEN, XAELA
	}

	@Override
	public String randomNameGenerator(Sex sex, HashMap<String, Integer> stats) {
		Random rand = new Random();
		String randomFirstName = "";
		String randomLastName = "";

		if(clanChoice == AuRaClan.XAELA && sex == Sex.MALE) {
			randomFirstName = xaelaMNames.get(rand.nextInt(xaelaMNames.size()));
			randomLastName = clanNames.get(rand.nextInt(clanNames.size()));
		} else if (clanChoice == AuRaClan.XAELA && sex == Sex.FEMALE) {
			randomFirstName = xaelaFNames.get(rand.nextInt(xaelaFNames.size()));
			randomLastName = clanNames.get(rand.nextInt(clanNames.size()));
		} else if (clanChoice == AuRaClan.RAEN && sex == Sex.MALE) {
			randomFirstName = raenMNames.get(rand.nextInt(raenMNames.size()));
			randomLastName = familyNames.get(rand.nextInt(familyNames.size()));
		} else {
			randomFirstName = raenFNames.get(rand.nextInt(raenFNames.size()));
			randomLastName = familyNames.get(rand.nextInt(familyNames.size()));
		}
		return randomFirstName + " " + randomLastName;
	}

	@Override
	public void printClanMenu() {

	}

	public AuRa() {
		super();
		this.name = "Au Ra";
		this.walkingSpeed = 30;
		this.description = "The Au Ra hail from the east, and are marked by their scales and horns. These people have a stark difference in height between the the males and females of the species. The males tend to be much taller than the females and many other races, while the females on average are shorter than many of the other races. The dark scaled Xaela are nomads who travel the Azim Steppe and have developed a wide variety of customs which change from tribe to tribe. The light scaled Raen live largely integrated into modern society, giving up their nomadic ways for peaceful coexistence with the other races.";
	}
	protected void raceStats() {
		addBonus(Stat.WISDOM, 2);
	}

	public void pickClan(String clan) {
		startingStats();
		initialRaceBonuses.put(Stat.WISDOM, 2);
		String clanChoice = clan.toUpperCase().trim();

		if(clanChoice.equals("RAEN") || clanChoice.equals("1")) {
			this.clanChoice = AuRaClan.RAEN;
		} else if(clanChoice.equals("XAELA") || clanChoice.equals("2")) {
			this.clanChoice = AuRaClan.XAELA;
		} else {
			System.out.println("Invalid clan choice");
			return;
		}
		raceStats();
		clanBonuses();
	}
	
	@Override
	public void clanBonuses() {
		if (clanChoice == AuRaClan.RAEN) {
			addBonus(Stat.CHARISMA, 1);
		} else if (clanChoice == AuRaClan.XAELA) {
			addBonus(Stat.STRENGTH, 1);
		}
	}

	@Override
	public ArrayList<PlayerChoices> raceOptions() {
		return null;
	}

	@Override
	public void chosenVariables(String input) {

	}
}
