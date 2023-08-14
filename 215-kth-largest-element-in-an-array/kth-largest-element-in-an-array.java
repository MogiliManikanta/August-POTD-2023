class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,k);
    }
    public int quickSelect(int[] nums,int left,int right,int k){
        int pivot=left;
        for(int i=left;i<right;i++){
            if(nums[i]<=nums[right]){
                swap(nums,pivot++,i);
            }
        }
        swap(nums,pivot,right);
        int count = right-pivot+1;//counting after the pivot index elemnts;
        if(count==k){
            return nums[pivot];
        }
        else if(count>k){
            return quickSelect(nums,pivot+1,right,k);
        }
        return quickSelect(nums,left,pivot-1,k-count);
    }
    public void swap(int[] nums,int l,int r){
        int temp = nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
}
/**Time complexity: O(n) average-case (read above)
Space complexity: O(logn) average-case */