package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * This method will fetch & return a random number upto 1000
	 * @return
	 */
		public  int getRandomNum(){
			Random ran = new Random();
			int num = ran.nextInt(1000);
			return num;
	}	

		/**
		 * This method will return System Date
		 * @return
		 */
		public String getSystemDate() {
			Date d = new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
			String date = sdf.format(d);
			return date;
		}
}
