import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class GetUpdatesTlgrm {
    public static void main(String[] args) throws IOException {
        // System.out.println("hello");
        String url = "http://dwar666.herokuapp.com/myhooker.php?token=891657525:AAF-5Mcr9PNhceswBkDGcE_xi5tgVyZOUPY&method=getUpdates?offset=-10";
        URLConnection connection = new URL(url).openConnection();
        connection.setUseCaches(false);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));
        String inputLine;


       /* while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);*/

        List jobs = new ArrayList();
        while ((inputLine = in.readLine()) != null)
                jobs.add(inputLine);

        System.out.println(jobs);
        String FileListJobs = "C:/DashboardScreens";
        File addfolder = new File(FileListJobs);
        addfolder.mkdirs();
        File file = new File(FileListJobs + "/" + "message.log");

        //ArrayList list_job_pref = getRunJob(file);


        FileWriter fw = new FileWriter(file);
        for (int i = 0; i < jobs.size(); i++) {
            //System.out.println(jobs.get(i).getText());
            String newLine = System.getProperty("line.separator");
            //fw.write("{New_job}" + newLine + jobs.get(i) + newLine + newLine);
            fw.write("New_job");
        }
       // ArrayList list_job_new = getRunJob(file);

        //подгружаем файл1 и запоминаем массив
        //заполняем массив новыми объектами
        //сравниваем два списка
        //если списки раличаются то выводим какой объект отличается
        // парсим с этого объекта данные по тексту
        // если в тексте находиться dash
        // то парсится chat id
        // и отправляется http запрос
        in.close();
    }
        public static ArrayList getRunJob(File file) {
            try {
                ArrayList list = new ArrayList();
                ArrayList job_run = new ArrayList();
                FileInputStream fstream = new FileInputStream(file);
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    if (strLine.contains("RUNNING")) {
                        String br1 = br.readLine();
                        String br2 = br.readLine();
                        list.add(strLine + " " + br1 + " " + br2);
                        // System.out.println(strLine + " " + br1 + " " + br2);
                    }
                }
                return list;
            } catch (IOException e) {
                System.out.println("Ошибка");
            }
            return null;
        }
}
