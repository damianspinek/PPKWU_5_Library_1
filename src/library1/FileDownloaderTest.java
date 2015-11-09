package library1;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class FileDownloaderTest {

	@Test
	public void shouldDownloadFile_whenDownloadFileInvoked() throws IOException {
		FileDownloader.downloadFile("http://kanonierzy.com/images/news/arsenal_druzyna87.jpg", "C:\\aaa\\file");
		File file = new File("C:\\aaa\\file.jpg");
		Assert.assertTrue(file.exists());
	}
}
