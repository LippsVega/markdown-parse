import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertNotEquals(2, 1 + 1);
    }

    @Test
    public void testFile() throws IOException {
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("https://something.com", "some-page.html"), links);
    }

    @Test
    public void testImageFile() throws IOException {
        Path fileName = Path.of("image-file.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("https://something.com"), links);
    }

    @Test
    public void testFirstLine() throws IOException {
        Path fileName = Path.of("firstline.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("https://something.com"), links);
    }

    @Test
    public void testFormat() throws IOException {
        Path fileName = Path.of("format.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of(), links);
    }
}