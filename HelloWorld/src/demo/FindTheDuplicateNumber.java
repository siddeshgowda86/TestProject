package demo;

import java.util.Scanner;

class FindTheDuplicateNumber {
    public int findTheDuplicateNumber(int[] nums) {
   for (int i = 0; i < nums.length; i++) {
  for (int j = i + 1; j < nums.length; j++) {
    if (nums[i] == nums[j])
      return nums[i];
  }
}
return -1;

}
public static void main(String args[]) {
	
	
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter value of n");
    int n = scanner.nextInt();
    int nums[] = new int[n + 1];
    System.out.println("Enter the elements of array");
    for(int i = 0 ; i < nums.length ;i++) {
    	nums[i] = scanner.nextInt();
    }
    scanner.close();
    int result = new FindTheDuplicateNumber().findTheDuplicateNumber(nums);
    System.out.println(result);
}
}
