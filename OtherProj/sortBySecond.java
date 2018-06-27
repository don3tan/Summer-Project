import java.util.Comparator;

class sortBySecond<T> implements Comparator<T>{
	public int compare(T t1, T t2) {
		String t3 = (String) t1;
		String t4 = (String) t2;
		if( t3.charAt(1) > t4.charAt(1)) {
			return 1;	
		}
		return 0;
	}
}
	