package careercup;

public class HanoiTowers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doHanoiTowers(6, 'A', 'B', 'C');
	}

	public static void doHanoiTowers(int count, char s, char i, char d)
	{
	    if(count==1)
	    {
	        System.out.println("Move disk 1 from "+s+" to "+d);
	        return;    
	    }
	    doHanoiTowers(count-1, s, d, i);
	    System.out.println("Move disk "+count +" from "+s+" to "+d);
	    doHanoiTowers(count-1, i, s, d);
	    

	}
}
