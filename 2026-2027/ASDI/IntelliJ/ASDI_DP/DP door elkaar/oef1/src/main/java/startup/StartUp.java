package startup;

import domein.Kader;
import domein.Scrollbar;
import domein.Tekstveld;
import domein.TextView;

public class StartUp {
    static void main() {

        TextView view1 = new Scrollbar(new Kader(5, new Tekstveld()));
        TextView view2 = new Kader(10, new Scrollbar(new Kader(2, new Scrollbar(new Tekstveld()))));

        IO.println(view1.toon());
        IO.println();
        IO.println(view2.toon());
    }

}
