package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVUtils {

    public static List<String[]> readCsv(String filePath) throws IOException, CsvException {
        //read csv file
        File file = new File(filePath);

        Reader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
        CSVReader csvReader = new CSVReader(reader);
        return csvReader.readAll();
    }
}
