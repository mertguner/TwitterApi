import com.github.seratch.signedrequest4j.OAuthAccessToken;
import com.github.seratch.signedrequest4j.OAuthConsumer;
import com.github.seratch.signedrequest4j.SignedRequest;
import com.github.seratch.signedrequest4j.SignedRequestFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Constants {
    private static final OAuthConsumer consumer = new OAuthConsumer(main.prop.getProperty("API_KEY"), main.prop.getProperty("API_SECRET_KEY"));
    private static final OAuthAccessToken accessToken = new OAuthAccessToken(main.prop.getProperty("ACCESS_TOKEN"), main.prop.getProperty("ACCESS_TOKEN_SECRET"));

    private static final String postTweet = main.prop.getProperty("API_URL") + "/statuses/update.json";
    private static final String deleteTweet = main.prop.getProperty("API_URL") + "/statuses/destroy/%s.json";
    private static final String webhooks = main.prop.getProperty("API_URL") + "/account_activity/all/%swebhooks.json";
    private static final String deleteWebhook = main.prop.getProperty("API_URL") + "/account_activity/all/%s/webhooks/%s.json";
    private static final String subscriptions = main.prop.getProperty("API_URL") + "account_activity/all/%s/subscriptions.json";
    private static final String search = main.prop.getProperty("API_URL") + "/search/tweets.json?q=%s&count=%d";
    private static final String getTimeline = main.prop.getProperty("API_URL") + "/statuses/home_timeline.json";

    public static SignedRequest getThreeLeggedOAuthRequest() {
        return SignedRequestFactory.create(consumer, accessToken);
    }

    public static String getPostTweet() { return postTweet; }

    public static String getDeleteTweet(String tweetId) {
        return String.format(deleteTweet, tweetId);
    }

    public static String getWebhooks() { return String.format(webhooks, ""); }

    public static String setWebhooks(String environmentName) { return String.format(webhooks, environmentName + "/"); }

    public static String setSubscriptions(String environmentName) { return String.format(subscriptions, environmentName); }

    public static String deleteWebhook(String environmentName, String webhookId) { return String.format(deleteWebhook, environmentName, webhookId); }

    public static String getSearch(String hashTag, int count) throws UnsupportedEncodingException { return String.format(search, URLEncoder.encode(hashTag, StandardCharsets.UTF_8.name()), count); }

    public static String getTimeline() { return getTimeline; }
}
