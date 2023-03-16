import java.util.Arrays;

public class Solution {
	int prev = -1;
	
	public int search(int[] nums, int target) {
		int middle = nums.length / 2;
		if (nums[middle] == target) {
			return middle;
		}
		if (nums.length == 1 && nums[middle] != target) {
			return -1;
		}
		
		int result = 0;
		int left = 0;
		int right = nums.length - 1;
		if (target > nums[middle]) {
			if (nums[middle] < nums[left] && target >= nums[left]) {
				result = search(Arrays.copyOfRange(nums, left, middle), target);
			} else {
				int index = search(Arrays.copyOfRange(nums, middle, nums.length), target);
				result = index == -1? -1 : middle + index;
			}
		} else {
			if (nums[middle] > nums[right] && target <= nums[right]) {
				int index = search(Arrays.copyOfRange(nums, middle, nums.length), target);
				result = index == -1? -1 : middle + index;
			} else {
				result = search(Arrays.copyOfRange(nums, left, middle), target);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] a1 = new int[]{4, 5, 6, 7, 0, 1, 2};
		int[] a2 = new int[]{1, 3};
		Solution s = new Solution();
		System.out.println(s.search(a1, 0) == 4);
		System.out.println(s.search(a2, 4) == -1);
		
	}
}


//		if(nums[middle]>nums[left]){
//				result=search(Arrays.copyOfRange(nums,middle+1,nums.length),target);
//				}else if(nums[middle]<nums[left]&&target>nums[left]){
//						                          result=search(Arrays.copyOfRange(nums,left,middle),target);
//						                          }else{
//						                          return-1;
//						                          }