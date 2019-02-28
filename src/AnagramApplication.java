import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AnagramApplication {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();            // Start the timer.
        String result = "";                                     // Initialize result string.
        String wordToVerify = args[1];                          // Get the word to work with from arguments fed by the user.

        try{
            BufferedReader listReader = new BufferedReader(     // Set up a buffered reader.
                    new InputStreamReader(
                            new FileInputStream(args[0]),"UTF8"
                    ), 10*8192                              // Limit the buffer size in order to improve the performance.
            );
            String line;                                        // Initialize each line string.
            while ((line = listReader.readLine()) != null)      // Check if the line is empty.
            {
               if (line.length() == wordToVerify.length()) {    // Make sure that we do not check words which
                    if (verifyIfAnagram(line, wordToVerify)) {  // are different in length. Call the method to check
                        if (!line.equals(wordToVerify)) {       // the words.
                            result += ", " + line;              // If the word is anagram, we add that to the string.
                        }
                    }
               }
            }
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred tryin' to read your file '%s'.", args[0]); // Show error if the application fails to read the file.
            e.printStackTrace();
        }

        System.out.println((System.currentTimeMillis() - startTime) + result); // Print the results into the console.
    }

    private static boolean verifyIfAnagram(String word1, String word2) {
       char[] charOfWord1 = word1.toCharArray(); // Put the given strings into an array of strings.
       char[] charOfWord2 = word2.toCharArray();
       Arrays.sort(charOfWord1); // Sort the arrays to be able to compare them
       Arrays.sort(charOfWord2);
       return Arrays.equals(charOfWord1, charOfWord2); // return true if the sorted arrays match.
    }
}
