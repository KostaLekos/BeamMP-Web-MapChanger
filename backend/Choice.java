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
      String map = switch (args[0]) {
        case "automation_test_track" -> "Automation Test Track"; 
        case "derby" -> "Derby"; 
        case "driver_training" -> "Driver Training"; 
        case "east_coast_usa" -> "East Coast USA"; 
        case "small_island" -> "Small Island"; 
        case "utah" -> "Utah"; 
        case "industrial" -> "Industrial"; 
        case "italy" -> "Italy"; 
        case "johnson_valley" -> "Johnson Valley"; 
        case "jungle_rock_island" -> "Jungle Rock Island"; 
        case "gridmap_v2" -> "Gridmap V2"; 
        case "hirochi_raceway" -> "Hirochi Raceway"; 
        case "west_coast_usa" -> "West Coast USA"; 
        case "gridmap_legacy" -> "Gridmap Legacy"; 
        case "smallgrid" -> "Small Grid"; 
        default -> args[0];
      };

	    Files.writeString(txt, map);
    }
}

