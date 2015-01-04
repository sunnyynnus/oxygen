package junk;

public class Link<T> {

	private T num;
	public Link<T> next;
	public Link(){}
	public Link(T val)
	{
		num=val;
	}
	public T getNum() {
		return num;
	}
	public void setNum(T num) {
		this.num = num;
	}
	
	public void diplayLink()
	{
		System.out.println("num= "+num);
		
	}
}
