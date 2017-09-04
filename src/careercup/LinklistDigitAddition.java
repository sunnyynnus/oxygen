package careercup;

/*
	Add a digit to a number represented by linklist
	O(1) space
*/

public class LinklistDigitAddition{

	public static void main(String[] args){
		LinklistDigitAddition obj = new LinklistDigitAddition();
		Link head = populateLinklist1(); // 999
		print(obj.addDigitToLinklist(head, 4));
		
		head = populateLinklist2(); // 909
		print(obj.addDigitToLinklist(head, 9));
	}

	public Link addDigitToLinklist(Link head, int digit){
		if(head == null){
			return null;
		}

		int sum = head.data + carryOver(head.next, digit);
		head.data = sum % 10;
		if(sum > 9){
			Link newHead = new Link(1);
			newHead.next = head;
			return newHead;
		}

		return head;
	}

	private int carryOver(Link link, int digit){
		if(link == null){
			return digit;
		}

		int sum = link.data + carryOver(link.next, digit);
		link.data = sum%10;
		return sum/10;
	}

	private static class Link{
		int data;
		Link next;
		Link(int data){
			this.data = data;
		}
	}
	
	// ** test purpose**

	private static void print(Link head){
		while(head !=null){
			System.out.print(head.data + "\t");
			head = head.next;
		}
		System.out.println();
	}

	private static Link populateLinklist1(){
		Link head = new Link(9);
		head.next = new Link(9);
		head.next.next = new Link(9);
		return head;
	}

	private static Link populateLinklist2(){
		Link head = new Link(9);
		head.next = new Link(0);
		head.next.next = new Link(9);
		return head;
	}
}

