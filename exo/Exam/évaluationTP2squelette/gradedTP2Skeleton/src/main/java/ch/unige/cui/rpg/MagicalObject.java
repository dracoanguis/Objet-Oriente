package ch.unige.cui.rpg;
import java.util.ArrayList;

public class MagicalObject implements Equipment{

    private final CharProfile bonusStats;
    private final int weight;
    private static final MagicalObject EMPTY = new MagicalObject();
	
    public static MagicalObject empty(){
	    return EMPTY;
    }
 
    private MagicalObject(){
        this.bonusStats= new CharProfile(0, 0, 0);
        this.weight = 0;
    }

    public MagicalObject(CharProfile bonusStats, int weight ) {
        this.bonusStats = bonusStats;
        this.weight = weight;
    }

    public MagicalObject(int intellect, int strength, int stamina, int weight){
        this.bonusStats = new CharProfile(intellect, strength, stamina);
        this.weight = weight;
    }

    public CharProfile getBonusStats() {
        return bonusStats;
    }

    public boolean equip(Player p, ArrayList<Item> arenaInventory){
        return false;
    }

    public boolean unEquip(Player p, ArrayList<Item> arenaInventory){
        if(  ! (p.getMagicalObj() == EMPTY) ){
            p.setMagicalObj(EMPTY);
            p.setPr(p.getPr().subPr(bonusStats));
            arenaInventory.add( this );
            return true;
        }
        else {
            return false;
        }
    }
    
    public int getWeight(){
        return weight;
    }

    @Override
    public String toString() {
        return "MagicalObject [bonusStats=" + bonusStats + ", weight=" + weight + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bonusStats == null) ? 0 : bonusStats.hashCode());
        result = prime * result + weight;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MagicalObject other = (MagicalObject) obj;
        if (bonusStats == null) {
            if (other.bonusStats != null)
                return false;
        } else if (!bonusStats.equals(other.bonusStats))
            return false;
        if (weight != other.weight)
            return false;
        return true;
    }
}
