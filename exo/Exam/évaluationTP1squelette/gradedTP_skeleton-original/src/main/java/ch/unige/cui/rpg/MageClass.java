package ch.unige.cui.rpg;

public class MageClass extends GameCharacter implements CharClass{
    
    public MageClass(String name,
                int maxHP,
                int gold,
                ProtectionStack protectionSt,
                CharProfile pr
                ) {
        super(name,maxHP,gold,protectionSt,pr);
    }
    
    public CharProfile levelUp(CharProfile pr){

        //A completer...
        
        return new CharProfile();
    }

    @Override
    public int completeQuest(Quest q) {
        int questXp = super.completeQuest(q);
        CharProfile currentPr = super.getPr();

        // A completer ...

        return questXp;
    }
  
}