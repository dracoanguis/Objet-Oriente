package ch.unige.cui.rpg;


public class FireProofLeatherVest implements Protection{
    private final Damage protectionValues;
    private final int weight;


    public FireProofLeatherVest(int physicalProt,int fireProt, int weight){
        this.protectionValues=new Damage(physicalProt,0,0,fireProt);
        this.weight=weight;
    }

    
    public int getWeight() {
        return weight;
    }
    
    public Damage absorb(Damage dmg) {
        //fireproof leather vest protects a little bit from physical
        //and a lot from fire
        return new Damage(dmg.getPhysical()-protectionValues.getPhysical(),
                        dmg.getMagical(),
                        dmg.getElectrical(),
                        dmg.getFire()-protectionValues.getFire());
    }


    public Damage getProtectionValues() {
        return protectionValues;
    }


}