
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String base_path = "e:\\part4\\errors_code_all\\";
    private static final String base_url = "http://printcopy.info/";
    private static BufferedWriter fw;
    private static String brand = null;

    public static void main(String[] args) throws IOException, InterruptedException {

//        Document brandDoc = Jsoup.connect("http://printcopy.info/?l=ru&mod=erc").get();
//        Elements brandListElements = brandDoc.getElementsByAttributeValue("class", "listBv brandList");
//
//        for (Element brandElement : brandListElements.select("li")) {
//            brand = brandElement.text();//.replace("-", " ");
//            System.out.println(brand);
//
//            File filePath = new File(base_path+"\\"+brand);
//            if (!filePath.exists()) {
//                filePath.mkdir();
//            }
//
////            Thread.sleep(4000);
//
//            File dir = new File(base_path+"\\"+brand);
//            File[] arrFiles = dir.listFiles();
//            List<File> lst = Arrays.asList(arrFiles);

            Document modelsDoc = Jsoup.connect("http://printcopy.info/?l=ru&mod=erc&brand=" + brand).get();
            Elements modelsListElements = modelsDoc.getElementsByAttributeValue("class", "modelsList");
            fw = new BufferedWriter(new PrintWriter(base_path+"\\"+brand+"\\"+brand+"_url_list"));
            for (Element modelElement: modelsListElements.select("li")){
                String model = modelElement.text();
                Element aElement = modelElement.child(0);
                String model_url = aElement.attr("href");
                fw.write(model_url+"\r\n");
//                System.out.println(model);

//                Thread.sleep(4000);
//                fw = new BufferedWriter(new PrintWriter(base_path+"\\"+brand+"\\"+model));
//
//                Document errorsDoc = Jsoup.connect(base_url + model_url).get();
//                Elements pageCount = errorsDoc.getElementsByAttributeValue("class","item");
//                int iCount = Integer.parseInt(pageCount.last().text().replaceAll("[a-z]","").trim());
//                ErrorsCodeParser(errorsDoc);
//                for (int i = 2; i < iCount+1; i++){
//                    Thread.sleep(4000);
//                    String nextpage = model_url + "&page=" + i;
//                    errorsDoc = Jsoup.connect(base_url + nextpage).get();
//                    ErrorsCodeParser(errorsDoc);
//                }
//
//                fw.close();

//                break;
            }
            fw.close();
//            Thread.sleep(10000);
//            break;
//        }
    }

    static void ErrorsCodeParser (Document document) throws IOException {
        Elements errorListElement;

        errorListElement = document.getElementsByAttributeValue("class", "ercList");

        for (Element errorList : errorListElement.select("li")) {
            fw.write(errorList.text()+"\r\n");
        }
    }

    public Boolean getFileName(){
        File file = new File(base_path);
        File[] files = file.listFiles();

        for (File file1 : files){
            String s = file1.getPath();
            System.out.println(s);
        }
        return true;
    }

//    static void brandParser (Document document) throws IOException {
//        Elements brandListElements = document.getElementsByAttributeValue("class", "listBv brandList");
//
//        for (Element brandElement : brandListElements.select("li")) {
//            brand = brandElement.text();//.replace("-", " ");
////            System.out.println(brand);
////
////            File filePath = new File(base_path+"\\"+brand);
////            if (!filePath.exists()) {
////                filePath.mkdir();
//        }
//
//    }
}
