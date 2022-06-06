package ch.unige.cui.rpg;

public class WarriorClass extends GameCharacter implements CharClass {

    public WarriorClass(String name,
                int maxHP, 
                long gold, 
                ProtectionStack protectionSt,
                CharProfile pr
                ){
                super(name,maxHP,gold,protectionSt,pr);
    }

    public CharProfile levelUp(CharProfile pr){
        if (pr.getLvl() < LevelClass.getMaxLvl()){
            if ((pr.getLvl()+1)%3 == 0){
                System.out.println(new CharProfile(pr.getIntellect(),pr.getStrength()*2,pr.getStamina()+1,0,pr.getLvl()+1).toString());
                return new CharProfile(pr.getIntellect(),pr.getStrength()*3,pr.getStamina()+1,0,pr.getLvl()+1);
            }
            System.out.println(new CharProfile(pr.getIntellect(),pr.getStrength()+1,pr.getStamina()+4,0,pr.getLvl()+1).toString());
            return new CharProfile(pr.getIntellect(),pr.getStrength()+1,pr.getStamina()+4,0,pr.getLvl()+1);
        } 
        return pr;
    }


    @Override
    public int completeQuest(Quest q) {
        int nXp = super.completeQuest(q);
        this.pr = new CharProfile(this.pr.getIntellect(),this.pr.getStrength(),this.pr.getStamina(),this.pr.getXp()+nXp,this.pr.getLvl());
        if (this.pr.getXp() >= LevelClass.getXPToNextLvl(pr.getLvl()) ){
            this.pr = this.levelUp(this.pr);
        }
        return 0;
    }


}
