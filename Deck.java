import java.util.ArrayList;
import java.util.Random;


	public class Deck 
	{
		

		private ArrayList<Card> cards; //�ŧiArrayList<Card> cards  private filed
		public ArrayList<Card> usedCards = new ArrayList<Card>() ; // �ŧiuseCards instance field �ù����
		private ArrayList<Card> openCard;
		public int nUsed; // �ŧinUsed instance field constructor:nDeck 
		
			 
			public Deck(int nDeck){
	
				cards = new ArrayList<Card>();
				usedCards = new ArrayList<Card>(); 
				openCard = new ArrayList<Card>();
	//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
	//Hint: Use new Card(x,y) and 3 for loops to add card into deck
	//Sample code start
	//Card card=new Card(1,1); ->means new card as clubs ace
	//cards.add(card);
	//Sample code end
	
				for( int i = 1 ; i <= nDeck ; i++ ) // �n���X(nDeck)�ƵP 
				{
					for( int x = 1 ; x <= 4 ; x++ ) //���(Clubs=1, Diamonds=2, Hearts=3, Spades=4)
					{
						for( int k = 1 ;  k <= 13 ; k++ ) //�P�W������(1~13)
						{
		    		
		    		
							if( x == 1 ) //���⬰club
							{
								Card card = new Card ( Card.Suit.Club , k);  //new �@�� clubs clubs �b���Ӷ��Ǳq1�ƨ�13 
								cards.add(card); // ��clubs ���L�X��
							}
							if( x == 2 ) //���⬰Diamond
							{
								Card card = new Card ( Card.Suit.Diamond , k); // new �@�� diamond �ë��Ӷ��Ǳq1�ƨ�13
								cards.add(card); // ��Diamond ���L�X��
							}
							if( x == 3 ) //���⬰Heart
							{
								Card card = new Card ( Card.Suit.Heart , k); // new �@�� heart �ë��Ӷ��Ǳq1�ƨ�13
								cards.add(card); // ��Heart ���L�X��
							}
							if( x == 4 ) //���⬰Spade
							{
								Card card = new Card ( Card.Suit.Spade , k); // new �@�� spade �ë��Ӷ��Ǳq1�ƨ�13
								cards.add(card); // ��Spade ���L�X��
							}
		    	
		    		 
						}
					}
				}
				shuffle();
	}	

	//TODO: Please implement the method to print all cards on screen (10 points)

	public void printDeck()
    {
	//Hint: print all items in ArrayList<Card> cards, 
	//TODO: please implement and reuse printCard method in Card class (5 points)
	
		for (int n = 0 ; n < cards.size() ; n++)
		{
		 cards.get(n).printCard(); //
		}
	
    }

	public ArrayList<Card> getAllCards()
	{
	 return cards;
    }

	public Card getOneCard(boolean isOpened)
    {
	
		if (cards.size()==0)
		{
		shuffle();
		if(isOpened)  //�ιL���P�n�[�b���}���Ƹ̭�
		{
			openCard.add(cards.get(nUsed));
		}
		
		}
	
	Card drawer = cards.get(0);
	cards.remove(0);
	usedCards.add(drawer);
	nUsed+=1;
	return drawer;
	
    }

	public void shuffle() //��o�X�h���P(useCards)���^�h
	{
		
		for (int i = 0 ; i < nUsed ; i++ )
		cards.add(usedCards.get(i));
		
		for(int i = 0 ; i<1000 ; i ++ )//�n�~�X���P
		{

			Random md = new Random(); // �H�����
			int j = md.nextInt(cards.size()); // ������Ʀr����W�L(card.size���W�L���Ʀr) J ���ӬO���N��m
			Card temp = cards.get(j);  //��J��i�htemp�̭�
			cards.remove(cards.get(j)); //��j���ӵP��������m����
			cards.add(temp); //��temp���ӵP��i�h�쥻�Q��X�Ӫ���m
		}
		
		nUsed = 0; //
		usedCards.clear(); //
		openCard.clear();
	}

	public ArrayList<Card> getOpenedCard()
	{
		return openCard;
	}
	
	
	
}

