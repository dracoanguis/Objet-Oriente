package ch.unige.cui.rpg;

public class Quest{

	final String description;
    final int reward;

    public Quest(String description, int reward) throws IllegalArgumentException {
        if (description == null || description.trim().isEmpty()){
            throw new IllegalArgumentException("description should not be empty");
        }
        if (reward < 0){
            throw new IllegalArgumentException("reward should not be negative");
        }

        this.description = description;
        this.reward = reward;
    }

    public String toString(){
        return (String.format("Description: %s\nReward: %d Gold",this.description,this.reward));
    }
}