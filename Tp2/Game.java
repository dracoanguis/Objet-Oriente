import ch.unige.cui.rpg.Character;
import ch.unige.cui.rpg.Quest;

public class Game{
	public static void main(String[] args){
		Character Lancelot = new Character("Lancelot Du Lac",150,40);
		Character Arthur = new Character("Arthur Pendragon", 300, 100);
		Character Perceval = new Character("Perceval", 100, 20);

		Quest Graal = new Quest("Find the Holy Graal!", 3000);

		Arthur.startQuest(Graal);
		Lancelot.startQuest(Graal);
		Perceval.startQuest(Graal);

		System.out.println(Arthur.toString());
		Arthur.accomplishQuest();
		System.out.println(Arthur.toString());

	}
}