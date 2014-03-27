package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public static String formatInBrazilianWay(Date date) {
		return formatter.format(date);
	}
}
