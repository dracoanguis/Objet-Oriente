package ch.unige.cui.rpg;
import java.lang.Math; 

public class LevelClass {
    //the max possible level a character can have
    private final static int maxLvl = 10;

    public static int getMaxLvl() {
        return maxLvl;
    }

    public static int getXPToNextLvl(int currLvl) {
        return 40*currLvl*currLvl + 360*currLvl;
    }
}
