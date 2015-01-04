package junk;
import junk.LinkList;

public class LinkListIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList<Integer> firstLL=new LinkList<>();
		createList1(firstLL);
		LinkList<Integer> secondLL=new LinkList<>();
		createList2(secondLL);
		firstLL.displayLinkList();
		secondLL.displayLinkList();
		LinkList<Integer> newLL=new LinkList<Integer>();
	
		RecLinkedListIntersection(newLL,firstLL.first, secondLL.first);
		newLL.displayLinkList();
	}
	/**
	 * 
	 * @param firstPtr
	 * @param secondPtr
	 * @return
	 */
	public static LinkList<Integer> LinkedListIntersection(Link<Integer> firstPtr, Link<Integer> secondPtr)
	{
	  //  Link temp=null;
	   	 LinkList<Integer> newLL= new LinkList<>();
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
	
	public static LinkList<Integer> RecLinkedListIntersection(LinkList<Integer> newLL, Link<Integer> firstPtr, Link<Integer> secondPtr)
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
	
	private static void createList1(LinkList<Integer> lList)
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
	private static void createList2(LinkList<Integer> lList)
	{

	
		lList.insertFirst(8);
		lList.insertFirst(5);
		lList.insertFirst(4);
		lList.insertFirst(2);
		lList.insertFirst(1); 
	}
}
