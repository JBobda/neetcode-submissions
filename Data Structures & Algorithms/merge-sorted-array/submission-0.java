class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idxOne = 0;
        int idxTwo = 0;

        int[] combo = new int[m + n];
        int i = 0;
        while(i < m + n && idxOne < m && idxTwo < n) {
            int numOne = nums1[idxOne];
            int numTwo = nums2[idxTwo];

            if(numOne < numTwo) {
                combo[i] = numOne;
                idxOne++;
            } else {
                combo[i] = numTwo;
                idxTwo++;
            }

            i++;
        }

        while(i < m + n && idxOne < m) {
            combo[i] = nums1[idxOne];
            idxOne++;
            i++;
        }

        while(i < m + n && idxTwo < n) {
            combo[i] = nums2[idxTwo];
            idxTwo++;
            i++;
        }

        for(int x = 0; x < combo.length; x++) {
            nums1[x] = combo[x];
        }
    }
}