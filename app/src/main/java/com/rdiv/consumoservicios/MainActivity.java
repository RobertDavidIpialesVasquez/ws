package com.rdiv.consumoservicios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {


    EditText edNum1, ednum2;

    Button btProcesar;
    TextView tvResultado;


    String respuesta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNum1=findViewById(R.id.txtN1);
        edNum1=findViewById(R.id.txtN2);
        btProcesar=findViewById(R.id.botonCalcular);
        tvResultado=findViewById(R.id.tvResultado);

        btProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConsumirApi();
            }
        });
    }
        public void ConsumirApi(){
            String equisde = "https://ejemplo2apimovil20240128220859.azurewebsites.net/api/Operaciones?a=4&b=7";
            OkHttpClient cliente=new OkHttpClient();


            Request get=new Request.Builder().url(equisde).build();

            cliente.newCall(get).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {


                    try{
                        ResponseBody responseBody= response.body();
                        if (!response.isSuccessful()){
                            throw new IOException("Respuesta inesperada" +response);

                        }

                        respuesta= responseBody.string();

                    }catch (Exception e){


                    }
                }
            });

        }


    }
