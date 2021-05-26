/**
 * Created by Alex, Kris, Matt, and Nima on 5/9/2016.
 */
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileReader {
    private String fileLocation;
    public FileReader(String fileLocation){
        this.fileLocation = fileLocation;
    }

    /**public static void main(String[] args){
        Scanner scannerIn = new Scanner(System.in);
        String fileLocation = scannerIn.nextLine();
        FileReader fiel = new FileReader(fileLocation);
        fiel.readData();
    }
     */

    public String[] readData(){
        DateFormat df = new SimpleDateFormat("MMddyy");
        Date today = new Date();
        String[] processedCardData;
        try{
            File file = new File(fileLocation);
            File tempFile = new File(file.getParent() +"\\"+ df.format(today) + ".txt");
            FileUtils.copyFile(file,tempFile);
            String fileData = FileUtils.readFileToString(tempFile);
            processedCardData = fileData.split("\\r?\\n");
            return processedCardData;

       }
        catch(IOException e){
            System.out.println("System error occured: " + e.getMessage());
            return null; //Will only occur if the file could not be fetched
        }

    }
    

}
