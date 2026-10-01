package main;
import domain.FileEditor;

import java.io.File;

public class StartUp {

    public void main() {
        FileEditor file = new FileEditor(new File("opgave")); //clean

        //clean -> dirty
        boolean uitgevoerd = file.edit();
        IO.println("true = " + uitgevoerd);

        //dirty -> clean
        uitgevoerd = file.save();
        IO.println("true = " + uitgevoerd);

        uitgevoerd = file.save();
        IO.println("false = " + uitgevoerd);

        //clean -> dirty
        uitgevoerd = file.edit();
        IO.println("true = " + uitgevoerd);

        uitgevoerd = file.edit();
        IO.println("false = " + uitgevoerd);
        //dirty -> clean
        uitgevoerd = file.save();
        IO.println("true = "+ uitgevoerd);
    }
}
