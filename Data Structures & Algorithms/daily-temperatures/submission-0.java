class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            int counter = 1;
            for(int j = i + 1; j < temperatures.length; j++) {
                if(temperatures[i] < temperatures[j]) {
                    output[i] = counter;
                    break;
                } else {
                    counter++;
                }
            }
        }

        return output;
    }
}
