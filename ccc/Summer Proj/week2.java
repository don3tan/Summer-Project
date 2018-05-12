import java.util.ArrayList;
import java.util.Collections;


public class week2 {
	private static final int Comparator = 0;

	public static void main(String args[]){
	    	
//	    String[] list = new String[3];
//	    list[0] = "Hi";
//	    list[1] = "no";
//	    list[2] = "lala";
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("hi");
		list.add("lala");
		list.add("fuck");
	    
		System.out.println(list);
		
	    Collections.sort(list);
	    
	    System.out.println(list);
	    
	    System.out.println("----------------------------------");
	    
	    test[] obj1 = new test[18];
	    obj1[0] = new test("bbb");
	    obj1[1] = new test("ccc");
	    obj1[2] = new test("jjj");
	    obj1[3] = new test("zzz");
	    obj1[4] = new test("aaa");
	    obj1[5] = new test("eee");
	    obj1[6] = new test("fff");
	    obj1[7] = new test("ddd");
	    obj1[8] = new test("iii");
	    obj1[9] = new test("ggg");
	    obj1[10] = new test("kkk");
	    obj1[11] = new test("lll");
	    obj1[12] = new test("mmm");
	    obj1[13] = new test("ooo");
	    obj1[14] = new test("ppp");
	    obj1[15] = new test("qqq");
	    obj1[16] = new test("hhh");
	    obj1[17] = new test("nnn");
	    
	    test[] obj2 = obj1.clone();
	    test[] obj3 = obj1.clone();
	    
//	    System.out.println("******** obj1 test ********");
//	    
//	    for(int i = 0; i < obj1.length; i++) {
//	    	System.out.println(obj1[i].getString());
//	    }
	    quickSort temp1 = new quickSort(obj1, new sortBySecond());
	    bubbleSort temp2 = new bubbleSort(obj2, new sortBySecond());
	    mergeSort temp3 = new mergeSort(obj3, new sortBySecond());
	    
	    System.out.println("******** After quickSort *********");	
	    for(int i = 0; i < obj1.length; i++) {
	    	System.out.println(obj1[i].getString());
	    }
	    
	    System.out.println("Efficiency = " + temp1.getCounter());
	    
	    for(int i = 0; i < obj2.length; i++) {
	    	System.out.println(obj2[i].getString());
	    }
	    
	    System.out.println("Efficiency = " + temp2.getCounter());
	    
	    for(int i = 0; i < obj3.length; i++) {
	    	System.out.println(obj3[i].getString());
	    }
	    
	    System.out.println("Efficiency = " + temp3.getCounter());
	    
	}
}





