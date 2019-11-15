package cv;

import sun.swing.SwingUtilities2;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Document {
    String title;
    Photo photo;
    List<Section> sections = new ArrayList<>();

    Document(String title){
        this.title=title;
    }

    Document setTitle(String title){
        this.title = title;
        return this;
    }

    Document setPhoto(String photoUrl){
        // ???
        return this;
    }

    Section addSection(String sectionTitle){
        Section newsection = new Section(sectionTitle);
        sections.add(newsection);
        return newsection;
    }

    Document addSection(Section s){
        return this;
    }


    void writeHTML(PrintStream out){
        // zapisz niezbędne znaczniki HTML
        // dodaj tytuł i obrazek
        // dla każdej sekcji wywołaj section.writeHTML(out)
    }
}

