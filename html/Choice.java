import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class Choice {
    public static void main(String[] args) throws IOException {

        // I know that this has no reason to be written in binary but I need it to be in binary for my assignment
        Binary bin = new Binary();
        Path file = Path.of("choice.txt");

        String b = bin.toBinary(args[0]);

        Files.writeString(file, args[0]);
    }
}
