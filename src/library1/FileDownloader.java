package library1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FileDownloader {
	
	public static void downloadFile(String sourcePath, String destinationPath) throws IOException {
		
		String[] string = sourcePath.split("\\.");
		String fileExtension = string[string.length - 1];
		
		URL website = new URL(sourcePath);
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream(destinationPath + fileExtension);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
	}
}
