package domain;

public class Clean extends FileState {

    public Clean(FileEditor file) {
        super(file);
    }

    @Override
    public boolean edit() {
        file.setCurrentState(new Dirty(file));
        return true;
    }

}