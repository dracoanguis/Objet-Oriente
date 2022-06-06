package ch.unige.cui.rpg;

public class FireProofLeatherVest implements Protection{
    private final int fireProtection;
    private final int physicalProtection;
    private final int weight;


    public FireProofLeatherVest(int fireProtection, int physicalProtection, int weight){
        this.fireProtection=fireProtection;
        this.physicalProtection=physicalProtection;
        this.weight=weight;
    }

    
    public int getWeight() {
        return weight;
    }
    
    public Damage absorb(Damage dmg) {
        //fireproof leather vest protects a little bit from physical
        //and a lot from fire
        return new Damage(dmg.getPhysical()-physicalProtection, dmg.getMagical(), dmg.getFire()-fireProtection);
    }


}
