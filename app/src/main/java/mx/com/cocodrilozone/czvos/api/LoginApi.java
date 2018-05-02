package mx.com.cocodrilozone.czvos.api;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

import mx.com.cocodrilozone.czvos.activity.MainActivity;
import mx.com.cocodrilozone.czvos.dto.LoginDTO;

public class LoginApi {
    private final String URL_LOGIN = "http://webservice.cocodrilomx.com/api/Promocion";
    private WeakReference<MainActivity> loginActivityWeakReference;

    public void processLogin(LoginDTO login, MainActivity loginActivityWeakReference) {
        this.loginActivityWeakReference = new WeakReference<>(loginActivityWeakReference);
        LoginAsyncTask task = new LoginAsyncTask(login);
        task.execute();
    }

    private String createQueryLogin(LoginDTO login) {
        String newUrl = URL_LOGIN;

        return newUrl;
    }

    private class LoginAsyncTask extends AsyncTask<String, Void, String> {

        private LoginDTO login;

        public LoginAsyncTask(LoginDTO login) {
            this.login = login;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(createQueryLogin(login));
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("Content-length", "0");
                urlConnection.setUseCaches(false);
                urlConnection.setAllowUserInteraction(false);
                urlConnection.setConnectTimeout(100000);
                urlConnection.setReadTimeout(100000);

                urlConnection.connect();

                int responseCode = urlConnection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();
                    return sb.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            loginActivityWeakReference.get().getResponse(s);
        }
    }
}
