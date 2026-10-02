package domein;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FileReader implements Reader {

    private final String fileName;

    public String read() {
        return fileName.matches(".+\\.*") ? fileName.split("\\.")[0] : fileName;
    }

}