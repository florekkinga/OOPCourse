package CSVReader;

import java.io.IOException;
import java.util.Locale;

public class Main {

    public static void main(String args[]) throws IOException {

        CSVReader reader = new CSVReader(args[0],";",true);
        while(reader.next()){
            String id = reader.get(0);
            String imie = reader.get(1);
            String nazwisko = reader.get(2);
            String ulica = reader.get("ulica");
            String nrdomu = reader.get("nrdomu");
            String nrmieszkania = reader.get("nrmieszkania");

            System.out.printf("%s %s %s %s %s %s\n", id, imie, nazwisko,
                    ulica, nrdomu, nrmieszkania);

            //System.out.printf(Locale.US,"%d %s \n",id, name);
        }

    }
}
