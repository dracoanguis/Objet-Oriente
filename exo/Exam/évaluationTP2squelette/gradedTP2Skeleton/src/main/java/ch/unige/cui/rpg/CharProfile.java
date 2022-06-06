package ch.unige.cui.rpg;

public class CharProfile {
    private final int intellect;
    private final int strength;
    private final int stamina;

    public CharProfile(int intellect, int strength, int stamina) {
        this.intellect = intellect;
        this.strength = strength;
        this.stamina = stamina;
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

    public CharProfile addPr(CharProfile pr){
        return new CharProfile(intellect+pr.getIntellect(), strength+pr.getStrength(), stamina+ pr.getStamina());
    }

    public CharProfile subPr(CharProfile pr){
        return new CharProfile(intellect-pr.getIntellect(), strength-pr.getStrength(), stamina-pr.getStamina());
    }


    @Override
    public String toString() {
        return "CharProfile [intellect=" + intellect +  ", stamina=" + stamina + ", strength="+ strength ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + intellect;
        result = prime * result + stamina;
        result = prime * result + strength;
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
        if (stamina != other.stamina)
            return false;
        if (strength != other.strength)
            return false;
        return true;
    }  

}