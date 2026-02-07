import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.List;

public class Choice {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Missing parameter");
            return;
        }

        Path file = Path.of("ServerConfig.toml");
        List<String> lines = Files.readAllLines(file);
        String newMap = "/levels/" + args[0] + "/info.json";

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith("Map =")) {
                lines.set(i, "Map = \"" + newMap + "\"");
                break;
            }
        }

        Files.write(file, lines, StandardOpenOption.TRUNCATE_EXISTING); // writes map to ServerConfig.toml
        System.out.println("Map updated to: " + newMap);

	Path txt = Path.of("choice.txt"); // logs map
	Files.writeString(txt, args[0]);
    }
}

