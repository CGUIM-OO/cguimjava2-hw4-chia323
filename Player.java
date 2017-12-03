import java.util.ArrayList;

public class Player {

	
	private String name; //玩家姓名
	private int chips; // 玩家所有的籌碼
	private int bet; // 玩家此局下注的籌碼
	private ArrayList<Card> oneRoundCard;
	public Player(String name, int chips)
	{
		this.name = name;
		this.chips = chips;
	}
	public String getName()
	{
		return name;
	}
	public int makeBet()
	{
		bet = 1;
		if(bet<1)
		return 0;
		else
		return bet;
			
	}
	public void setOneRoundCard(ArrayList cards)
	{
		oneRoundCard = new ArrayList<Card>();
		oneRoundCard = cards;
	}
	public boolean hitMe()
	{
		if(  getTotalValue()<=16)
			return true;
		else
			return false;
			
	}
	public int getTotalValue()
	{
		int value = 0;
		for(int i=0 ; i< oneRoundCard.size();i++)
		{
			value += ((Card)oneRoundCard.get(i)).getRank();
		}
		return value;
	}
	public int getCurrentChips()
	{
		return chips;
	}
	public void increaseChips (int diff) 
	{
		chips+=diff;
	}
	public void sayHello()
	{
		System.out.println("Hello, I am " + name + "." );
		System.out.println("I have " + chips + " chips." );
	}
}
