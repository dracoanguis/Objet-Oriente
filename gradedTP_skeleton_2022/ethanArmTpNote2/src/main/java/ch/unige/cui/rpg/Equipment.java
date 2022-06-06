package ch.unige.cui.rpg;
import java.util.ArrayList;

public interface Equipment extends ArenaItem{
    
    public boolean equip(Player p, ArrayList<? extends ArenaItem> arenaInventory);
    public boolean unEquip(Player p, ArrayList<? super ArenaItem> arenaInventory);
}
