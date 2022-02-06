package MiddlewareLogic;

import android.content.Context;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

import Entities.Gym;


public class MiddlewareConnection {
    private static final String baseUrl = "https://groupfive161520.eu-gb.mybluemix.net/";
    //    private static final String baseUrl = "http://192.168.178.44:3000/";
    private static final ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static boolean AreCredentialsRight(String username, String password) throws CouldNotConnectToServerException {
        AtomicReference<Boolean> reply = new AtomicReference<>();
        executorService.execute(() -> {
            try {
                HttpsURLConnection httpsConnection = SetUpConnection("authentications/verify", "POST");
                httpsConnection.setDoOutput(true);
                // setting up the HTTP POST-request

                JSONObject json = new JSONObject();
                json.put("USERNAME", username);
                json.put("PASS_HASH", password);
                DataOutputStream os = new DataOutputStream(httpsConnection.getOutputStream());
                os.writeBytes(json.toString());
                os.flush();
                os.close();
                // creating data and sending it

                BufferedReader br = new BufferedReader(new InputStreamReader(httpsConnection.getInputStream()));
                reply.set(Boolean.parseBoolean(br.readLine()));
                // catching the reply
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        RunTimer(reply);

        return reply.get();
    }

    public static List<Gym> GetAllGyms() throws CouldNotConnectToServerException {
        List<Gym> gyms = new ArrayList<>();
        AtomicReference<JSONArray> reply = new AtomicReference<>();
        executorService.execute(() -> {
            try {
                HttpsURLConnection httpsConnection = SetUpConnection("gyms", "GET");
                // setting up the HTTP GET-request

                BufferedReader reader = new BufferedReader(new InputStreamReader(httpsConnection.getInputStream()));
                JSONArray jsonobject = new JSONArray(reader.readLine());
                reply.set(jsonobject);
                // catching the reply

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        RunTimer(reply);

        try {
            for (int x = 0; x < reply.get().length(); x++) {
                JSONObject object = reply.get().getJSONObject(x);
                gyms.add(new Gym(object.getInt("ID"), object.getString("NAME"), object.getString("STREET"),
                        object.getString("SNUM"), object.getString("POSTAL_CODE"), object.getString("CITY"),
                        object.getString("PROVINCE"), object.getString("COUNTRY")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return gyms;
    }

    private static HttpsURLConnection SetUpConnection(String UrlPart, String requestKind) throws IOException {
        HttpsURLConnection httpsConnection;
        URL url = new URL(baseUrl + UrlPart);
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("TLSv1.2");
            sc.init(null, null, new SecureRandom());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
        httpsConnection = (HttpsURLConnection) url.openConnection();
        httpsConnection.setSSLSocketFactory(sc.getSocketFactory());
        httpsConnection.setRequestProperty("Content-Type", "application/json");
        httpsConnection.setRequestProperty("Accept", "application/json");
        httpsConnection.setRequestMethod(requestKind);
        return httpsConnection;
    }

    public static void RunTimer(AtomicReference ref) throws CouldNotConnectToServerException {
        try {
            for (int x = 0; x < 10; x++) {
                Thread.sleep(1000);
                if (ref.get() != null) {
                    break;
                }
            }
            if (ref.get() == null) {
                throw new CouldNotConnectToServerException();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Updated upstream
    public static void uploadPicture() {
        JSONObject json2 = new JSONObject();
        //json2.put("PICTURE_HASH",string)
    }

    public static void savePic(String picture, String usernames) {
        AtomicReference<JSONObject> reply = new AtomicReference<>();
        executorService.execute(() -> {
            try {
                HttpsURLConnection httpsConnection = SetUpConnection("profilepage/postpicturehash", "PUT");
                httpsConnection.setDoOutput(true);
                //sets it up
                JSONObject pic = new JSONObject();
                JSONObject username = new JSONObject();
                pic.put("PICTURE_HASH", picture);
                username.put("USERNAME", usernames);
                DataOutputStream os = new DataOutputStream(httpsConnection.getOutputStream());
                os.writeBytes(pic.toString());
                os.flush();
                os.close();

                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(httpsConnection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    System.out.println(response.toString());
                }


            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
            ;
        });

    }

    public static String getPic(String username) {
        AtomicReference<String> reply = new AtomicReference<>();
        executorService.execute(() -> {
            try {
                HttpsURLConnection httpsConnection = SetUpConnection("profilepages/getpicturehash", "POST");
                httpsConnection.setDoOutput(true);
                // setting up the HTTP POST-request

                JSONObject json = new JSONObject();
                json.put("USERNAME", username);
                DataOutputStream os = new DataOutputStream(httpsConnection.getOutputStream());
                os.writeBytes(json.toString());
                os.flush();
                os.close();
                // creating data and sending it

                BufferedReader reader = new BufferedReader(new InputStreamReader(httpsConnection.getInputStream()));
                reply.set(reader.readLine());
                // catching the reply

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        try {
            RunTimer(reply);
        } catch (CouldNotConnectToServerException e) {
            e.printStackTrace();
        }

        return reply.get();
    }
}