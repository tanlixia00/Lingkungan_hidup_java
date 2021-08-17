package com.client.lingkungan_hidup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InputPengaduanActivity extends AppCompatActivity {

    TextView txtgambar, txtAlasan, txtLokasiSatwa, txtTelp;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_pengaduan);

        txtgambar = (TextView)findViewById(R.id.txtUrlLapor);
        txtAlasan = (TextView)findViewById(R.id.txtDeksripsiLapor);
        txtLokasiSatwa = (TextView)findViewById(R.id.txtLokasiSatwaLapor);
        txtTelp = (TextView)findViewById(R.id.txtTelpPelapor);
        btnSend = (Button)findViewById(R.id.btnInputPengaduan);

        btnSend.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
//                Intent i=new Intent(getBaseContext(), LoginAdminActivity.class);
//                startActivity(i);

                if (txtgambar.getText().toString().isEmpty() ||
                        txtAlasan.getText().toString().isEmpty() ||
                        txtLokasiSatwa.getText().toString().isEmpty() ||
                        txtTelp.getText().toString().isEmpty()) {
                    Toast.makeText(getBaseContext(),"silahkan lengkapi data",Toast.LENGTH_LONG).show();
                }
                else{
                    String url = MainActivity.basic_url+"inputPengaduan.php?"+
                            "url="+txtgambar.getText().toString() +
                            "&alasan=" + txtAlasan.getText().toString() +
                            "&lokasi=" + txtLokasiSatwa.getText().toString() +
                            "&telp=" + txtTelp.getText().toString();
                    Log.d("deb adu URL",url);

                    StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("deb respon", "ok");
                            try {
                                JSONObject data = new JSONObject(response);
                                if (data.getString("result").equalsIgnoreCase("ok"))
                                {
                                    Log.d("deb URL", "result ok");
                                    Toast.makeText(getBaseContext(),"terima kasih, data sudah direkam!",Toast.LENGTH_LONG).show();
                                    finish();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(getBaseContext(),"err"+error.toString(),Toast.LENGTH_LONG).show();
                                }
                            }
                    );
                    RequestQueue requestQueue = Volley.newRequestQueue(getBaseContext());
                    requestQueue.add(stringRequest);
                }

            }
        });
    }
}