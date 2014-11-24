package linkListEx;

public class FindNthToLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList lList=new LinkList();
		
		createList(lList);
		///////linklist created
		lList.displayLinkList();
		System.out.println("**********************");

		Link result=lList.findNthToLast(14);
		if(result!=null)
			System.out.println("num value= "+result.getNum());

	}

	private static void createList(LinkList lList)
	{
		lList.insertFirst(9);
		lList.insertFirst(9);
		lList.insertFirst(4);
		lList.insertFirst(7);
		lList.insertFirst(6);
		lList.insertFirst(5);
		lList.insertFirst(4);
		lList.insertFirst(7);
		lList.insertFirst(9);
		lList.insertFirst(9);
		lList.insertFirst(9);
		lList.insertFirst(9);
		lList.insertFirst(9);
		lList.insertFirst(4);
		lList.insertFirst(1);
		lList.insertFirst(9);	
		lList.insertFirst(9);
		lList.insertFirst(9);
		
	}//createlist
}
