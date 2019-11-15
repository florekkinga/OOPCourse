package cv;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class UnorderedList {
    List<ListItem> list = new ArrayList<>();

    UnorderedList addItem(String itemContent){
        ListItem item = new ListItem(itemContent);
        list.add(item);
        return this;
    }

    UnorderedList addItem(ListItem item){
        list.add(item);
        return this;
    }

    void writeHTML(PrintStream out){
        out.println("<ul>");
        for(ListItem item : list) {
            item.writeHTML();
        }
        out.println("</ul>");
    }
}
