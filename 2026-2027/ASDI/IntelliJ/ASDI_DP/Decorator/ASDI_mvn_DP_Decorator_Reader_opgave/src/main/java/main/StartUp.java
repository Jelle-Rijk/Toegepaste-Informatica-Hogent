package main;

import domein.EncryptedReader;
import domein.FileReader;
import domein.Reader;
import domein.ZipReader;

public class StartUp {

    public void main() {
//
        Reader file = new FileReader("tekst.txt");
//    	FileReader
//    	ZipReader
//    	EncryptedReader
//
        // zip the file "tekst.txt":
        Reader zip = new ZipReader(file);

        // encrypt the file "tekst.txt":
        Reader enc = new EncryptedReader(file);

        // encrypt the zip file:
        Reader enc2 = new EncryptedReader(zip);

        // encrypt the file, zip the file and encrypt the file:
        Reader enc3 = new EncryptedReader(new ZipReader(enc));

        IO.println(zip.read());
        IO.println(enc.read());
        IO.println(enc2.read());
        IO.println(enc3.read());

    }
}