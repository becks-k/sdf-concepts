import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class WriteFiles {
    public static void main(String[] args) {

        SampleObject so1 = new SampleObject("marcus", Arrays.asList("coffee", "chocolate", "tea", "fruit juice", "soy bean milk"));
        
        try {
            saveFile(so1);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
            
    }

    /*Write to file with objects*/
    public static void saveFile(SampleObject obj) throws IOException{ //create repository class with setters and getters
        File directory = new File("data");
        String saveLocation = directory.getPath() + "\\" + obj.getName() + ".csv"; //assume object has getName method
        File fr = new File(saveLocation); //create file object with save location

        try {
            Path dir = Paths.get(directory.getPath());
            if (!Files.exists(dir)) {
                Files.createDirectory(dir);
            }
            if (!fr.exists()) {
                fr.createNewFile(); //create new file in save location
            }
        } catch (FileAlreadyExistsException e) {
            System.err.println("File already exists: " + e.getMessage());
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fr)));
        for (String i : obj.getItemList()) {
            bw.write(i); //writes string
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
