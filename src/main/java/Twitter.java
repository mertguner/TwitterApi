import com.github.seratch.signedrequest4j.HttpResponse;
import com.github.seratch.signedrequest4j.RequestBody;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import objects.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Twitter {

    private static Gson gson = new Gson();
    public static Status SendTweet(String text) throws Exception {
        Map<String, Object> requestParameters = new HashMap<String, Object>();
        requestParameters.put("status", (text.length() > 280) ? text.substring(0,280) : text);
        HttpResponse response = Constants.getThreeLeggedOAuthRequest().doPost(Constants.getPostTweet(), requestParameters, "UTF-8");

        if(response.getStatusCode() == 200){
            return gson.fromJson(response.getTextBody(), Status.class);
        }
        return null;
    }

    public static Status DeleteTweet(String TweetId) throws Exception {
        Map<String, Object> requestParameters = new HashMap<String, Object>();
        HttpResponse response = Constants.getThreeLeggedOAuthRequest().doPost(Constants.getDeleteTweet(TweetId), requestParameters, "UTF-8");

        if(response.getStatusCode() == 200){
            return gson.fromJson(response.getTextBody(), Status.class);
        }else
            gson.fromJson(response.getTextBody(), ErrorResponse.class);

        return null;
    }

    public static WebhookResponse GetWebhooks() throws Exception {
        HttpResponse response = Constants.getThreeLeggedOAuthRequest().doGet(Constants.getWebhooks(), "UTF-8");

        if(response.getStatusCode() == 200){
            return gson.fromJson(response.getTextBody(), WebhookResponse.class);
        }else
            gson.fromJson(response.getTextBody(), ErrorResponse.class);

        return null;
    }

    public static WebhookResponse SetWebhooks(String environmentName, String url) throws Exception {
        byte[] body = url.getBytes();
        String contentType = "application/x-www-form-urlencoded";
        RequestBody reuestBody = new RequestBody(body, contentType);
        HttpResponse response = Constants.getThreeLeggedOAuthRequest().doPost(Constants.setWebhooks(environmentName), reuestBody, "UTF-8");

        if(response.getStatusCode() == 200){
            return gson.fromJson(response.getTextBody(), WebhookResponse.class);
        }else
            gson.fromJson(response.getTextBody(), ErrorResponse.class);

        return null;
    }

    public static boolean DeleteWebhook(String environmentName, String webhookId) throws Exception {
        Map<String, Object> requestParameters = new HashMap<String, Object>();
        HttpResponse response = Constants.getThreeLeggedOAuthRequest().doDelete(Constants.deleteWebhook(environmentName, webhookId), requestParameters, "UTF-8");

        if(response.getStatusCode() == 200){
            return true;
        }else
            gson.fromJson(response.getTextBody(), ErrorResponse.class);

        return false;
    }

    public static boolean SetSubscriptions(String environmentName) throws Exception {
        Map<String, Object> requestParameters = new HashMap<String, Object>();
        HttpResponse response = Constants.getThreeLeggedOAuthRequest().doPost(Constants.setSubscriptions(environmentName), requestParameters, "UTF-8");

        if(response.getStatusCode() == 200){
            return true;
        }else
            gson.fromJson(response.getTextBody(), ErrorResponse.class);

        return false;
    }

    public static SearchResponse SearhTimeline(String hashTag, int count) throws Exception {
        HttpResponse response = Constants.getThreeLeggedOAuthRequest().doGet(Constants.getSearch(hashTag, count), "UTF-8");

        if(response.getStatusCode() == 200){
            return gson.fromJson(response.getTextBody(), SearchResponse.class);
        }else
            gson.fromJson(response.getTextBody(), ErrorResponse.class);

        return null;
    }

    public static List<Status> GetTimeline() throws Exception {
        HttpResponse response = Constants.getThreeLeggedOAuthRequest().doGet(Constants.getTimeline(), "UTF-8");

        if(response.getStatusCode() == 200){
            return gson.fromJson(response.getTextBody(), new TypeToken<ArrayList<Status>>(){}.getType());
        }else
            gson.fromJson(response.getTextBody(), ErrorResponse.class);

        return null;
    }


}
