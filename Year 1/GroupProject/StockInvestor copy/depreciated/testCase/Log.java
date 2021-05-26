// Made by Calvin Nielson, James Lee, and Nima Kian.
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class Log {

private File file = new File("C:\\Users\\9485974\\Desktop\\StockApp\\src\\output.txt");

		public Log(){}

		public void writeToFile(String index, int quantity, BigDecimal bought){
				try{
						FileWriter fw = new FileWriter(file,true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(index+" "+quantity+" "+bought+"\n");
						bw.close();
				} catch(IOException e){
						e.printStackTrace();
				}
		}
}
