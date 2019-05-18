import java.util.*;
public class PrimeNumberUsingThread extends Thread {
	int lowerBound, upperBound;
	static List <Integer> listofPrimes=new ArrayList<>();
	
	public PrimeNumberUsingThread (int low, int up) {
		lowerBound=low;
		upperBound=up;
	}
	
	public void run() {
		int counter;
		for(int i = lowerBound; i<=upperBound;i++) {
			counter =0;
			for(int j=2;j<i/2;j++) {
				if(i%j==0) {
					counter++;
					break;
				}
					
			}
			if(counter==0) {
				//System.out.print(i + "\t");
				listofPrimes.add(i);
			}
		}
		
		
	}

	public static void main(String[] args) {
		int lowerBound=1, upperBound=100;
		
		int mid=(lowerBound+upperBound)/2,mid1=mid+1;
		PrimeNumberUsingThread test= new PrimeNumberUsingThread(lowerBound,mid);
		PrimeNumberUsingThread test1= new PrimeNumberUsingThread(mid1, upperBound);
		
		System.out.println("Prime numbers are:");
		
		test.start();
		test1.start();
		
		int arr[]= listofPrimes.stream().mapToInt(Integer::intValue).toArray();
		Arrays.sort(arr);
		
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}

	}

}
