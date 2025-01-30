class Solution {
    public int maxArea(int[] height) 
    {
        int res=0;
        int l=0; 
        int r=height.length-1;

        while(l<r)
        {
            int left=height[l];
            int right=height[r];
            int area= Math.min(left, right) * (r-l);
            res=Math.max(res, area);

            if(left<right) l++;
            else r--;
        }
        return res;
    }
}