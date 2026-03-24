package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
    private String path1;
    private String path2;

    public void ReaderFiles(String path1, String path2){
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
            String line1 = reader.readLine();
            while (line1 != null) {
                line1 = reader.readLine();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
