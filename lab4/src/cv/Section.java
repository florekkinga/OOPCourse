package cv;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Section {
    String title;
    List<Paragraph> paragraphs = new ArrayList<>();

    Section(String title){
        this.title=title;
    }
    Section setTitle(String title){
        this.title = title;
    }
    Section addParagraph(String paragraphText){

    }
    Section addParagraph(Paragraph p){

    }
    void writeHTML(PrintStream out){
        out.println("<div>");
        out.printf("<h2>%s</h2>\n", title);
        for (Paragraph paragraph: paragraphs)
            paragraph.writeHTML(out);
        out.println("</div>");
    }
}
