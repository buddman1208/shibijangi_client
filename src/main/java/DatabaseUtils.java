import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Junseok on 2016-12-06.
 */
public class DatabaseUtils {
    public DatabaseUtils() {
        printArray(getFinanceArray(false));
    }

    ArrayList<String> arrayList = new ArrayList<String>();

    public ArrayList<String> getFinanceArray(boolean isTitle) {
        String CSSQuery = (isTitle) ? "td.tit" : "td.sale";
        Document doc = null;
        try {
            doc = Jsoup.connect("http://info.finance.naver.com/marketindex/exchangeList.nhn").get();
        } catch (IOException e) {   
            e.printStackTrace();
        }
        Elements data = doc.select(CSSQuery);
        for (Element datas : data) {
            arrayList.add(datas.text());
        }
        if (CSSQuery.equals("td.sale"))
            arrayList.set(3, Float.parseFloat(arrayList.get(3).replace(",", "")) / 100 + "");
        return arrayList;
    }

    public void printArray(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
