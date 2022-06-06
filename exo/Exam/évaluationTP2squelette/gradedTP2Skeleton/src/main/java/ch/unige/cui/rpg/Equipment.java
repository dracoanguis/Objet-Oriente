package ch.unige.cui.rpg;
import java.util.ArrayList;

public interface Equipment extends Item{
    public boolean equip(Player p, ArrayList<? extends Item> arenaInventory);
    public boolean unEquip(Player p, ArrayList<? super Item> arenaInventory);
}