class Solution {
    public int[] plusOne(int[] digits) {
        // return plusOnewithString(digits);
        return plusOnewithHint(digits);
    }

    public int[] plusOnewithString(int[] digits) {
              String result = Arrays.stream(digits)
                      .mapToObj(String::valueOf)
                      .collect(Collectors.joining());

        long num = Long.parseLong(result);
        num++;
        int[] output = Long.toString(num).chars().map(c -> c - '0').toArray(); 
        return output;
    }

    public int[] plusOnewithHint(int[] digits) {
        // int[] output = new int[digits];
        // int[] output = Arrays.copyOf(digits, digits.length);
        //  List<Integer> output = new ArrayList<>(digits);
         List<Integer> output = Arrays.stream(digits)
                             .boxed()
                             .collect(Collectors.toList());
                             
        for (int i = digits.length-1; i>=0; i--){
            if(digits[i] < 9 ){
                // output[i] = digits[i] + 1;
                output.remove(i);
                output.add(i, digits[i] + 1);
                // if(i == digits.length-1)
                // { 
                    return output.stream().mapToInt(Integer::intValue).toArray(); 
                    // }
                // return output;
            }
            else{
                output.remove(i);
                output.add(i, 0);
            }
        }
        // if(digits[0] < 9)
        // {
        //     output.remove(0);
        //     output.add(0,digits[0]+1);
        // }
        // else{
            output.add(0,1);
        // }
        return output.stream().mapToInt(Integer::intValue).toArray();
    }


}
