package ch.unige.cui.rpg;

public class Damage {
    private final int physical;
    private final int magical;

    public Damage(int physical, int magical){
        this.physical=physical;
        this.magical=magical;
    }
    public int getPhysical(){
        return physical;
    }
    public int getMagical(){
        return magical;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        if (magical != other.magical)
            return false;
        if (physical != other.physical)
            return false;
        return true;
    }
}