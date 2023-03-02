import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

public class SendOTP {

    public static void sendOTP(String message, String number, String apiKey)
    {
       try {
           String sendId = "TXTIND";
           String language = "english";
           String route = "v3";

           message = URLEncoder.encode(message, "UTF-8");

           String myUrl = "https://www.fast2sms.com/dev/bulkV2?authorization=Y2laURkH1iefujNd8oy4Exq0w7F6OngZLMVr5JPQcTIb9pWDSXyhFkSYDtA0Pv4cM3X79JrBLGdTW2Vu&route=v3&sender_id=TXTIND&message="+message+"&language=english&flash=0&numbers="+number;

         //  "https://www.fast2sms.com/dev/bulkV2?authorization"+apiKey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;

           URL url = new URL(myUrl);
           HttpsURLConnection con = (HttpsURLConnection )url.openConnection();
           con.setRequestMethod("GET");

           con.setRequestProperty("User-Agent","Mozilla/5.0");
           con.setRequestProperty("cache-control","no-cache");

           System.out.println("Wait.........");
           int responseCode = con.getResponseCode();
           System.out.println("Response Code: "+responseCode);

           StringBuffer response = new StringBuffer();

           BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

           while(true)
           {
               String line = br.readLine();
               if(line== null)
               {
                   break;
               }
               response.append(line);
           }

           System.out.println(response);
       }

       catch (Exception e) {
           System.out.println(e);
       }


    }

    public static void main(String[] args) {

        System.out.println("Program Started.........");

        OTP otp = new OTP();
       String otpmessage = otp.generateOTP(5);
        System.out.println("Generated OTP:"+otpmessage);
        String apiKey = "Y2laURkH1iefujNd8oy4Exq0w7F6OngZLMVr5JPQcTIb9pWDSXyhFkSYDtA0Pv4cM3X79JrBLGdTW2Vu";
        String number = "7000970476";

        sendOTP("Hello User, Your Hostelsway OTP is:"+otpmessage,number,apiKey);


    }
}

//https://www.fast2sms.com/dev/bulkV2?authorization=Y2laURkH1iefujNd8oy4Exq0w7F6OngZLMVr5JPQcTIb9pWDSXyhFkSYDtA0Pv4cM3X79JrBLGdTW2Vu&route=v3&sender_id=TXTIND&message=&language=english&flash=0&numbers=