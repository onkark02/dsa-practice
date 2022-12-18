package practice.random;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input;
        StringBuilder sb = new StringBuilder();
        while(true){
            input = br.read();
            if(input == -1)
                break;
            sb.append((char) input);
        }
        System.out.println(sb.toString());
    }
}