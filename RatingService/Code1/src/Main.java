import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "Mohit is a Hard Worker";

        String sout = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            sout = sout + s.charAt(i);
        }

        String split[] = sout.split(" ");
        for(int i = split.length - 1; i >= 0; i--) {
            System.out.print(split[i] + " ");
        }
    }
}