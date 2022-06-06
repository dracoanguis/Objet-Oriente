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
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + electrical;
        result = prime * result + fire;
        result = prime * result + magical;
        result = prime * result + physical;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Damage other = (Damage) obj;
        if (electrical != other.electrical)
            return false;
        if (fire != other.fire)
            return false;
        if (magical != other.magical)
            return false;
        if (physical != other.physical)
            return false;
        return true;
    }
}