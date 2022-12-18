package practice.cdci.arrays;
import java.util.Arrays;
public class IsUnique {
    public static void main(String[] args) {
        String str = "this mye";
        System.out.println("String: "+str);
        System.out.println("Is unique: "+ isUnique(str));
    }

    private static boolean isUnique(String s){
        char[] charArray = new char[s.length()];
        charArray = s.toCharArray();
        Arrays.sort(charArray);
        for(int i=0; i < charArray.length-1; i++){
            if(charArray[i] == charArray[i+1])
                return false;
        }
        return true;
    }
}
