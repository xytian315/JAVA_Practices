/*Implement a method to perform basic string compression using the counts of 
repeated characters

aabcccccaaa a2b1c5a3
If the compressed string would not become smaller than the original string,
your method should return the original string.
*/
/*
allow to use StringBuilder/StringBuffer
*/

public class Solution{

    public static String compressedString(String s){
        if(s == null || s.isEmpty())
            return s;

        StringBuilder sb =  new StringBuilder();

        char c =s.charAt(i);
        int count =1;

        for(int i =1; i< s.length(); i++){

            if(s.charAt(i) == c){
                count++;
            }else{
                sb.append(c);
                sb.append(count);
                c = s.charAt(i);
                count=1;

            }

        }

        //do nof forget this!!!
        sb.append(c);
        sb.append(count);

        String result = sb.toString();

        if(result.length() >= s.length())
            return s;
        return result;

    }

}


/*
does not allow string buffer
*/

public class Solution2{
    public static String compressedString(String s){

        int size = computeSize(Sting s);
        if(size >=s.length())
            return s;

        char[] results = new char[size];

        char last = s.charAt(0);
        int count =1;
        int index =0;

        for(int i =1; i< s.length(); i++){
            if(s.charAt(i) == last){
                count++;
            }else{
                
                index = copyChars(results,last, count, index);

                last = s.charAt(i);
                count=1;
            }
        }
        index = copyChars(results,last, count, index);
        
        return String.valueOf(results);


    }


    private int copyChars(char[] results,char last, int count, int index){
        results[index++]=last; 

        //convert int count to a string then to an char array
        char[] chars = String.valueOf(count).toCharArray();
        for(char c: chars){
            results[index]=c;
            index++;
        }

        return index;  // don't forget to return index!!!!
    }


    private int computeSize(String s){
        if(s == null || s.isEmpty()) return 0;

        int size =0;

        char last = s.charAt(0);
        int count =1;

        for(int i =1; i< s.length(); i++){
            if(s.charAt(i) = last){
                count++;
            }else{
                size += 1+ String.valueOf(count).length();// +=!!!!
                last = s.charAt(i);
                count=1;
            }

        }

        size +=1+ String.valueOf(count).length();
        return size;


    }

}


