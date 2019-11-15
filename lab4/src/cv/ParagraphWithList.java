package cv;

import java.io.PrintStream;

public class ParagraphWithList extends Paragraph {
    public ParagraphWithList(String content) {
        super(content);
    }

    UnorderedList list = new UnorderedList();

    @Override
    ParagraphWithList setContent(String content) {
        this.content = content;
        return this;
    }

    ParagraphWithList addItemToList(ListItem item){
        list.addItem(item);
        return this;
    }

    ParagraphWithList addItemToList(String content){
        list.addItem(content);
        return this;
    }

    void writeHTML(PrintStream out) {
        out.printf("<p>%s\n", content);
        list.writeHTML(out);
        out.println("</p>");
    }
}
