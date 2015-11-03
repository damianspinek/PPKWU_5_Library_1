package library1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZIP {
	public static void compressFile(String sourcePath, String destinationPath) {
		zipSingleFile(new File(sourcePath), destinationPath);
	}
	
	private static void zipSingleFile(File file, String zipFileName) {
        try {
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
            System.out.println(file.getCanonicalPath()+" is zipped to "+zipFileName);
             
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
}
