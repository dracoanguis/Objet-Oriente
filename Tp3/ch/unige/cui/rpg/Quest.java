package ch.unige.cui.rpg;

public class Quest{

	final String description;
    final int reward;
    final Item rewardItem;

    public Quest(String description, int reward) throws IllegalArgumentException {
        if (description == null || description.trim().isEmpty()){
            throw new IllegalArgumentException("description should not be empty");
        }
        if (reward < 0){
            throw new IllegalArgumentException("reward should not be negative");
        }

        this.description = description;
        this.reward = reward;
        this.rewardItem = null;
    }

    public Quest(String description, int reward, Item rewardItem) throws IllegalArgumentException {
        if (description == null || description.trim().isEmpty()){
            throw new IllegalArgumentException("description should not be empty");
        }
        if (reward < 0){
            throw new IllegalArgumentException("reward should not be negative");
        }

        this.description = description;
        this.reward = reward;
        this.rewardItem  = rewardItem;
    }

    public String toString(){
        String itemName = "None";
        if (rewardItem != null){
            itemName = this.rewardItem.getName();
        }
        return (String.format("Description: %s\nReward: %d Gold\tItem: %s",this.description,this.reward,itemName));
    }
}