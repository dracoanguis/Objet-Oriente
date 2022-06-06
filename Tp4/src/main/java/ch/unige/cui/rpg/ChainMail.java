package ch.unige.cui.rpg;

public class ChainMail implements Protection {
    private int armorValue;
    private int weight;

    
    public int getWeight() {
        return weight;
    }

    public ChainMail(int armorValue, int weight){
        this.armorValue=armorValue;
        this.weight=weight;
    }

    
    public Damage absorb(Damage dmg) {
        //chain mail only absorbs physical damage
        return new Damage(dmg.getPhysical()-armorValue, dmg.getMagical(), dmg.getElectrical(),dmg.getFire());
    }

    
}