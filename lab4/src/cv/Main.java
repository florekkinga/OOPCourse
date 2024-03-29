package cv;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException {
        Document cv = new Document("Jana Kowalski - CV");
        cv.setPhoto("...");
        cv.addSection("Wykształcenie")
                .addParagraph("2000-2005 Przedszkole im. Królewny Snieżki w ...")
                .addParagraph("2006-2012 SP7 im Ronalda Regana w ...")
                .addParagraph("...");
        cv.addSection("Umiejętności")
                .addParagraph(
                        new ParagraphWithList("Umiejętności")
                                .addItemToList("C")
                                .addItemToList("C++")
                                .addItemToList("Java")
                );

        cv.writeHTML(new PrintStream("cv.html","ISO-8859-2"));
    }
}