import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
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
	    
	    String[] obj1 = new String[18];
	    obj1[0] = "bbb";
	    obj1[1] = "ccc";
	    obj1[2] = "jjj";
	    obj1[3] = "zzz";
	    obj1[4] = "aaa";
	    obj1[5] = "eee";
	    obj1[6] = "fff";
	    obj1[7] = "ddd";
	    obj1[8] = "iii";
	    obj1[9] = "ggg";
	    obj1[10] = "kkk";
	    obj1[11] = "lll";
	    obj1[12] = "mmm";
	    obj1[13] = "ooo";
	    obj1[14] = "ppp";
	    obj1[15] = "qqq";
	    obj1[16] = "hhh";
	    obj1[17] = "nnn";
	    
	    String[] obj2 = obj1.clone();
	    String[] obj3 = obj1.clone();
	    
	    quickSort<String> temp1 = new quickSort<String>(obj1, new sortBySecond<String>());
	    bubbleSort<String> temp2 = new bubbleSort<String>(obj2, new sortBySecond<String>());
	    mergeSort<String> temp3 = new mergeSort<String>(obj3, new sortBySecond<String>());
	    
	    

	    
	    System.out.println("******** After quickSort *********");	
	    for(int i = 0; i < obj1.length; i++) {
	    	System.out.println(obj1[i]);
	    }
	    
	    System.out.println("Efficiency = " + temp1.getCounter());
	    
	    System.out.println("******** After BubbleSort *********");
	    for(int i = 0; i < obj2.length; i++) {
	    	System.out.println(obj2[i]);
	    }
	    
	    System.out.println("Efficiency = " + temp2.getCounter());
	    
	    System.out.println("******** After MergeSort *********");
	    for(int i = 0; i < obj3.length; i++) {
	    	System.out.println(obj3[i]);
	    }
	    
	    System.out.println("Efficiency = " + temp3.getCounter());
	    
	    System.out.println("**************************YLArray*************************");
	    
	    ArrayList<String> obj4 = new ArrayList<String>(Arrays.asList(obj1));
	    
	    YLArrayList<String> yeow = new YLArrayList<String>(obj4);
	    
	    System.out.println("Size = " + yeow.size());
	    System.out.println("Index = " + yeow.lastIndexOf());
	    
	    for(int i = 0; i < yeow.size();i++) {
	    	System.out.println(yeow.getItem(i));
	    }
	    
	    yeow.add("hihi");
	    
	    System.out.println("Size = " + yeow.size());
	    System.out.println("Index = " + yeow.lastIndexOf());
	    
	    for(int i = 0; i < yeow.size();i++) {
	    	System.out.println(yeow.getItem(i));
	    }
	    
	    yeow.add("Dafuq",3);
	    
	    for(int i = 0; i < yeow.size();i++) {
	    	System.out.println(yeow.getItem(i));
	    }
	    
	    System.out.println("*************************AddRange********************8");
	    
	    ArrayList<String> obj5 = new ArrayList<String>(Arrays.asList("111","222","333"));
	    
	    yeow.addAll(obj5, 3);
	    
	    for(int i = 0; i < yeow.size();i++) {
	    	System.out.println(yeow.getItem(i));
	    }
	    
	    System.out.println("Size = " + yeow.size());
	    System.out.println("Index = " + yeow.lastIndexOf());
	    
	    yeow.remove("Dafuq");
	    
	    for(int i = 0; i < yeow.size();i++) {
	    	System.out.println(yeow.getItem(i));
	    }
	    
	    System.out.println("Size = " + yeow.size());
	    System.out.println("Index = " + yeow.lastIndexOf());
	    
	    yeow.removeRange(3, 6);
	    
	    for(int i = 0; i < yeow.size();i++) {
	    	System.out.println(yeow.getItem(i));
	    }
	    
	    System.out.println("Size = " + yeow.size());
	    System.out.println("Index = " + yeow.lastIndexOf());
	    
	}
}





