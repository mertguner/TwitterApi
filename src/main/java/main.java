import objects.Environment;
import objects.Status;
import objects.WebhookResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.io.*;
import java.util.Properties;

public class main {
    public static Properties prop = new Properties();

    public static void main(String[] args) throws Exception {
        loadProperties();

        startServer();

        Status response = Twitter.SendTweet("Hello World");
        if (response != null) {
            response = Twitter.DeleteTweet(response.getIdStr());
        }

        WebhookResponse webhookResponse = Twitter.GetWebhooks();
        if(webhookResponse != null && webhookResponse.getEnvironments().size() == 0)
        {
            for (Environment env : webhookResponse.getEnvironments()) {
                Twitter.SetWebhooks(env.getEnvironmentName(), "https://www.YourSite.com/Hook");
                Twitter.SetSubscriptions(env.getEnvironmentName());
            }
        }
    }

    private static void loadProperties() throws FileNotFoundException {
        try {
            InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void startServer()
    {
        try{
            Server server = new Server(Integer.parseInt(prop.getProperty("PORT")));

            ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

            ServletHolder staticHolder = new ServletHolder("default", DefaultServlet.class);
            staticHolder.setInitParameter("dirAllowed","false");
            staticHolder.setInitParameter("cacheControl","max-age=300,public");

            handler.addServlet(staticHolder,"/");

            handler.addServlet(new ServletHolder(new TwitterServlet()), "/Hook");

            handler.setContextPath("/");
            handler.addServlet(new ServletHolder(new TwitterServlet()), "/Twitter/Hook");

            GzipHandler gzip = new GzipHandler();
            gzip.setHandler(handler);

            server.setHandler(gzip);
            server.setStopAtShutdown(true);

            server.start();
            //server.join();

            if (!server.isStarted()) {
                System.exit(0);
            }
        }catch(Exception e){
            System.exit(0);
        }
    }
}
