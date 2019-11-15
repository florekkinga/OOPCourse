package cv;

import java.io.PrintStream;

public class Paragraph {
    String content;

    Paragraph(String content){
        this.content = content;
    }

    Paragraph setContent(String content) {
        this.content = content;
        return this;
    }

    void writeHTML(PrintStream out){
        this.content="<p>"+content+"</p>";
    }

}

