package ho21.com.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import ho21.com.activity.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String url = "http://httpbin.org/get?site=code&network=tutsplus";
        String url = "http://app.ho21.com/index.php/api/list";
//        String url = "http://192.168.1.134/index.php/api/list";
//        String url = "http://httpbin.org/html";
// Request a string response
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        System.out.println("S------------------------");
//                        System.out.println(response);
//                        System.out.println("E------------------------");
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                // Error handling
//                System.out.println("Something went wrong!");
//                error.printStackTrace();
//
//            }
//        });
//        Volley.newRequestQueue(this).add(stringRequest);


        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // the response is already constructed as a JSONObject!
                        try {

                        System.out.println("S------------------------");
                            String msg = response.getString("message");
                            System.out.println("Reponse data: "+msg);
//                            System.out.println(response.toString());
                        System.out.println("E------------------------");
//                            String msg = response.getString("message");
//                            System.out.println("Reponse data: "+msg);
//                            Toast.makeText(getApplicationContext(),"Reponse data:"+code,Toast.LENGTH_LONG).show();

//                            response = response.getJSONObject("args");
//                            String site = response.getString("site"),
//                                    network = response.getString("network");
//                            System.out.println("Site: "+site+"\nNetwork: "+network);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        Volley.newRequestQueue(this).add(jsonRequest);
    }
}


