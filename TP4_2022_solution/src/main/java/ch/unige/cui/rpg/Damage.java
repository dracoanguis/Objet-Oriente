package ch.unige.cui.rpg;

public class Damage {
    private final int physical;
    private final int magical;
    private final int electrical;
    private final int fire;
    public Damage(int physical, int magical, int electrical, int fire){
        this.physical=physical;
        this.magical=magical;
        this.electrical=electrical;
        this.fire=fire;
    }
    public int getPhysical(){
        return physical;
    }
    public int getMagical(){
        return magical;
    }
    public int getElectrical(){
        return electrical;
    }
    public int getFire(){
        return fire;
    }
}