import java.io.File;

public class FtpToTlgrm {
    public static void main(String[] args) throws InterruptedException {
        File screen = CreateScreen.Create_screen();
        FtpSender.SendFile("ftp-srv63801.ht-systems.ru", "srv63801_dash", "Jg7p73H5", "E:\\vsilich\\JAVA\\screens\\4.png", "5.png");
    }
}

