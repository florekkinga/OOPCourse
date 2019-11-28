/**przetwarzanie danych z pliku
 * obługa błędów (interakcja)
 * uruchamianie .jar z parametrami
 * testy jednostkowe i funkcjonalne
 */

package CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader {
    BufferedReader reader;
    String delimiter;
    boolean hasHeader;
    // nazwy kolumn w takiej kolejności, jak w pliku
    List<String> columnLabels = new ArrayList<>();
    // odwzorowanie: nazwa kolumny -> numer kolumny
    Map<String, Integer> columnLabelsToInt = new HashMap<>();
    String[] current;

    /**
     * @param filename  - nazwa pliku
     * @param delimiter - separator pól
     * @param hasHeader - czy plik ma wiersz nagłówkowy
     */

    public CSVReader(String filename, String delimiter, boolean hasHeader) {
        try{
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
        if (hasHeader){
            try{
                parseHeader();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public CSVReader(Reader reader, String delimiter, boolean hasHeader) throws IOException {
        this.reader = new BufferedReader(reader);
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
        if (hasHeader)
            try{
                parseHeader();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public CSVReader (String filename) throws IOException {
        this(filename, ",", true);
    }

    public CSVReader (String filename, String delimiter) throws IOException {
        this(filename, delimiter, true);
    }

    void parseHeader() throws IOException {
        // wczytaj wiersz
        String line = reader.readLine();
        if (line == null) {
            return;
        }
        // podziel na pola
        String[] header = line.split(delimiter);
        // przetwarzaj dane w wierszu
        for (int i = 0; i < header.length; i++) {
            columnLabels.add(header[i]);
            columnLabelsToInt.put(header[i], i);
        }
    }

    boolean next(){
        // czyta następny wiersz, dzieli na elementy i przypisuje do current
        //
        try {
            String line = reader.readLine();
            if (line == null) {
                return false;
            }

            current = line.split(delimiter);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    List<String> getColumnLabels(){
        return columnLabels;
    }

    int getRecordLength(){
        return current.length;
    }

    boolean isMissing(int columnIndex){
        if (columnIndex >= getRecordLength()) return true;
        else return "".equals(current[columnIndex]);
    }

    boolean isMissing(String columnLabel){
        return !columnLabels.contains(columnLabel);
    }

    int getInt(String colummLabel){
        return getInt(columnLabelsToInt.get(colummLabel));
    }

    int getInt(int columnIndex){
        return Integer.parseInt(get(columnIndex));
    }

    String get(int columnIndex){
        return current[columnIndex];
    }

    String get(String columnLabel){
        return current[columnLabelsToInt.get(columnLabel)];
    }

    long getLong(int columnIndex) {
        return Long.parseLong(get(columnIndex));
    }

    long getLong(String columnLabel){
        return getLong(columnLabelsToInt.get(columnLabel));
    }

    double getDouble(int columnIndex){
        return Double.parseDouble(get(columnIndex));
    }

    double getDouble(String columnLabel){
        return getDouble(columnLabelsToInt.get(columnLabel));
    }

}
