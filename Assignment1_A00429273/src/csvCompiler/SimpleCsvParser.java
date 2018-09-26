package csvCompiler;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SimpleCsvParser {

	public void readwrite(String sPath, CSVPrinter csvPrinter, String date) {
		String fName;
		String lName;
		String stNumber;
		String street;
		String city;
		String province;
		String postalCode;
		String country;
		String phoneNo;
		String emailID;

		try {
			java.io.Reader in = new FileReader(sPath);
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
			ArrayList<String[]> data = new ArrayList<String[]>();
			for (CSVRecord record : records) {

				if (record.size() <= 10) {

					try {
						fName = record.get(0);
						lName = record.get(1);
						stNumber = record.get(2);
						street = record.get(3);
						city = record.get(4);
						province = record.get(5);
						postalCode = record.get(6);
						country = record.get(7);
						phoneNo = record.get(8);
						emailID = record.get(9);

						// Logic Borrowed from Parijat A00430847 Starts Here!
						if ((fName != null) && (fName != "First Name") && (!"".equals(fName.trim())) && (lName != null)
								&& (!"".equals(lName.trim())) && (stNumber != null) && (!"".equals(stNumber.trim()))
								&& (street != null) && (!"".equals(street.trim())) && (city != null)
								&& (!"".equals(city.trim())) && (province != null) && (!"".equals(province.trim()))
								&& (postalCode != null) && (!"".equals(postalCode.trim())) && (country != null)
								&& (!"".equals(country.trim())) && (phoneNo != null) && (!"".equals(phoneNo.trim()))
								&& (emailID != null) && (!"".equals(emailID.trim()))) {

							data.add(new String[] { fName, lName, stNumber, street, city, province, postalCode, country,
									phoneNo, emailID, date });

							FileReadWrite.validRowCounter += 1;
						} else {

							throw new Exception("Count of Skipped Row");
						}
					} catch (Exception e) {
						FileReadWrite.skippedRowCounter += 1;
					}

					// Logic Borrowed from Parijat (A00430847) Ends Here!
				}
			}
			csvPrinter.printRecords(data);
		} catch (

		IOException localIOException) {
		} catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException) {
		}
	}

}
