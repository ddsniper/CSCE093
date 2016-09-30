package BattleShip;

public class Cell
{
	protected boolean struckByMissile = false;
	protected Ship ship = null;
	
	public Cell()
	{		
	}
	
	public boolean hasBeenStruckByMissile()
	{
		//had to add the this
		return this.struckByMissile; 
	}
	
	public void hasBeenStruckByMissile( boolean wasStruck )
	{	
		//had to add
		this.struckByMissile=wasStruck;
	}
	
	public char draw()
	{
		if( this.ship == null )
		{
			if( this.struckByMissile )
				return 'x';
			return ' ';
		}
		//a ship is at this cell
		return ship.drawShipStatusAtCell( this.struckByMissile );			
	}
	
	public Ship getShip() { return this.ship; }
	public void setShip( Ship s ) { this.ship = s; }

	public static void main(String[] args)
	{
	}

}
