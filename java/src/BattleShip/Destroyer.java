package BattleShip;

//I'm a destroyer and I should inherit a ship...

public class Destroyer extends Ship {

	public Destroyer(String name) {
		super(name);
	}
	
	@Override
	public char drawShipStatusAtCell(boolean isDamaged) {
		if(isDamaged)
		{
			return 'd';
		}
		else
		{
			return 'D';
		}
	}

	@Override
	public int getLength() {
		return 2;
	}

}