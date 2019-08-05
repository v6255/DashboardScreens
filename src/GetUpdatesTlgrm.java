import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

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


        //System.out.println(jobs);
        String FileListJobs = "C:/DashboardScreens";
        File addfolder = new File(FileListJobs);
        addfolder.mkdirs();
        File file = new File(FileListJobs + "/" + "message.log");

        ArrayList list_job_pref = getRunJob(file);
        // ArrayList list_job_pref = readFile(file);
        //System.out.println(list_job_pref);
        String inputLine;
       /* while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);*/
        List jobs = new ArrayList();
        while ((inputLine = in.readLine()) != null)
            jobs.add(inputLine);
        FileWriter fw = new FileWriter(file);
        for (int i = 0; i < jobs.size(); i++) {
            //System.out.println(jobs.get(i).getText());
            String newLine = System.getProperty("line.separator");
            fw.write(jobs.get(i) + newLine+newLine);
            //fw.write("New_job");
            fw.flush();
        }
        ArrayList list_job_new = getRunJob(file);
        //ArrayList list_job_new = readFile(file);
        //Integer result = compare(list_job_pref,list_job_new);
        Integer result = comparenew2(list_job_new, list_job_pref);
        System.out.println(result);
        //System.out.println(list_job_new);
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
            //ArrayList job_run = new ArrayList();
            FileInputStream fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine.contains("Dashboard")) {
                    //String br1 = br.readLine();
                    //String br2 = br.readLine();
                    //list.add(strLine + " " + br1 + " " + br2);
                    list.add(strLine);
                    //System.out.println(list.get(0));
                    //System.out.println(strLine + " " + br1 + " " + br2);
                }
            }
            return list;
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
        return null;
    }

    public static ArrayList readFile(File file) {
        try {
            ArrayList list = new ArrayList();
            //ArrayList job_run = new ArrayList();
            FileInputStream fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                //list.add(strLine + " " + br1 + " " + br2);
                list.add(strLine);
                //System.out.println(list.get(0));
                //System.out.println(strLine + " " + br1 + " " + br2);
            }
            return list;
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
        return null;
    }

    public static int compare(ArrayList list1, ArrayList list2) {
        int result = 0;
        System.out.println(list1.size());
        System.out.println(list2.size());
        if (list1.size() > list2.size()) {
            for (int i = 0; i < list1.size(); i++) {

                for (int j = 0; j < list2.size(); j++) {
                    boolean result1 = list1.get(i).equals(list2.get(j));
                    //System.out.println(result);
                    if (result1 == false) {
                        result++;
                        //System.out.println(list1.get(i));
                        //Logger(LogFolder, " " + list1.get(i).toString());
                        //System.out.println(list2.get(j));
                    }
                }
            }
        } else {
            for (int i = 0; i < list2.size(); i++) {

                for (int j = 0; j < list1.size(); j++) {
                    boolean result1 = list2.get(i).equals(list1.get(j));
                    //System.out.println(result);
                    if (result1 == true) {
                        result++;
                        // System.out.println(list2.get(i));
                        //Logger(LogFolder, " " + list2.get(i).toString());
                        //System.out.println(list1.get(j));
                    }
                }
            }
        }

        return result;
    }
    public static int comparenew2(ArrayList list1, ArrayList list2) {
        int result = 0;
        System.out.println(list1.size());
        System.out.println(list2.size());
        if (list1.size() > list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                System.out.println(list1.get(i));
                System.out.println(list2.get(i));
                    boolean result1 = list1.get(i).equals(list2.get(i));
                    //System.out.println(result);
                    if (result1 == false) {
                        result++;
                        //System.out.println(list1.get(i));
                        //Logger(LogFolder, " " + list1.get(i).toString());
                        //System.out.println(list2.get(j));

                }
            }
        } else {
            for (int i = 0; i < list2.size(); i++) {

                    boolean result1 = list2.get(i).equals(list1.get(i));
                    //System.out.println(result);
                    if (result1 == false) {
                        result++;
                        // System.out.println(list2.get(i));
                        //Logger(LogFolder, " " + list2.get(i).toString());
                        //System.out.println(list1.get(j));
                    }
                }
            }
        // Object obj = new JSONParser().parse(new FileReader("JSONExample.json"));
        Object obj;
        obj = new JSONParser().parse(list1.get(1));
// Кастим obj в JSONObject
        JSONObject jo = (JSONObject) obj;
// Достаём firstName and lastName
        String firstName = (String) jo.get("firstName");
        String lastName = (String) jo.get("lastName");
        System.out.println("fio: " + firstName + " " + lastName);

        return result;
    }

    public static int comparenew(ArrayList list1, ArrayList list2) {
        int result = 0;
        System.out.println(list1.size());
        System.out.println(list2.size());
        for (int i = 0; i < list2.size(); i++) {
            boolean result1 = list2.get(i).equals(list1.get(i));
            //System.out.println(result);
            if (result1 == false) {
                result++;
                // System.out.println(list2.get(i));
                //Logger(LogFolder, " " + list2.get(i).toString());
                //System.out.println(list1.get(j));
            }


        }

        return result;
    }
    /*public static String getWeather(String message, Model model) throws IOException {

        //URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + message + "&units=metric&appid=6fff53a641b9b9a799cfd6b079f5cd4e");
        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + message + "&units=metric&appid=104006bd15db67b843cdff348cfd8099");

        Scanner in = new Scanner((InputStream) url.getContent());

        String result = "";

        while (in.hasNext()) {

            result += in.nextLine();

        }

        JSONObject object = new JSONObject(result);

        model.setName(object.getString("name"));

        JSONObject main = object.getJSONObject("main");

        model.setTemp(main.getDouble("temp"));

        model.setHumidity(main.getDouble("humidity"));

        JSONArray getArray = object.getJSONArray("weather");

        for (int i = 0; i < getArray.length(); i++) {

            JSONObject obj = getArray.getJSONObject(i);

            model.setIcon((String) obj.get("icon"));

            model.setMain((String) obj.get("main"));

        }

        return "Город: " + model.getName() + "\n" +

                "Температура: " + model.getTemp() + "C" + "\n" +

                "Влажность: " + model.getHumidity() + "%" + "\n" +

                "Состояние: " + model.getMain() + "\n";

        //+ "http://openweathermap.org/img/w/" + model.getIcon() + ".png";

    }*/
}
