package BattleShip;
import java.util.ArrayList;

public class GameBoard
{
	int rowCount = 10;
	int colCount = 10;
	
	final String LINE_END = System.getProperty("line.separator"); 
	
	ArrayList< ArrayList< Cell > > cells;
	ArrayList< Ship > myShips = new ArrayList<Ship>();
	
	public GameBoard( int rowCount, int colCount )
	{
		this.rowCount = rowCount;
		this.colCount = colCount;
		
		//create the 2D array of cells
		for (int row = 0; row < this.rowCount; row++)
		{
			for(int col = 0; col < this.colCount; col++)
			{
		//		cells.add(this.rowCount,);  //THIS IS STILL BROKE
			}
		}
	}
	
	public String draw()
	{

		//draw the entire board... I'd use a StringBuilder object to improve speed
		//remember - you must draw one entire row at a time, and don't forget the
		//pretty border...
		StringBuilder board = new StringBuilder();
		
		for (int i = 0; i < rowCount; i++)
		{
			if (i==0 || i == (rowCount - 1))
				board.append("------------");
			else
				board.append("|          |");
		}
		
		return board.toString();
		
	}
	
	//add in a ship if it fully 1) fits on the board and 2) doesn't collide w/
	//an existing ship.
	//Returns true on successful addition; false, otherwise
	public boolean addShip( Ship s , Position sternLocation, HEADING bowDirection )
	{			
		
		int shipLength = 0;
		
		if (s.toString() == "Cruiser")
		{
			shipLength = 3;
		}
		else if (s.toString() == "Destroyer")
		{
			shipLength = 2;
		}
		else {
			System.out.println("Invalid ship.");
			return false;
		}
			
		if(sternLocation.x < 10 || sternLocation.y < 10)
		{
		
			String dir = bowDirection.toString();
			if(dir == "NORTH")
			{
			//	while(shipLength>0)
				sternLocation.x =+ shipLength - 1;
				return true;
			}	
			else if(dir == "SOUTH")
			{
				sternLocation.x =- shipLength - 1;
				return true;
			}
			else if(dir == "EAST")
			{
				sternLocation.y =+ shipLength - 1;
				return true;
			}
			else if(dir == "WEST")
			{
				sternLocation.y =- shipLength - 1;
				return true;
			}
			else 
			{
				System.out.println("Cannot add ship to board.");
				return false;
			}
			
		}
		
		else
			System.out.println("Invalid input: ship off gameboard.");
		return false;

	}
	
	//Returns A reference to a ship, if that ship was struck by a Missile.
	//The returned ship can then be used to print the name of the ship which
	//was hit to the player who hit it.
	//Ensure you handle missiles that may fly off the grid
	public Ship fireMissile( Position coordinate )
	{
	//	myShips.
	//	if( Ship.this.position.contains(coordinate) == true )
	//		Ship.this.drawShipStatusAtCell(true);
		return null; //for the time being
	}
	
	//Here's a simple driver that should work without touching any of the code below this point
	public static void main( String [] args )
	{
		System.out.println( "Hello World" );
		GameBoard b = new GameBoard( 10, 10 );	
		System.out.println( b.draw() );
		
		Ship s = new Cruiser( "Cruiser" );
		if( b.addShip(s, new Position(3,6), HEADING.WEST ) )
			System.out.println( "Added " + s.getName() + "Location is " );
		else
			System.out.println( "Failed to add " + s.getName() );
		
		s = new Destroyer( "Destroyer" );
		if( b.addShip(s, new Position(3,5), HEADING.NORTH ) )
			System.out.println( "Added " + s.getName() + "Location is " );
		else
			System.out.println( "Failed to add " + s.getName() );
		
		System.out.println( b.draw() );
		
		b.fireMissile( new Position(3,5) );
		System.out.println( b.draw() );
		b.fireMissile( new Position(3,4) );
		System.out.println( b.draw() );
		b.fireMissile( new Position(3,3) );
		System.out.println( b.draw() );
		
		b.fireMissile( new Position(0,6) );
		b.fireMissile( new Position(1,6) );
		b.fireMissile( new Position(2,6) );
		b.fireMissile( new Position(3,6) );
		System.out.println( b.draw() );
		
		b.fireMissile( new Position(6,6) );
		System.out.println( b.draw() );
	}

}
