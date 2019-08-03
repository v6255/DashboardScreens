import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;


public class FtpSender {

    public static void SendFile(String host, String user, String pass, String filePath, String uploadPath) {
/*
        String ftpUrl = "ftp://%s:%s@%s/%s;type=i";
        String host = "ftp-srv63801.ht-systems.ru";
        String user = "srv63801_dash";
        String pass = "Jg7p73H5";
        String filePath = "E:\\vsilich\\JAVA\\screens\\4.png";
        String uploadPath = "4.png";
*/
        String ftpUrl = "ftp://%s:%s@%s/%s;type=i";

        ftpUrl = String.format(ftpUrl, user, pass, host, uploadPath);
        System.out.println("Upload URL: " + ftpUrl);

        try {
            URL url = new URL(ftpUrl);
            URLConnection conn = url.openConnection();
            OutputStream outputStream = conn.getOutputStream();
            FileInputStream inputStream = new FileInputStream(filePath);

            byte[] buffer = new byte[1024];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();

            System.out.println("File uploaded");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }



}
