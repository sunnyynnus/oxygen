package junk;
import junk.Link;

public class LinkList<T> {

	public Link<T> first;
	public Link<T> last;
	public LinkList()
{
		first=null;
		last =null;
	}
	
	
	public boolean isEmpty()
	{
		return (first==null);
	}
	
	public void insertFirst(T num)
	{
		Link<T> newLink =new Link<>(num);
		newLink.next=first;
		first=newLink;
	}//insertFirst
	
	public void displayLinkList()
	{
		System.out.println("***********LinkList start *******");
		Link<T> current=first;
		while(current !=null)
		{
		
			System.out.println("val= "+current.getNum());
			current=current.next;
		}
		System.out.println("***********LinkList end *******");
	}
	
	public  void reverseAltNodeAndAddAtEnd()
	{
		if(first!=null)
		{
			Link<T> current=first;
			LinkList<T> tempList=new LinkList<>();
			while(current.next!=null)
			{
				
				tempList.insertFirst(current.next.getNum());;
				
				current.next=current.next.next;
				
				current=current.next;
				if(current==null)
					break;
			}
			
			//ptr at the end
			current=first;
			while(current.next!=null)
			{
				current=current.next;
			}
			
			current.next=tempList.first;
			tempList=null;
		}//if
	}
	
	public  void reverseAltNodeAndAddAtEndEff()
	{
		if(first!=null && first.next !=null && first.next.next !=null )
		{
			Link<T> oCurrent=first;
			Link<T> eCurrent=first.next;
			
			oCurrent.next=oCurrent.next.next;
			oCurrent=oCurrent.next;
			eCurrent.next=null;
			
			while(oCurrent!=null && oCurrent.next !=null)
			{
				Link<T> tempOLink=oCurrent.next.next;
				oCurrent.next.next=eCurrent;
				eCurrent=oCurrent.next;
				oCurrent.next=tempOLink;
			
				if(tempOLink !=null)
				{
					oCurrent=tempOLink;
				}
			
			}//while
			
				oCurrent.next=eCurrent;
			
			
		}//if
	}
	
	public void swapNodeElements()
	{
		
		if(first!=null && first.next !=null )
		{
			Link<T> oCurrent=first;
			Link<T> eCurrent=first.next;
			first=eCurrent;
			Link<T> temp=null;
			while(true)
			{
				
				oCurrent.next=oCurrent.next.next;
				
				eCurrent.next=oCurrent;
				temp=oCurrent;
				oCurrent=oCurrent.next;
				if(oCurrent!=null)
				{
					eCurrent=oCurrent.next;
				}
				else
					break;
				if(oCurrent.next !=null)
				{
					temp.next=oCurrent.next;
				}
				else
					break;
				
			}
		}
		
	}
	
	public void removeDuplicates()
	{
		Link<T> outerCurrent=first;
		
		if(outerCurrent ==null || outerCurrent.next ==null)
			System.out.println("no dup");
		else
		{
			Link<T> current=null;
			//Link temp=null;
			Link<T> previous=null;
			while(outerCurrent !=null)
			{
				current=outerCurrent;
				//temp=outerCurrent;
				previous=current;
				current=current.next;
				while(current!=null)
				{
					if(current.getNum()==outerCurrent.getNum())
						previous.next=current.next;
					else
						previous=current;
					current=current.next;
				}
				outerCurrent=outerCurrent.next;
			}
		}
	}//removeDup
	
	public T findNthToLast(int n)
	{
		Link<T> temp=null;
		Link<T> current=first;
		for(int i=1;i<n;i++)
		{
			if(current!=null)
				current=current.next;
			else
				System.out.println("given number has exceeded the linked list length");
		}
		temp=first;
		while(current.next!=null)
		{
			current=current.next;
			temp=temp.next;
		}
		
		return temp.getNum();
	}
	
	/**
	 * Reverse linked list
	 */
	public void reverseNode()
	{
		reverseNodeRec(null,first);
	}
	
	/**
	 * ___  ___  ___
	 * P    C    Temp
	 */
	private void reverseNodeRec(Link<T> previous, Link<T> current)
	{
		if(current==null)
			return;
				
		Link<T> temp=current.next;
		current.next=previous;
		
		first=current;
		reverseNodeRec(current, temp);
		
	}//reverse
	
	/**
	 * not working properly
	 * @param k
	 */
	public void reverseNodeAtKIntervals(int k)
	{
		
		recursiveReverseAtKIntervals(null,first,k);
	}
	
	/**
	 *  not working
	 * @param previous
	 * @param current
	 * @param k
	 */
	private void recursiveReverseAtKIntervals(Link<T> previous,Link<T> current, int k)
	{
		int count=0;
		Link<T> temp=null;
		Link<T> Next=null;
		while(count<k && current !=null)
		{
			Next=current.next;
			//reverse iteratively
			count++;
			
		}//while
		//recursiveReverseAtKIntervals(temp,Next,k);
		
	}
	
	public void reverseLinkedListIter()
	{
		if(first !=null && first.next!=null) // nothing to do if size<2
	    	{
	        	Link<T> current=first;
	        	Link<T> previous=current;
	        	current=current.next;
	        	Link<T> temp=current.next;
	        	current.next=previous;
	        	previous.next=null;
	        
	        	while(true)
	        	{
	            		previous=current;
	            		current=temp;
	            		if(temp==null)
	            		{
	            			first=previous;
	            			break;
	            		}
	            		temp=current.next;
	            		current.next=previous;
	        	}
	    
	    }
	}
	
	public void reverseLinkedListRec()
	{
		reverseLinkedListRec(null, first);
	}

	private void reverseLinkedListRec(Link<T> previous, Link<T> current)
	{
	    
	    	if(current==null)
	    		return;
	   
	        Link<T> temp=current.next;
	        current.next=previous;
	        first=current;
	        reverseLinkedListRec(current, temp);
	   
	    
	   
	}
	
	public void insertLast(T num)
	{
		Link<T> temp= new Link<T>(num);
		temp.next=null;
		if(isEmpty())
		{
			first=temp;
			last=temp;
		}
		else
		{
			last.next=temp;
			last=last.next;
		}
		
		
	}

}//clss ends
