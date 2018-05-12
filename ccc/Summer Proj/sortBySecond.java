import java.util.Comparator;

class sortBySecond implements Comparator<test>{
	public int compare(test t1, test t2) {
		if(t1.getString().charAt(1) > t2.getString().charAt(1)) {
			return 1;	
		}
		return 0;
	}
}
	