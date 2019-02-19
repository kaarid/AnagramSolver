import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String result = "";
        String filename = "C:\\Users\\taavi\\IdeaProjects\\Lemmad Helmes\\lemmad.txt";
        String wordToVerify = "kiir";

        try{
            BufferedReader listReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"UTF8"), 1000*8192);
            String line;
            while ((line = listReader.readLine()) != null)
            {
               if (line.length() == wordToVerify.length()) {
                    if (verifyIfAnagram(line, wordToVerify)) {
                        if (!line.equals(wordToVerify)) {
                            result += ", " + line;
                        }
                    }
               }
            }
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred tryin' to read your file '%s'.", filename);
            e.printStackTrace();
        }

        long stop = System.currentTimeMillis() - startTime;
        System.out.println(stop + result);
    }

    private static boolean verifyIfAnagram(String word1, String word2) {
       char[] charOfWord1 = word1.toCharArray();
       char[] charOfWord2 = word2.toCharArray();
       Arrays.sort(charOfWord1);
       Arrays.sort(charOfWord2);
       return Arrays.equals(charOfWord1, charOfWord2);
    }
}
