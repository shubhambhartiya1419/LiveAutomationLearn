package tempReuse;

import java.util.Date;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class GenerateEmailDemo {
	public static void main(String[] args) {
	
	Date date=new Date();
	String dateString =date.toString();
	String removeSpaceDate= dateString.replaceAll(" ",""); //or------->      "//s"
	String noSpaceNocolong= removeSpaceDate.replaceAll("\\:","");
	String emailWithTimeStamp = noSpaceNocolong+"@gmail.com";
	System.out.println(emailWithTimeStamp);

	}
}
