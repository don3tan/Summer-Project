import java.util.Comparator;
import java.util.Random;

public class quickSort {
	
	private test[] obj;
	private Comparator<test> c;
	private int effCounter = 0;
	private test[] container;
	private Random rand = new Random();
	
	public quickSort(test[] obj, Comparator<test> c) {
		this.obj = obj;
		this.c = c;
		this.container = obj.clone();
		
		quickSorting(0,obj.length-1);
	}
	
	public int getCounter() {
		return this.effCounter;
	}
	
	public void quickSorting(int startRange, int endRange) {
		int frontIn = startRange;
		int backIn = endRange;
		int randNum = rand.nextInt(endRange - startRange + 1) + startRange;
		test pivot = obj[randNum];
		
		for(int i = startRange; i < endRange+1; i++) {
			if(i != randNum) {	
				if (c.compare(container[i], pivot) > 0) {
					obj[backIn] = container[i];
					backIn--;
				} else {
					obj[frontIn] = container[i];
					frontIn++;
				}
			}
			effCounter ++;
		}

		obj[frontIn] = pivot;
		this.container = obj.clone();
	
		if (frontIn - startRange > 1) {
			quickSorting(startRange,frontIn-1);
		}
		if(endRange - backIn > 1) {
			quickSorting(backIn,endRange);
		}
	}
	
}
		
		
		
		
//		while(init <= end) {
//			while(c.compare(obj[init],obj[pivotVal]) > 0) {
//				init++;
//				effCounter++;
//			}
//			
//			while(c.compare(obj[pivotVal], obj[end])>0) {
//				end--;
//				effCounter++;
//			}
//			
//			if (init <= end) {
//				swapNo(init,end);
//				init++;
//				end--;
//			}
//			System.out.println("Init = " + init);
//			System.out.println("End = " + end);
			
//		}
//		System.out.println("pivot = " + pivotVal);
//		System.out.println("Init = " + init);
//		System.out.println("End = " + end);
//		System.out.println("floor = " + floor);
//		System.out.println("Ceiling = " + ceiling);
//		
//		for(int i = floor; i < ceiling; i++) {
//	    	System.out.println(obj[i].getString());
//	    }
//		
//		if((ceiling - floor) > 3) {
//			quickSorting(floor,floor+pivotVal);
//			quickSorting(ceiling-pivotVal,ceiling);
//		}
		
//		if (floor < init) {
//			quickSorting(floor, init);
//		}
//		if (end < ceiling) {
//			quickSorting(end, ceiling);
//		}
	
//	private void swapNo(int init, int end) {
//		String temp = obj[init].getString();
//		obj[init].setString(obj[end].getString());
//		obj[end].setString(temp);
//	}
	