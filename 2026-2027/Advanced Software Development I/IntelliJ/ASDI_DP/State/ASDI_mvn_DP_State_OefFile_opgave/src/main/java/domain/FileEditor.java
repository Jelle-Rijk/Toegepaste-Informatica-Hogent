package domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

public class FileEditor {

    @Setter(AccessLevel.PROTECTED)
    private FileState currentState;
    @Getter
    private final File file;


    /**
     *
     * @param file
     */
    public FileEditor(File file) {
        this.file = file;
        setCurrentState(new Clean(this));
    }

    public boolean edit() {
        return currentState.edit();
    }

    public boolean save() {
        return currentState.save();
    }

}