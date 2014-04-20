/*

leetcode: Given a number represented as an array of digits, plus one to the number.

*/


//mycode: don't forget to check the first element of the array
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry =1;
        for(int i= digits.length-1;i>=0;i--){
            digits[i] = carry+digits[i];
            if(digits[i]>=10){
                digits[i]-=10;
                carry =1;
            }else{
                carry=0;
            }
        }
        if(carry ==0)
            return digits;
        else{
            int[] result = new int[digits.length+1];
            result[0]=1;
            for(int i =0; i<digits.length;i++){
                result[i+1] = digits[i];
            }
            return result;
        }
    }
}
