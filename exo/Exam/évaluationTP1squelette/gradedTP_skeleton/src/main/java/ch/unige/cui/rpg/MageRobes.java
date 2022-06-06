package ch.unige.cui.rpg;

public class MageRobes implements Protection {
    private final Damage protectionValues;
    private final int weight;

    public int getWeight() {
        return weight;
    }

    public MageRobes(int magicalProtec, int weight){
        this.weight = weight;
        this.protectionValues = new Damage(0,magicalProtec,0,0);
    }

    public Damage absorb(Damage dmg) {
        return new Damage(dmg.getPhysical(),dmg.getMagical()-protectionValues.getMagical(),dmg.getElectrical(),dmg.getFire());
    }

    public Damage getMageRobesProt() {
        return protectionValues;
    }

}
