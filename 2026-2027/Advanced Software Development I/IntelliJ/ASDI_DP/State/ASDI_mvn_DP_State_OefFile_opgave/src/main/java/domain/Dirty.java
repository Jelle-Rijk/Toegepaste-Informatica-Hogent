package domain;

public class Dirty extends FileState {

    public Dirty(FileEditor file) {
        super(file);
    }

    @Override
    public boolean save() {
        file.setCurrentState(new Clean(file));
        return true;
    }
}