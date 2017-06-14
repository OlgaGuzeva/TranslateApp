import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.alibaba.fastjson.JSON;

public class YandexTranslate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		try {
			str = br.readLine();
			translate("ru", str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void translate(String lang, String enteredText) throws IOException {
		
		if (enteredText.length() > 0) {
			String url = "https://translate.yandex.net/api/v1.5/tr.json/translate?"
	                + "key=trnsl.1.1.20170418T092159Z.31e8796307c75a6f.8443129baedf7ba3a0329f1a7332093814b6efee"
	                + "&text=" + enteredText
	                + "&lang=" + lang;
			URLConnection connection = null;
		     try {
		         connection = new URL(url).openConnection();
		     } catch (ArrayIndexOutOfBoundsException e) {
		         System.out.printf("No text for translate");
		     }
		     InputStream response = connection.getInputStream();
		     @SuppressWarnings("resource")
			String jsonString = new java.util.Scanner(response).nextLine();
		     Translation newTranslation = JSON.parseObject(jsonString, Translation.class);

		     newTranslation.say();
		}
	}
}


