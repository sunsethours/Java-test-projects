package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSV {
    
    public static List<String[]> read(String file) {
        List<String[]> data = new LinkedList<String[]>();
        String dataRow;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((dataRow = br.readLine()) != null) {
                String[] dataRecords = dataRow.split(",");
                data.add(dataRecords);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("File not Readable");
            ex.printStackTrace();
        }
        return data;
    }
}
