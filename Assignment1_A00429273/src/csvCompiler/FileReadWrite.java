package csvCompiler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class FileReadWrite {

	private static final String[] FIELDS = { "First Name", "Last Name", "Street Number", "Street", "City", "Province",
			"Postal Code", "Country", "Phone Number", "email Address", "Date" };
	static SimpleLogging logger = new SimpleLogging();
	public static int skippedRowCounter = 0;
	public static int validRowCounter = 0;

	public static void main(String[] args) throws IOException {
		BufferedWriter writer;
		CSVPrinter csvPrinter = null;
		DriveWalker dw = new DriveWalker();
		try {
			writer = Files.newBufferedWriter(Paths.get("./Output/FinalData.csv", new String[0]), new OpenOption[0]);
			csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(FIELDS));
			long startTime = System.currentTimeMillis();
			dw.walkDir("./Sample Data", writer, csvPrinter);
			long endTime = System.currentTimeMillis();
			logger.writetoLogFile("Total Execution Time: " + (endTime - startTime) + " ms");
			logger.writetoLogFile("Number of Valid Rows: " + validRowCounter);
			logger.writetoLogFile("Number of Skipped Rows: " + skippedRowCounter);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			csvPrinter.flush();
		}
	}

}
