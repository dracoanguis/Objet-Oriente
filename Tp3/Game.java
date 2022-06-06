import ch.unige.cui.rpg.Armor;
import ch.unige.cui.rpg.Character;
import ch.unige.cui.rpg.Damage;
import ch.unige.cui.rpg.ProtectionStack;
import ch.unige.cui.rpg.Quest;

public class Game{
	public static void main(String[] args){
		ProtectionStack naked = new ProtectionStack(null, null);
		Armor chainMail = new Armor("chainMail", 100, 10, 10, 100, 50, 300);
		ProtectionStack basic = new ProtectionStack(chainMail.clone(), null);
		Character Lancelot = new Character("Lancelot Du Lac",150,naked);
		Character Arthur = new Character("Arthur Pendragon", 300, basic);
		Character Perceval = new Character("Perceval", 100, naked);

		Damage svat = new Damage(200, 0, 0, 0);
		System.out.println(String.format("Svat total dmg: %d", svat.getDamage()));
		Arthur.wound(svat);
		System.out.println("Grosse svat dans Arthour");
		System.out.println(Arthur.toString());
		Damage magicSvat = new Damage(0, 100, 0, 0);
		System.out.println("Grosse magic svat dans Arthour");
		Arthur.wound(magicSvat);
		System.out.println(Arthur.toString());

		System.out.println(svat.hashCode());


	}
}