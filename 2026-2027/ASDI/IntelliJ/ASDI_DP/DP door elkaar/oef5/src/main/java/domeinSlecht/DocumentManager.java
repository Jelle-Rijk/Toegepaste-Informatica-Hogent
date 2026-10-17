package domeinSlecht;

public class DocumentManager {

    public void print(String filePath) {
        if (filePath.endsWith(".xlsx")) {
            Spreadsheet spreadsheet = new Spreadsheet(filePath);
            spreadsheet.print();
        } else { //pptx
            Presentation presentation = new Presentation(filePath);
            presentation.print();
        }
    }

    public void preview(String filePath) {
        if (filePath.endsWith(".xlsx")) {
            Spreadsheet spreadsheet = new Spreadsheet(filePath);
            spreadsheet.preview();
        } else { //pptx
            Presentation presentation = new Presentation(filePath);
            presentation.preview();
        }
    }
}
