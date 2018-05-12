import java.util.Comparator;

class sortBySecond implements Comparator<Object>{
	public int compare(Object t1, Object t2) {
		test t3 = (test) t1;
		test t4 = (test) t2;
		if( t3.getString().charAt(1) > t4.getString().charAt(1)) {
			return 1;	
		}
		return 0;
	}
}
	