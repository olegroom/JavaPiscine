import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FormatDefiner {

    public static void main(String[] args) throws IOException {
        Map<String, String> signatures = new HashMap<>();

        try {
            FileInputStream myInput = new FileInputStream(new File("signatures.txt"));
            StringBuilder builder = new StringBuilder();
            int s;
            while ((s = myInput.read()) != -1) {
                if ((char)s == '\n' || myInput.available() == 0) {
                    String[] line = builder.toString().split(", ");
                    signatures.put(line[1].trim(), line[0]);
                    builder.setLength(0);
                    continue;
                }
                builder.append((char)s);
            }
            myInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String input = "";
        Scanner scan = new Scanner(System.in);

        while (!(input = scan.nextLine()).equals("42")) {

            StringBuilder hex = new StringBuilder();
            FileInputStream argFile = null;
            byte[] bytes = new byte[20];


            boolean isDefined = false;
            FileOutputStream resultFile = null;
            try {
                resultFile = new FileOutputStream("result.txt", true);
                argFile = new FileInputStream(input);
                for (int i = 0; argFile.available() > 0 && i < 10; i++)
                    hex.append(String.format("%02X ", argFile.read()));
                String inputFileSignature = hex.toString();
                String value = "";
                for (String key : signatures.keySet()) {
                    if (inputFileSignature.startsWith(key)) {
                        value = signatures.get(key);
                        resultFile.write(value.getBytes());
                        resultFile.write('\n');
                        System.out.println("PROCESSED");
                        isDefined = true;
                    }
                }

                if (isDefined == false)
                    System.out.println("UNDEFINED");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (argFile != null)
                        argFile.close();
                    if (resultFile != null)
                        resultFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}