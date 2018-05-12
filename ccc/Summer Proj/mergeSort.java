import java.util.Comparator;
import java.util.Random;

public class mergeSort {
	
	private test[] obj;
	private Comparator<test> c;
	private int effCounter = 0;
	private test[] container;
	private Random rand = new Random();
	
	public mergeSort(test[] obj, Comparator<test> c) {
		this.obj = obj;
		this.c = c;
		this.container = obj.clone();
		
		mergeSorting(0,obj.length-1);
	}
	
	public int getCounter() {
		return this.effCounter;
	}
	
	public void mergeSorting(int startRange, int endRange) {
		int pivot = ((endRange - startRange) / 2) + startRange;
		
		if(pivot - startRange != 0) {
			mergeSorting(startRange,pivot);
		}
		
		if(endRange - pivot != 0) {
			mergeSorting(pivot+1, endRange);
		}
		
		merging(startRange,pivot, endRange - startRange + 1);
		
	}
	
	public void merging(int start1, int start2, int range) {
		int counter = start1;
		for(int i = 0; i < range; i++) {
			System.out.println("start1 = " + start1 + " start2 = " + start2);
			if(start1 > -1 && start2 < 18) {
				if(c.compare(container[start1], container[start2]) > 0) {
					obj[counter] = container[start1];
					start1 ++;
				} else {
					obj[counter] = container[start2];
					start2 ++;
				}
			} else {
				obj[counter] = container[start1];
				start1 ++;
			}
			counter ++;
		}
		this.container = obj.clone();
	}	
}