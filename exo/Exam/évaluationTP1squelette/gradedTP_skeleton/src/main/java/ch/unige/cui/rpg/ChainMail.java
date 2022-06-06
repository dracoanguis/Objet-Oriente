package ch.unige.cui.rpg;

public class ChainMail implements Protection {
    private final Damage protectionValues;
    private final int weight;

    
    public int getWeight() {
        return weight;
    }

    public ChainMail(int physicalProt, int weight){
        protectionValues = new Damage(physicalProt,0,0,0);
        this.weight=weight;
    }

    
    public Damage absorb(Damage dmg) {
        //chain mail only absorbs physical damage
        return new Damage(dmg.getPhysical()-protectionValues.getPhysical(), 
                    dmg.getMagical(), 
                    dmg.getElectrical(),
                    dmg.getFire());
    }

    public Damage getProtectionValues() {
        return protectionValues;
    }

    
}