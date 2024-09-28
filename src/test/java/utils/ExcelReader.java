package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ExcelReader {

    public static String[][] readExcelFile(File file, String sheetNameParam,
                                           boolean hasRowHeader, boolean hasColumnHeader) throws Exception {
        String sheetName;

        if (!file.exists()) {
            System.out.println("Cannot find file " + file.getAbsolutePath());
        }

        if (sheetNameParam == null || sheetNameParam.isEmpty()) {
            sheetName = "0";
        } else {
            sheetName = sheetNameParam;
        }

        System.out.println("Reading sheet " + sheetName + " from file " + file.getAbsolutePath());

        if (file.getName().endsWith("xls")) {
            String errMsg = "*.xls files are not supported. Please save your file as *.xlsx!";
            throw new RuntimeException(errMsg);
        } else if (file.getName().endsWith("xlsx")) {
            return ExcelReader.getData(file, sheetName, hasRowHeader, hasColumnHeader);
        } else {
            String errMsg = "Unsupported file type. Only *.xlsx files are supported";
            throw new RuntimeException(errMsg);
        }
    }

    /**
     * Parses a XLSX file and returns the data in a String[][] object
     *
     * @param hasRowHeader : boolean: true if the file has a header line, false otherwise. In case of true, the first
     *                     line will NOT be returned
     * @return a String[][] array with data from file
     */
    private static String[][] getData(File inputFile, String sheetName,
                                      boolean hasRowHeader, boolean hasColumnHeader) throws Exception {
        String[][] tabArray = null;

        try {
            FileInputStream file = new FileInputStream(inputFile);

            //** Get the workbook instance for XLSX file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //** Get the sheet from the workbook
            XSSFSheet sheet;

            if (sheetName.equals("0")) {
                sheet = workbook.getSheetAt(0);
                System.out.println("Getting data from the first sheet");
            } else {
                sheet = workbook.getSheet(sheetName);
                System.out.println("Getting data from sheet " + sheetName);
            }

            int lastRow = getLastRow(sheet);
            int lastCol = 0;

            //** find the last col (search first row for the last cell with content)
            if (lastRow > 0) {
                lastCol = getLastColumnFromRow(sheet.getRow(0));
            } else {
                System.out.println("0 rows found");
            }

            int arrayRows;
            int arrayCols = lastCol + 1;
            //** set the start row depending of header existence
            int startRow = 0;
            int startCol = 0;
            if (hasRowHeader && lastRow >= 1) {
                startRow = 1;
                arrayRows = lastRow;
            } else {
                arrayRows = lastRow + 1;
            }

            if (hasColumnHeader && lastCol >= 1) {
                startCol = 1;
                arrayCols = lastCol;
            } else {
                arrayCols = arrayCols + 1;
            }


            System.out.println("Creating array of " + arrayRows + " rows and " + arrayCols + " cols");
            tabArray = new String[arrayRows][arrayCols];

            //** iterate the file and add the content to array
            for (int i = startRow; i < lastRow + 1; i++) {
                Row row = sheet.getRow(i);
                int arrayRowIndex = i;
                if (hasRowHeader) {
                    arrayRowIndex = i - 1;
                }
                for (int j = startCol; j < lastCol + 1; j++) {
                    Cell cell = row.getCell(j);

                    int arrayColIndex = j;
                    if (hasColumnHeader) {
                        arrayColIndex = j - 1;
                    }

                    if (cell == null) {
                        tabArray[arrayRowIndex][arrayColIndex] = "";
//                        System.out.println(i + "/" + j + ": blank");
                    } else {
                        switch (cell.getCellType()) {
                            case BOOLEAN:
                                tabArray[arrayRowIndex][arrayColIndex] = String.valueOf(cell.getBooleanCellValue());
//                                System.out.println(i + "/" + arrayColIndex + ": " + String.valueOf(cell.getBooleanCellValue()));
                                break;
                            case NUMERIC:
                                String s = String.valueOf((int) cell.getNumericCellValue());
                                tabArray[arrayRowIndex][arrayColIndex] = s;
//                                System.out.println(i + "/" + j + ": " + s);
                                break;
                            case STRING:
                                tabArray[arrayRowIndex][arrayColIndex] = String.valueOf(cell.getStringCellValue());
//                                System.out.println(i + "/" + j + ": " + String.valueOf(cell.getStringCellValue()));
                                break;
                            default:
                                tabArray[arrayRowIndex][arrayColIndex] = "";
//                                System.out.println(i + "/" + j + ": blank");
                        }
                    }
                }
            }

            file.close();

        } catch (Exception e) {
            System.err.println("Error getting data from file " + inputFile.getCanonicalPath() + ", sheet: " + sheetName);
            e.printStackTrace();
            throw e;
        }

        return tabArray;
    }

    /**
     * Returns the index of the last filled columns of a given row. The first empty cell on that row will be returned
     *
     * @param row The row to be checked
     * @return the index of the last column
     */
    private static int getLastColumnFromRow(Row row) {
        int lastCol = 0;
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {

            Cell firstRowCell = cellIterator.next();

            if (firstRowCell == null) {
                //null cell was found. stop iterator
                break;
            } else if (firstRowCell.getCellType() == CellType.BLANK) {
                //blank cell was found. stop iterator
                break;
            } else {
                //cell with content found. setting this column as last
                lastCol = firstRowCell.getColumnIndex();
            }
        }
//        System.out.println("LAST COLUMN IS " + lastCol);
        return lastCol;
    }

    /**
     * Returns the index of the last used row if a sheet. Used means there is a value in the row's FIRST cell
     *
     * @param sheet the sheet to be checked
     * @return the index of the last row
     */
    private static int getLastRow(XSSFSheet sheet) {
        int lastRow = 0;
        //Iterate to find last row
        for (Row row : sheet) {
            Cell firstColCell = row.getCell(0);

            if (firstColCell == null) {
                //null cell was found. stop iterator
                break;
            } else if (firstColCell.getCellType() == CellType.BLANK) {
                //blank cell was found. stop iterator
                break;
            } else {
                //cell with content found. setting this row as last row
                lastRow = firstColCell.getRowIndex();
            }
        }
//        System.out.println("LAST ROW IS " + lastRow);
        return lastRow;
    }
}
