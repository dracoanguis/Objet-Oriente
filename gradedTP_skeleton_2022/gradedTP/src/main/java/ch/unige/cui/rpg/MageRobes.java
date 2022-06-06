package ch.unige.cui.rpg;

public class MageRobes implements Protection {
    private final Damage protectionValues;
    private final int weight;

    
    public int getWeight() {
        return weight;
    }

    public MageRobes(int magicalProt, int electricProt, int weight){
        this.weight = weight;
        this.protectionValues = new Damage(0,magicalProt,electricProt,0);
    }

    
    public Damage absorb(Damage dmg) {
        return new Damage(dmg.getPhysical(),dmg.getMagical()-this.protectionValues.getMagical(),
                        dmg.getElectrical()-this.protectionValues.getElectrical(),0);
    }
	
	public Damage getMageRobesProt(){
		return this.protectionValues;
	}

}
