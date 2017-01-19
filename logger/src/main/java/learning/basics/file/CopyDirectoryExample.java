package learning.basics.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyDirectoryExample {
    public static void main(String[] args) {
        File srcFolder = new File("d:\\1");
        File destFolder = new File("d:\\2");

        // make sure source exists
        if (!srcFolder.exists()) {

            // just exit
            System.exit(0);

        } else {

            try {
                copyFolder(srcFolder, destFolder);
            } catch (IOException e) {
                e.printStackTrace();
                // error, just exit
                System.exit(0);
            }
        }

    }

    public static void copyFolder(File src, File dest) throws IOException {

        if (src.isDirectory()) {
            
            System.out.println("Currently processing directory : " +src.getAbsolutePath() );

            // if directory not exists, create it
            if (!dest.exists()) {
                dest.mkdir();
            }

            // list all the directory contents
            String files[] = src.list();

            for (String file : files) {
                // construct the src and dest file structure
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                // recursive copy
                copyFolder(srcFile, destFile);
            }

        } else {
            System.out.println("Currently processing file : " +src.getAbsolutePath() );
            // if file, then copy it
            // Use bytes stream to support all file types
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            int length;
            // copy the file content in bytes
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
            System.out.println("File copied from " + src + " to " + dest);
        }
    }
}
