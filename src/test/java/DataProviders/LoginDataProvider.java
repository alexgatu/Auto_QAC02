package DataProviders;

import ObjectModels.LoginModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.exceptions.CsvException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.testng.annotations.DataProvider;
import utils.CSVUtils;
import utils.DatabaseUtils;
import utils.ExcelReader;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    /* ####################################################### JSON DATA PROVIDER ##########################################  */

    @DataProvider(name = "loginJsonDataProvider")
    public Iterator<Object[]> loginJsonDataProvider() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
//      here we will map json to LoginModel
        File jsonFile = new File("src/test/resources/testData/testDataInput.json");

        ObjectMapper objectMapper = new ObjectMapper();
        LoginModel[] loginModelList = objectMapper.readValue(jsonFile, LoginModel[].class);

        for (LoginModel lm : loginModelList)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }

    /* ####################################################### XML DATA PROVIDER ##########################################  */
    @DataProvider(name = "loginXMLDataProvider")
    public Iterator<Object[]> loginXMLDataProvider() throws JAXBException {
        Collection<Object[]> dp = new ArrayList<>();
//      here we will map json to LoginModel
        File xmlFile = new File("src/test/resources/testData/testDataInput.xml");

        LoginModel loginModel = (LoginModel) unMarshalObjectModel(xmlFile, LoginModel.class);

//       adding to data provider
        dp.add(new Object[]{loginModel});
        return dp.iterator();
    }

    private Object unMarshalObjectModel(File f, Class<?>... classesToBeBound) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);

//        loading xml and mapped based on tags added on LoginModel and AccountModel
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return unmarshaller.unmarshal(f);
    }

    /* ####################################################### CSV DATA PROVIDER ##########################################  */

    @DataProvider(name = "loginCSVDataProvider")
    public Iterator<Object[]> loginCSVDataProvider() throws JAXBException, IOException, CsvException {
        Collection<Object[]> dp = new ArrayList<>();
//      here we will map json to LoginModel
        List<String[]> csvData = CSVUtils.readCsv("src/test/resources/testData/testDataInput.csv");

        int usernameIndex = 0, passwordIndex = 1, loginErrIndex = 2;

//        starting from 1 because we have header with legend
        for (int i = 1; i < csvData.size(); i++) {
            String[] line = csvData.get(i);
            LoginModel loginModel = new LoginModel(line[usernameIndex], line[passwordIndex], line[loginErrIndex]);
            dp.add(new Object[]{loginModel});
        }

        return dp.iterator();
    }

    /* ####################################################### CSV DATA PROVIDER ##########################################  */

    @DataProvider(name = "loginXLSXDataProvider")
    public Iterator<Object[]> loginXLSXDataProvider() throws Exception {
        Collection<Object[]> dp = new ArrayList<>();
//      here we will map json to LoginModel
        String[][] dataExcelValues = ExcelReader.readExcelFile(new File("src/test/resources/testData/testDataInput.xlsx"), "0", true, false);

        int usernameIndex = 0, passwordIndex = 1, loginErrIndex = 2;

//        starting from 1 because we have header with legend
        for (int i = 1; i < dataExcelValues.length; i++) {
            String[] line = dataExcelValues[i];
            LoginModel loginModel = new LoginModel(line[usernameIndex], line[passwordIndex], line[loginErrIndex]);
            dp.add(new Object[]{loginModel});
        }

        return dp.iterator();
    }


    /* ####################################################### SQL DATA PROVIDER ##########################################  */

    @DataProvider(name = "loginSQLDataProvider")
    public Iterator<Object[]> loginSQLDataProvider() throws JAXBException, IOException, CsvException, SQLException {
        Collection<Object[]> dp = new ArrayList<>();
        DatabaseUtils databaseUtils = new DatabaseUtils();
//     connect to DB and get data
        Connection connection = databaseUtils.connect();
        Statement statement = databaseUtils.getStatement(connection);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM login");

        while (resultSet.next()) {
            LoginModel loginModel = new LoginModel(databaseUtils.getElementFromDB(resultSet, "username"),
                    databaseUtils.getElementFromDB(resultSet, "password"),
                    databaseUtils.getElementFromDB(resultSet, "loginError"));
            dp.add(new Object[]{loginModel});
        }

        return dp.iterator();
    }
}
