import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Log{
	
	public Log(){
		
	}
	
	private File file = new File("output.txt");
	
	void writeToFile(String index, int price, String boughtPrice, String bought, String time){
		try{
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(bought+index+" "+price+" "+boughtPrice+time+"\n");
			bw.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
