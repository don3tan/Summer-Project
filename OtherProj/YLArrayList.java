import java.lang.Class;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class YLArrayList <T>{
	
	T[] obj;
	// Size will reflect the index of next input
	int size = 0;
	final static int DEFAULT_SIZE = 10;
	
	// Constructor for default YLArrayList
	public YLArrayList() {
		this(DEFAULT_SIZE);
	}
	
	// Constructor if user has a desired capacity
	public YLArrayList(int capacity ) {
		obj = (T[]) new Object[capacity];
	}
	
	// Contructor that takes in collections
	public YLArrayList(Collection<? extends T> c) {
		this(c.size());
		this.addAll(c);
		
	}
	
	// Method to retrieve item from specific location
	public T getItem(int position) {
		if(position < this.size) {
			return obj[position];
		}
		
		return null;
	}
	
	// Add Item Function
	public void add(T ele) {
		if(checkOversized(1)) {
			increaseSize(1);
		}
		obj[this.size] = ele;
		// Increases Size in preparation for the next input
		this.size += 1;
	}
	
	public void add(T ele, int position) {
		if(checkOversized(1)) {
			increaseSize(1);
		}
		for(int i = this.size; i > position ; i--) {
			obj[i] = obj[i-1];
		}
		obj[position] = ele;
		this.size += 1;
	}
	
	public void addAll(Collection<? extends T> c) {
		
		int increSize = c.size();
		
		if(checkOversized(increSize)) {
			increaseSize(increSize);
		}
		for(T x: c) {
			obj[size] = x;
			this.size++;
		}
	}
	
	public void addAll(Collection<? extends T> c,int position) {
		
		int increSize = c.size();
		int increCount = 0;
		
		// "+ 1" is to account for the fact that Position value starts from 0 instead of 1
		if(checkOversized(increSize + position + 1)) {
			increaseSize(increSize + position + 1);
		}
		
		for(int x = this.size-1; x > position-1; x--) {
			obj[x + increSize] = obj[x];
		}
		for(T x: c) {
			obj[position + increCount] = x;
			increCount++;
		}
		
		this.size += increSize;
	}
	
	public void clear() {
		obj = (T[]) new Object[DEFAULT_SIZE];
		this.size = 0;
	}
	
	public T[] clone() {
		if(!isEmpty()) {
				T[] clone = (T[]) Arrays.copyOfRange(obj, 0, this.size);
				return clone;
		}
		return null;
	}
	
	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		}
		return false;
	}
	
	public int lastIndexOf() {
		if(isEmpty()){
			return -1;
		}
		return size - 1;
	}
	
	public void remove(int position) {
		for(int i = position+1; i < this.size ; i++) {
			obj[i-1] = obj[i];
		}
		this.size -= 1;
	}
	
	public boolean remove(T search) {
		if(!isEmpty()) {
			for(int i = 0; i < size; i++) {
				if(obj[i].equals(search)) {
					remove(i);
					return true;
				}
			}
		}
		return false;
	}
	
	public void removeRange(int fromIndex, int toIndex) {
		
		int counter = 0;
		
		for(int i = toIndex; i < size; i++) {
			obj[fromIndex + counter] = obj[i];
			counter ++;
		}
		size -= toIndex - fromIndex;
	}
	
	public int size() {
		return size;
	}
	
	private boolean checkOversized(int requi) {
		
		// Add the current number of items within the array
		requi += this.size;
		
		//Check with obj.length to see if array can accomdate the increase in size
		if(requi <= obj.length) {
			return false;
		}else {
			return true;
		}
	}
	
	private void increaseSize(int nSize) {
		
		// increSize will represent the requirement for increase in the array
		int increSize = (this.size + nSize) - obj.length;
		T[] data;
		
		if (increSize > obj.length) {
			data = (T[]) new Object[increSize + this.size];
		} else {
			data = (T[]) new Object[obj.length * 2];
		}
		
		System.arraycopy(obj, 0, data, 0, size);
		this.obj = data;
	}
}