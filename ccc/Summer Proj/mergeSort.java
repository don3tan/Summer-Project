import java.util.Comparator;
import java.util.Random;

public class mergeSort {
	
	private Object[] obj;
	private Comparator<Object> c;
	private int effCounter = 0;
	private Object[] container;
	
	public mergeSort(Object[] obj, Comparator<Object> c) {
		this.obj = obj;
		this.c = c;
		this.container = obj.clone();
		
		mergeSorting(0,obj.length-1);
	}
	
	public int getCounter() {
		return this.effCounter;
	}
	
	public void mergeSorting(int start, int end) {
		if(end - start > 0) {
			int pivot = ((end - start) / 2) + start;
			mergeSorting(start,pivot);
			mergeSorting(pivot+1,end);
			
			int start2 = pivot+1;
			int counter = start;
			
			while(start <= pivot && start2 <= end) {
				if(c.compare(container[start2], container[start]) == 0) {
					obj[counter] = container[start2];
					start2++;
				} else {
					obj[counter] = container[start];
					start++;
				}
				counter++;
				effCounter++;
			}
			
			while(start <= pivot) {
				obj[counter] = container[start];
				start++;
				counter++;
				effCounter++;
			}
			
			while(start2 <= end) {
				obj[counter] = container[start2];
				start2++;
				counter++;
				effCounter++;
			}
			
			container = obj.clone();
		}
	}
}