package ch.unige.cui.rpg;

public class Damage {
    private final int physical;
    private final int magical;
    private final int fire;
    public Damage(int physical, int magical, int fire){
        this.physical=physical;
        this.magical=magical;
        this.fire=fire;
    }
    public int getPhysical(){
        return physical;
    }
    public int getMagical(){
        return magical;
    }
    public int getFire(){
        return fire;
    }

    @Override
    public String toString(){
	return "Damage: physical = "+String.valueOf(physical)+", "+String.valueOf(magical)+", "+String.valueOf(fire);

    }
}
