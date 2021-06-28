public class Item{
	private String itemName;

	public Item(){
		itemName = GameData.getRandomItemName();
	}
	public Item(String itemName){
		this.itemName = itemName;
	}

	public String toString(){
		return itemName;
	}

}