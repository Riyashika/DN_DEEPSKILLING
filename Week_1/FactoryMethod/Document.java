public interface Document {
    void open();
    void save();
    String getDocumentType();
}
class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word Document... (Microsoft Word launched)");
    }
    @Override
    public void save() {
        System.out.println("Saving Word Document as .docx file...");
    }
    @Override
    public String getDocumentType() {
        return "Word Document (.docx)";
    }
}
class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document... (Adobe Reader launched)");
    }
    @Override
    public void save() {
        System.out.println("Saving PDF Document as .pdf file...");
    }
    @Override
    public String getDocumentType() {
        return "PDF Document (.pdf)";
    }
}
class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Document... (Microsoft Excel launched)");
    }
    @Override
    public void save() {
        System.out.println("Saving Excel Document as .xlsx file...");
    }
    @Override
    public String getDocumentType() {
        return "Excel Document (.xlsx)";
    }
}
