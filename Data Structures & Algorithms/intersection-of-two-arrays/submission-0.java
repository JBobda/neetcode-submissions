class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int num : nums1) {
            set1.add(num);
        }

        for(int num : nums2) {
            set2.add(num);
        }

        List<Integer> list = new ArrayList<>();

        for(int element : set1) {
            if(set2.contains(element)) {
                list.add(element);
            }
        }

        int[] result = new int[list.size()];
        int i = 0;
        for(int num : list) {
            result[i] = num;
            i++;
        }

        return result;
    }
}