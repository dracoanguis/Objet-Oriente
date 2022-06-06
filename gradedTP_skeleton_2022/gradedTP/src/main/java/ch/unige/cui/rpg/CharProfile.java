package ch.unige.cui.rpg;

public class CharProfile {
    private final int intellect;
    private final int strength;
    private final int stamina;
    
    private final int xp;
    private final int lvl;

    public CharProfile(int intellect, int strength, int stamina, int xp, int lvl) {
        this.intellect = intellect;
        this.strength = strength;
        this.stamina = stamina;
        this.xp = xp;
        this.lvl=lvl;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getStrength() {
        return strength;
    }

    public int getStamina() {
        return stamina;
    }

    public int getXp() {
        return xp;
    }

    public int getLvl() {
        return lvl;
    }

    @Override
    public String toString() {
        return "CharProfile [intellect=" + intellect + ", lvl=" + lvl + ", stamina=" + stamina + ", strength="
                + strength + ", xp=" + xp + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + intellect;
        result = prime * result + lvl;
        result = prime * result + stamina;
        result = prime * result + strength;
        result = prime * result + xp;
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
        CharProfile other = (CharProfile) obj;
        if (intellect != other.intellect)
            return false;
        if (lvl != other.lvl)
            return false;
        if (stamina != other.stamina)
            return false;
        if (strength != other.strength)
            return false;
        if (xp != other.xp)
            return false;
        return true;
    }  

}