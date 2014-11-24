package linkListEx;

public class LinkListIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList firstLL=new LinkList();
		createList1(firstLL);
		LinkList secondLL=new LinkList();
		createList2(secondLL);
		firstLL.displayLinkList();
		secondLL.displayLinkList();
		LinkList newLL=new LinkList();
	
		RecLinkedListIntersection(newLL,firstLL.first, secondLL.first);
		newLL.displayLinkList();
	}
	/**
	 * 
	 * @param firstPtr
	 * @param secondPtr
	 * @return
	 */
	public static LinkList LinkedListIntersection(Link firstPtr, Link secondPtr)
	{
	  //  Link temp=null;
	   	 LinkList newLL= new LinkList();
	    	while(firstPtr !=null && secondPtr !=null)
	    	{
	        	if(firstPtr.getNum()==secondPtr.getNum())
	        	{
	       		        newLL.insertLast(firstPtr.getNum());
	        		firstPtr=firstPtr.next;
	        		secondPtr=secondPtr.next;
	        	}
		        else if(firstPtr.getNum() < secondPtr.getNum())
		        {
	        		firstPtr=firstPtr.next;
	        	}
	        	else
	        		secondPtr=secondPtr.next;
	    	}
	    
	    	return newLL;
	}
	
	public static LinkList RecLinkedListIntersection(LinkList newLL, Link firstPtr, Link secondPtr)
	{
		if(firstPtr==null || secondPtr==null)
			return null;
		if(firstPtr.getNum()==secondPtr.getNum())
		{
			newLL.insertLast(firstPtr.getNum());
			RecLinkedListIntersection(newLL,firstPtr.next,secondPtr.next);
		}
		else if(firstPtr.getNum() < secondPtr.getNum())
	    	{
			RecLinkedListIntersection(newLL,firstPtr.next,secondPtr);
		}
	   	 else
	        	RecLinkedListIntersection(newLL,firstPtr,secondPtr.next);
		return newLL;
	}
	
	private static void createList1(LinkList lList)
	{

		lList.insertFirst(9);
		lList.insertFirst(8);
		lList.insertFirst(7);
		lList.insertFirst(6);
		lList.insertFirst(5);
		lList.insertFirst(2); 
		lList.insertFirst(2); 
		lList.insertFirst(1);		
		
	}
	private static void createList2(LinkList lList)
	{

	
		lList.insertFirst(8);
		lList.insertFirst(5);
		lList.insertFirst(4);
		lList.insertFirst(2);
		lList.insertFirst(1); 
	}
}
