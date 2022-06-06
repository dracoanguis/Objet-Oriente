package ch.unige.cui.rpg;

public class MagicalShield implements Protection{
    private final int magicalProtection;
    private final int weight;
    
    
    public int getWeight() {
        return weight;
    }

    public MagicalShield(int magicalProtection,int weight){
        this.magicalProtection=magicalProtection;
        this.weight=weight;
    }

    
    public Damage absorb(Damage dmg) {
        //magical shield only absorbs magical damage
        return new Damage(dmg.getPhysical(),dmg.getMagical()-magicalProtection,dmg.getElectrical(),dmg.getFire());
    }

    
}