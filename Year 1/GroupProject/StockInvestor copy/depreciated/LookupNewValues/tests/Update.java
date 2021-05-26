/*
  Jeffrey Worley
  Jonathan Tran
  Bernard Li
*/
import java.util.Timer;
import java.util.TimerTask;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class Update{
		private long hours;
		private long minutes;
		private long delayHours;
		private long delayMinutes;
 		private Timer timer;
 		private OurTimerTask ott;
 		OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

 		public Update(long hours, long minutes, long delayHours, long delayMinutes){
 			this.hours = hours;
    		this.minutes = minutes;
    		this.delayHours = delayHours;
    		this.delayMinutes = delayMinutes;
    		timer = new Timer();
    		ott = new OurTimerTask();
 		}

 		public void periodicCheck() {
	    	timer.scheduleAtFixedRate(ott, (delayHours * 60 * 60000) + (delayMinutes * 60000), (hours * 60 * 60000) + (minutes * 10000));
		}	

 		public class OurTimerTask extends TimerTask{

			public OurTimerTask(){
				super();
			}

			public void run(){
				System.out.println("process cpu load: " + osBean.getProcessCpuLoad());
				System.out.println("available memory: " + osBean.getFreePhysicalMemorySize());
			}
		}
	}
