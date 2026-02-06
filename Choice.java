import java.io.*;

public class Choice {
    public static void main(String[] args) {

        // I know that this has no reason to be written in binary but I need it to be in binary for my assignment
        Binary bin = new Binary();

        bin.printBinary("123Testing");

        String b = bin.toBinary("123Testing");
        System.out.println(b);

        bin.printString(b);
        System.out.println(bin.toString(b));
    }
}