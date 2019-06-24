package com.group.almighty.slidebackend.Services;

import com.group.almighty.slidebackend.Dao.SmsDao;
import com.group.almighty.slidebackend.Model.Sms;
import com.group.almighty.slidebackend.Model.User;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
@PropertySource("classpath:application.properties")
public class SmsService {

    @Value("${smsBaseUrl}")
    private String baseUrl;
    @Value("${smsUser}")
    private String user;
    @Value("${smsPass}")
    private String pass;


    @Autowired
    private SmsDao smsDao;


    @Async
    public void sendSingle(String sender, String recipient, String message, User smsUser){

        if(recipient == null || recipient.trim().isEmpty())
            return;

        try{

            System.out.println("I am here");
            String to = this.formatPhoneNumber(recipient);

            // Build url
            String url =  baseUrl + "?user=" + user + "&pass=" + pass;
            url += "&from=" + sender + "&to=" + to;
            url += "&msg=" + URLEncoder.encode(message, "UTF-8");

            HttpResponse<String> response = Unirest.get(url).asString();

            if(smsUser != null){
                smsDao.save(new Sms(smsUser, recipient, message));
            }

            if (response.getBody().equalsIgnoreCase("sent")) {
                System.out.println("SMS sent successfully to " + recipient);
            }
            else
                System.out.println("SMS Response Message: " + response.getBody());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }


    @Async
    public boolean sendMultiple(String sender, String[] recipients, String message){

        if (recipients.length < 1)
            return false;

        try{

            String to = "";

            for(String recipient : recipients){
                if(to.trim().length() > 0)
                    to += "," + this.formatPhoneNumber(recipient);
                else
                    to += this.formatPhoneNumber(recipient);
            }

            // Build url
            String url =  baseUrl + "?user=" + user + "&pass=" + pass;
            url += "&from=" + sender + "&to=" + to;
            url += "&msg=" + URLEncoder.encode(message, "UTF-8");

            HttpResponse<String> response = Unirest.get(url).asString();

            return response.getBody().equalsIgnoreCase("sent");
        }
        catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    private String formatPhoneNumber(String phone){

        if(phone.substring(0,3).equalsIgnoreCase("234"))
            return phone;

        if(phone.length() < 10 && phone.substring(0,1).equalsIgnoreCase("0"))
            return "234" + phone.substring(1);
        else
            return "234" + phone.substring(phone.length()-10);
    }

}
