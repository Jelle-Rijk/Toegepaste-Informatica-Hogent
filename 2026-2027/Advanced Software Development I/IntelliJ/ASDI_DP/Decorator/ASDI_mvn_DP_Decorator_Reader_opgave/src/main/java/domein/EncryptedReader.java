package domein;

public class EncryptedReader extends ReaderDecorator {

    public String read() {
        return "encrypted " + reader.read();
    }

    /**
     *
     * @param reader
     */
    public EncryptedReader(Reader reader) {
        super(reader);
    }

}