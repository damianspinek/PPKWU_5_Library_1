package library1;

import static org.junit.Assert.assertTrue;

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

	@Test
	public void shouldsDecompressFile_whenDecompressFileInvoked() throws IOException {
		ZIP.decompressFile("C:\\aaa\\MyFile.zip", "C:\\aaa\\aaaa.jpg");
		File file = new File("C:\\aaa\\aaaa.jpg");
		assertTrue(file.exists());
	}
}
