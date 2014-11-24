package linkListEx;

public class AddNosInLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkList aList=new LinkList();
		int a[]={5,1,3};
		createList(aList,a);
	
		aList.displayLinkList();
		System.out.println("**********************");
	
		LinkList bList=new LinkList();
		int b[]={0};
		createList(bList,b);

		bList.displayLinkList();
		System.out.println("**********************");

		LinkList cList=new LinkList();
		addNosInGivenList(aList, bList, cList);
		cList.displayLinkList();
		
	}
	
	private static void createList(LinkList lList,int[] val)
	{
		for(int i=0;i<val.length;i++)
		lList.insertFirst(val[i]);
	
	}//cL

	private static LinkList addNosInGivenList(LinkList a,LinkList b,LinkList c)
	{
		Link currentA=a.first;
		Link currentB=b.first;
		Link currentC=c.first;
		int tempVal;
		boolean flag =false;
		Link tempLink=null;
		
		while(currentA!=null && currentB !=null)
		{
			tempVal=currentA.getNum()+currentB.getNum();
			if(flag)
			{
				tempVal+=1;
				flag=false;
			}//if flag
			if(tempVal>=10)
			{
				tempVal-=10;
				flag=true;
			}
			//copy the result in the new node
			tempLink=new Link(tempVal);
			if(currentC==null)
			{
				c.first=tempLink;
	  	        	currentC=tempLink;
			}
			else
			{	
				currentC.next=tempLink;
				currentC=currentC.next;
			}
			currentA=currentA.next;
			currentB=currentB.next;
				
		}//while
		
		while(currentA!=null)
		{
			tempVal=currentA.getNum();
			if(flag)
				tempVal+=1;
			tempLink=new Link(tempVal);
			currentC.next=tempLink;
			currentC=currentC.next;
			currentA=currentA.next;
		}
		
		while(currentB!=null)
		{
			tempVal=currentB.getNum();
			if(flag)
				tempVal+=1;
			tempLink=new Link(tempVal);
			currentC.next=tempLink;
			currentC=currentC.next;
			currentB=currentB.next;
		}
		
		return c;
	}
}
