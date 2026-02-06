public class Binary {
    String str; // Input String
    int bin;    // String in Binary
    
    public Binary() {
        
    }

    public String toBinary(String str) {
        // Source - https://stackoverflow.com/a/917190
        // Posted by Nuoji, modified by community. See post 'Timeline' for change history
        // Retrieved 2026-02-06, License - CC BY-SA 2.5

        String s = str;
        byte[] bytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes)
        {
           int val = b;
           for (int i = 0; i < 8; i++)
           {
              binary.append((val & 128) == 0 ? 0 : 1);
              val <<= 1;
           }
           binary.append(' ');
        } 

        return binary.toString();
    }

    public void printBinary(String str) {
        // Source - https://stackoverflow.com/a/917190
        // Posted by Nuoji, modified by community. See post 'Timeline' for change history
        // Retrieved 2026-02-06, License - CC BY-SA 2.5

        String s = str;
        byte[] bytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes)
        {
           int val = b;
           for (int i = 0; i < 8; i++)
           {
              binary.append((val & 128) == 0 ? 0 : 1);
              val <<= 1;
           }
           binary.append(' ');
        }
        System.out.println("'" + s + "' to binary: " + binary);
    }

    public String toString(String bin) {
        String binary = bin;
        String[] byteStrings = binary.trim().split(" ");

        byte[] bytes = new byte[byteStrings.length];

        for (int i = 0; i < byteStrings.length; i++) {
            int val = 0;
            for (int j = 0; j < 8; j++) {
                val <<= 1;
                if (byteStrings[i].charAt(j) == '1') {
                    val |= 1;
                }
            }
            bytes[i] = (byte) val;
        }

        return new String(bytes);
    }

    public void printString(String bin) {
        String binary = bin;
        String[] byteStrings = binary.trim().split(" ");

        byte[] bytes = new byte[byteStrings.length];

        for (int i = 0; i < byteStrings.length; i++) {
            int val = 0;
            for (int j = 0; j < 8; j++) {
                val <<= 1;
                if (byteStrings[i].charAt(j) == '1') {
                    val |= 1;
                }
            }
            bytes[i] = (byte) val;
        }

        String result = new String(bytes);
        System.out.println("Binary to string: " + result);
    }
}
