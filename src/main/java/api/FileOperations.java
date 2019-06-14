package api;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOperations {

    public static final String CURRENT_DIR_PATH = System.getProperty("user.dir");

    public static void appendToFile(String textToAppend) throws IOException {

        FileWriter fileWriter = new FileWriter(CURRENT_DIR_PATH + File.separator + "ChallengeQuestions.txt", true); //Set true for append mode
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(textToAppend);  //New line
        printWriter.close();
    }
}