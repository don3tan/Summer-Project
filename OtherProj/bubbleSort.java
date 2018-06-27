import java.util.Comparator;

public class bubbleSort <T> {
	
	private T[] obj;
	private Comparator<T> c;
	private int effCounter = 0;
	
	public bubbleSort(T[] obj, Comparator<T> c) {
		this.obj = obj;
		this.c = c;
		
		bubbleSorting();
	}
	
	public int getCounter() {
		return this.effCounter;
	}
	
	public void bubbleSorting() {
		for(int i = obj.length; i > 0; i-- ) {
			for(int x = 0; x < i-1; x++) {
				if(c.compare(obj[x], obj[x+1]) > 0) {
					swapPos(x,x+1);
				}
				effCounter ++;
			}
		}
	}
	
	public void swapPos(int pos1, int pos2) {
		T temp = obj[pos1];
		obj[pos1] = obj[pos2];
		obj[pos2] = temp;
	}
}