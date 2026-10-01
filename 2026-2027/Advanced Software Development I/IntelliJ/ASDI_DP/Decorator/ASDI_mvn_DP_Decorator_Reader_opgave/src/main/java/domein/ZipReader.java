package domein;

public class ZipReader extends ReaderDecorator {

    public String read() {
        return "zip " + reader.read();
    }

    /**
     *
     * @param reader
     */
    public ZipReader(Reader reader) {
        super(reader);
    }

}