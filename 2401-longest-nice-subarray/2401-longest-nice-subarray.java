class Solution {
    public int longestNiceSubarray(int[] nums) 
    {
        int n = nums.length;
        int maxLength = 1;
        int l=0;
        int usedBit=0;


        for(int right = 0; right<n; right++)
        {
            while((usedBit & nums[right]) != 0 )
            {
                usedBit ^= nums[l];
                l++;
            }
            usedBit |= nums[right];
            maxLength = Math.max(maxLength, right - l +1);
        }
        return maxLength;
    }
}