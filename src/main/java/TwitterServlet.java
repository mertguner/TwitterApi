import java.io.IOException;
import java.util.stream.Collectors;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;

public class TwitterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String hash = generateHash(req.getParameter("crc_token"));
            Response response = new Response();
            response.setResponseToken("sha256=" + hash);

            resp.setContentType("application/json");
            resp.getWriter().write((new Gson()).toJson(response));
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String json = req.getReader().lines().collect(Collectors.joining());
            String hash = generateHash(json);
            String header = req.getHeader("x-twitter-webhooks-signature");
            if (hash.equals(header)) {
                //FIXME: json parse edilip istenilen işlem burada yapılır.
            }
        } catch (Exception e) {

        }
    }

    private static String generateHash(String input) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(main.prop.getProperty("API_SECRET_KEY").getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        return Base64.encodeBase64String(sha256_HMAC.doFinal(input.getBytes("UTF-8"))).replace("\r\n", "");
    }

    public class Response
    {
        private String response_token;

        public void setResponseToken(String response_token) { this.response_token = response_token; }
        public String getResponseToken() { return response_token; }
    }
}
