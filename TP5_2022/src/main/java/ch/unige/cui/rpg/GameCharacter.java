package ch.unige.cui.rpg;

//-> interface
public interface GameCharacter{
    public final static int maxQuests = 10;
    public String getName();
    public int getLevel();
    public int getMaxHP();
    public int getCurrentHP();
    
    public void wound(Damage dmg);
    public void heal(Damage hp);
}
