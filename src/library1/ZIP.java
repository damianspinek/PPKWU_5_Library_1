package library1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZIP {
	public static void compressFile(String sourcePath, String destinationPath) throws IOException {
		zipSingleFile(new File(sourcePath), destinationPath);
	}

	private static void zipSingleFile(File file, String zipFileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(zipFileName);
		ZipOutputStream zos = new ZipOutputStream(fos);
		ZipEntry ze = new ZipEntry(file.getName());
		zos.putNextEntry(ze);
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		int len;
		while ((len = fis.read(buffer)) > 0) {
			zos.write(buffer, 0, len);
		}

		zos.closeEntry();
		zos.close();
		fis.close();
		fos.close();
		System.out.println(file.getCanonicalPath() + " is zipped to " + zipFileName);
	}

	public static void decompressFile(String zipFilePath, String filePath) throws IOException {
		String destinationname = filePath;
		byte[] buf = new byte[1024];
		ZipInputStream zipinputstream = null;
		ZipEntry zipentry;
		zipinputstream = new ZipInputStream(new FileInputStream(zipFilePath));
		zipentry = zipinputstream.getNextEntry();
		while (zipentry != null) {
			String entryName = zipentry.getName();
			FileOutputStream fileoutputstream;
			File newFile = new File(entryName);
			String directory = newFile.getParent();

			if (directory == null) {
				if (newFile.isDirectory())
					break;
			}
			fileoutputstream = new FileOutputStream(destinationname);
			int n;
			while ((n = zipinputstream.read(buf, 0, 1024)) > -1) {
				fileoutputstream.write(buf, 0, n);
			}
			fileoutputstream.close();
			zipinputstream.closeEntry();
			zipentry = zipinputstream.getNextEntry();
		}
		zipinputstream.close();
	}
}
