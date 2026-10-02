package domain;

public abstract class FileState {

    protected FileEditor file;

    public FileState(FileEditor file) {
        this.file = file;
    }

    public boolean edit() {
        return false;
    }

    public boolean save() {
        return false;
    }

}