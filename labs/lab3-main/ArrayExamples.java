import java.util.Arrays;

public class ArrayExamples {

  // Changes the input array to be in reversed order
  static void reverseInPlace(int[] arr) {
	  
	System.out.println("Before reverseinplace: " + Arrays.toString(arr));
	
    for(int i = 0; i < arr.length / 2; i += 1) {
//    	System.out.println("During reverseinplace: " + Arrays.toString(arr));
    	int temp = arr[i];
    	arr[i] = arr[(arr.length - i - 1)];
    	arr[(arr.length - i - 1)] = temp;
    }
    
    System.out.println("After reverseinplace: " + Arrays.toString(arr));
    
    
    
  }

  // Returns a *new* array with all the elements of the input array in reversed
  // order
  static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    System.out.println("Before reversed: " + Arrays.toString(arr));
    for(int i = 0; i < arr.length / 2; i += 1) {
//    	System.out.println("During reversed: " + Arrays.toString(arr));
      int temp = arr[i];
      arr[i] = arr[arr.length - i - 1];
      arr[arr.length - i - 1] = temp;
    }
    
    newArray = arr;
    
    System.out.println("After reversed: " + Arrays.toString(arr));
    return arr;
  }

  // Averages the numbers in the array (takes the mean), but leaves out the
  // lowest number when calculating. Returns 0 if there are no elements or just
  // 1 element in the array
  static double averageWithoutLowest(double[] arr) {
    if(arr.length < 2) { return 0.0; }
    double lowest = arr[0];
    for(double num: arr) {
      if(num < lowest) { lowest = num; }
    }
    double sum = 0;
    for(double num: arr) {
      if(num != lowest) { sum += num; }
    }
    return sum / (arr.length - 1);
  }


}

