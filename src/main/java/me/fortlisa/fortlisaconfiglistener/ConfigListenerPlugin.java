package me.fortlisa.fortlisaconfiglistener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public final class ConfigListenerPlugin extends JavaPlugin {

    private static final String GET_METHOD = "GET";
    private static final String POST_METHOD = "POST";
    private static final String PATCH_METHOD = "PATCH";

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("ConfigListenerPlugin has started!");
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(8080), 0);
            Bukkit.getLogger().info("HTTP server has started!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        server.createContext("/test", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String httpMethod = httpExchange.getRequestMethod();
            if (httpMethod.equals(GET_METHOD)) {
                String response = "This is the test response";
                httpExchange.sendResponseHeaders(200, response.length());
                OutputStream os = httpExchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else if (httpMethod.equals(POST_METHOD)) {
                String response = "This is the post response";
                httpExchange.sendResponseHeaders(200, response.length());
                OutputStream os = httpExchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else if (httpMethod.equals(PATCH_METHOD)) {
                String response = "This is the patch response";
                httpExchange.sendResponseHeaders(200, response.length());
                OutputStream os = httpExchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }

        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
