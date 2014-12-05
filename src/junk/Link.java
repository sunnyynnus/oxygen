package linkListEx;

public class Link {

	private int num;
	public Link next;
	public Link(){}
	public Link(int val)
	{
		num=val;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public void diplayLink()
	{
		System.out.println("num= "+num);
		
	}
}
