package BattleShip;

//I'm a cruiser and I should inherit a ship...

public class Cruiser extends Ship {

	public Cruiser(String name) {
		super(name);
	}
	
	@Override
	public char drawShipStatusAtCell(boolean isDamaged) {
		if(isDamaged)
		{
			return 'c';
		}
		else
		{
			return 'C';
		}
	}

	@Override
	public int getLength() {
		return 3;
	}

}