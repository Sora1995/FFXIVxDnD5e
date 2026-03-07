package main;
import java.util.List;

public class PlayerChoices {
    private String question;
    private List<String> equipmentOptions;

    public PlayerChoices(String question, List<String> equipmentOptions) {
        this.question = question;
        this.equipmentOptions = equipmentOptions;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public List<String> getEquipmentOptions() {
        return equipmentOptions;
    }
    public void setEquipmentOptions(List<String> equipmentOptions) {
        this.equipmentOptions = equipmentOptions;
    }

}
