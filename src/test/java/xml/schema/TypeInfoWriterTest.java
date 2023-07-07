package xml.schema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

class TypeInfoWriterTest {

    private TypeInfoWriter writer;
    private OutputStream out;

    @BeforeEach
    void setUp() throws UnsupportedEncodingException {
        writer = new TypeInfoWriter();
        out = new ByteArrayOutputStream();
        writer.setOutput(out, "UTF-8");
    }

    @Test
    void testStartDocument() throws SAXException {
        // Start the document
        writer.startDocument();

        // Verify the output
        String expectedOutput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    void testStartElement() throws SAXException {
        // Start an element
        writer.startElement("http://example.com", "foo", "foo", null);

        // Verify the output
        String expectedOutput = "<foo xmlns=\"http://example.com\">";
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    void testEndElement() throws SAXException {
        // Start an element
        writer.startElement("http://example.com", "foo", "foo", null);
        writer.endElement("http://example.com", "foo", "foo");

        // Verify the output
        String expectedOutput = "<foo xmlns=\"http://example.com\"/>";
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    void testError() throws SAXException {
        // Create a SAXParseException
        SAXParseException ex = new SAXParseException("Error message", null, null, 1, 1, null);

        // Write the error to the output stream
        writer.error(ex);

        // Verify the output
        String expectedOutput = "[Error] :1:1: Error message";
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    void testWarning() throws SAXException {
        // Create a SAXParseException
        SAXParseException ex = new SAXParseException("Warning message", null, null, 1, 1, null);

        // Write the warning to the output stream
        writer.warning(ex);

        // Verify the output
        String expectedOutput = "[Warning] :1:1: Warning message";
        assertEquals(expectedOutput, out.toString());
    }
}