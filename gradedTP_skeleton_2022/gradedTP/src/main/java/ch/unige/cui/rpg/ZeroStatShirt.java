package ch.unige.cui.rpg;

public class ZeroStatShirt implements Protection {
    private final Damage mageRobesProt = new Damage(0,0,0,0);
    private final int weight = 0;

    
    public int getWeight() {
        return weight;
    }
    
    public Damage absorb(Damage dmg) {
        //absorbs nothing
        return new Damage(dmg.getPhysical(), 
                        dmg.getMagical(),
                        dmg.getElectrical(),
                        dmg.getFire());
    }

}