package library1;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class ZIPTest {

	@Test
	public void shouldsCompressFile_whenCompressFileInvoked() throws IOException {
		ZIP.compressFile("C:\\aaa\\file.jpg", "C:\\aaa\\MyFile.zip");
		File file = new File("C:\\aaa\\MyFile.zip");
		assertTrue(file.exists());
	}
}
