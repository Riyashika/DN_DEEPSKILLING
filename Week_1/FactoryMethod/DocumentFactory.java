public abstract class DocumentFactory {
    public abstract Document createDocument();
    public void openDocument() {
        Document doc = createDocument();
        System.out.println("Document type: " + doc.getDocumentType());
        doc.open();
        doc.save();
    }
}
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        System.out.println("WordDocumentFactory: Creating a Word document...");
        return new WordDocument();
    }
}
class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        System.out.println("PdfDocumentFactory: Creating a PDF document...");
        return new PdfDocument();
    }
}
class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        System.out.println("ExcelDocumentFactory: Creating an Excel document...");
        return new ExcelDocument();
    }
}
class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Test ===\n");
        System.out.println("--- Word Document ---");
        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.openDocument();
        System.out.println();
        System.out.println("--- PDF Document ---");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.openDocument();
        System.out.println();
        System.out.println("--- Excel Document ---");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.openDocument();
    }
}
