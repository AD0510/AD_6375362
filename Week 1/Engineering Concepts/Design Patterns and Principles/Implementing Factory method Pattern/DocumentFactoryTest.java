import java.io.FileWriter;
import java.io.IOException;

// Document.java (Interface)
interface Document {
    void open();
    void save(String fileName); // Modified to accept file name
    void close();
}

// WordDocument.java
class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word Document...");
    }

    @Override
    public void save(String fileName) {
        try (FileWriter writer = new FileWriter(fileName + ".docx")) {
            writer.write("This is a simulated Word document content.");
            System.out.println("Saving Word Document to " + fileName + ".docx");
        } catch (IOException e) {
            System.err.println("Error saving Word Document: " + e.getMessage());
        }
    }

    @Override
    public void close() {
        System.out.println("Closing Word Document...");
    }
}

// PdfDocument.java
class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document...");
    }

    @Override
    public void save(String fileName) {
        try (FileWriter writer = new FileWriter(fileName + ".pdf")) {
            writer.write("This is a simulated PDF document content.");
            System.out.println("Saving PDF Document to " + fileName + ".pdf");
        } catch (IOException e) {
            System.err.println("Error saving PDF Document: " + e.getMessage());
        }
    }

    @Override
    public void close() {
        System.out.println("Closing PDF Document...");
    }
}

// ExcelDocument.java
class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Document...");
    }

    @Override
    public void save(String fileName) {
        try (FileWriter writer = new FileWriter(fileName + ".xlsx")) {
            writer.write("This is a simulated Excel document content.");
            System.out.println("Saving Excel Document to " + fileName + ".xlsx");
        } catch (IOException e) {
            System.err.println("Error saving Excel Document: " + e.getMessage());
        }
    }

    @Override
    public void close() {
        System.out.println("Closing Excel Document...");
    }
}

// DocumentFactory.java (Abstract Class)
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// WordDocumentFactory.java
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

// PdfDocumentFactory.java
class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

// ExcelDocumentFactory.java
class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// DocumentFactoryTest.java
public class DocumentFactoryTest {
    public static void main(String[] args) {
        System.out.println("--- Creating Word Document ---");
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save("my_word_document"); // Provide a file name
        wordDoc.close();

        System.out.println("\n--- Creating PDF Document ---");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save("my_pdf_document"); // Provide a file name
        pdfDoc.close();

        System.out.println("\n--- Creating Excel Document ---");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.save("my_excel_document"); // Provide a file name
        excelDoc.close();

        System.out.println("\nCheck your project directory for the created files!");
    }
}