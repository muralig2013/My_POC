package learning.basics.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFileExample {
    public static void main(String[] args) {

        InputStream inStream = null;
        OutputStream outStream = null;

        try {
            CopyDirectoryExample cd = new CopyDirectoryExample();

            File afile = new File("\\AFile.txt");
            File bfile = new File("//Bfile.txt");

            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(bfile);

            byte[] buffer = new byte[1024];

            int length;
            // copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0) {

                outStream.write(buffer, 0, length);

            }

            System.out.println("File is copied successful!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inStream != null && outStream != null) {
                    inStream.close();
                    outStream.close();
                }else if(inStream == null && outStream != null){
                    outStream.close();
                }else if(inStream != null && outStream == null){
                    inStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
