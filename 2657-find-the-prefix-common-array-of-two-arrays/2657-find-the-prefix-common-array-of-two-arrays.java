class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) 
    {
        //count the freq of the element
        int n=A.length;
        int maxValue=0;
        int count=0;
        int C[] = new int[n];

        for(int i=0; i<n; i++)
        {
            maxValue=Math.max(maxValue, Math.max(A[i], B[i]));
        }

        int freq[] = new int[maxValue+1];

        for(int i=0; i<n; i++)
        {
            freq[A[i]]++;
            if(freq[A[i]] == 2) count++;

            freq[B[i]]++;
            if(freq[B[i]] == 2) count++;

            C[i]=count;
        }
        
    return C;
    }
}