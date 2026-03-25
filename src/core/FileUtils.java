package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    List<String> list1 =new ArrayList();
    public List<String> ReaderFiles(String path){
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            List<String> list1 = new ArrayList<>();
            String line1 = reader.readLine();
            while (line1 != null) {
                list1.add(line1);
            }
            return list1;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return List.of();
    }
}
