package com.example.elclimarga;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ciudadDelEste extends AppCompatActivity {

    TextView txtTEMP;
    TextView txtST;
    TextView txtTEMPMAX;
    TextView txtTEMPMIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudad_del_este);

        txtTEMP=findViewById(R.id.txtTEMP);
        txtTEMP.setText("");
        txtST=findViewById(R.id.txtST);
        txtST.setText("");
        txtTEMPMAX=findViewById(R.id.txtTEMPMAX);
        txtTEMPMAX.setText("");
        txtTEMPMIN=findViewById(R.id.txtTEMPMIN);
        txtTEMPMIN.setText("");

        api_key();
    }

    private void api_key() {
        OkHttpClient client=new OkHttpClient();

        Request request=new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?id=3439101&appid= ACA VA LA API KEY PERSONAL &units=metric")
                .get()
                .build();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Response response= client.newCall(request).execute();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {

                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    String responseData= response.body().string();
                    try {
                        JSONObject json=new JSONObject(responseData);
                        JSONArray array=json.getJSONArray("weather");
                        JSONObject object=array.getJSONObject(0);

                        String description=object.getString("description");
                        String icons = object.getString("icon");

                        JSONObject temp1= json.getJSONObject("main");
                        Double temperaturaactual=temp1.getDouble("temp");
                        Double sensacionTerm = temp1.getDouble("feels_like");
                        Double tempminima = temp1.getDouble("temp_min");
                        Double tempmaxima = temp1.getDouble("temp_max");


                        String tempac=Math.round(temperaturaactual)+" °C";
                        String tempst=Math.round(sensacionTerm)+" °C";
                        String tempsmin=Math.round(tempminima)+" °C";
                        String tempsmax=Math.round(tempmaxima)+" °C";

                        setText(txtTEMP,tempac);
                        setText(txtST,tempst);
                        setText(txtTEMPMAX,tempsmin);
                        setText(txtTEMPMIN,tempsmax);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void setText(final TextView text, final String value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(value);
            }
        });
    }
}