public class Hero{
	private String name;
	private int currentHP;
	private final int STARTING_HP = 8;

	private final int MIN_DAMAGE = 1;
	private final int MAX_DAMAGE = 4;

	// Phase 3
	private ItemList inventory = new ItemList();

	public Hero(){
		currentHP = STARTING_HP;
		name = GameData.getRandomName();
		inventory = new ItemList();
	}
	public Hero(String name, int currentHP){
		this.name = name;
		this.currentHP = currentHP;
	}

	public String getName(){
			return name;
	}

	public int getHP(){
		return currentHP;
	}

	public String toString(){
		String s = "-----------------\n";
		s += "Current Hero: "+ name + "\n";
		s += "Current HP: " + currentHP + "\n";
		s += "-----------------\n";
		return s;
	}

	// Phase 3
	public void collectItem(Item i){
		inventory.addItem(i);
	}

	public String getItemsCollected(){
		return inventory.toString();
	}

	// Phase 5
	// k. Roll Damage
	public int damageDealt(){
		return GameData.randomRoll(MIN_DAMAGE, MAX_DAMAGE);
	}

	// l. bonus
	public int damageBonus(){
		return inventory.itemCount();
	}

	public void takeDamage(int damageAmount){
		currentHP -= damageAmount;
	}

}