package practice.random;

public class IsMagicNumber {
    public static void main(String[] args) {
        System.out.println(isMagicNumber(52999993));
    }
    private static boolean isMagicNumber(int number){
        int digitSum = 0;

        while(number > 0){
            int digit = number % 10;
            number = number/10;

            digitSum += digit;

            while(digitSum > 9){
                digitSum = digitSum/10 + digitSum % 10;
            }
        }

        return digitSum == 1;
    }
}
