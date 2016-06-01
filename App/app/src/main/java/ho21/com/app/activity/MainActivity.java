package ho21.com.app.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.victor.loading.rotate.RotateLoading;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ho21.com.app.adapter.ListItemAdapter;

public class MainActivity extends Activity {

    private ListItemAdapter adapter;
    private RequestQueue queue;

    @BindView(R.id.rotateloading) RotateLoading rotateLoading;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);
        rotateLoading.setLoadingColor(Color.parseColor("#0000ff"));
        rotateLoading.start();
        initData();
    }

    private void initData() {
        // 设置布局管理器
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        // 线性布局管理器
        recyclerView.setLayoutManager(linearLayoutManager);
        //请求api填充api
        String url = "http://fun.ho21.com/index.php/api/list/1/1/6";
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    rotateLoading.stop();
                    JSONArray JAData = response.getJSONArray("data");
                    adapter = new ListItemAdapter(JAData);
                    recyclerView.setAdapter(adapter);
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
        queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(jsonRequest);
        /*滚动监听*/
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstVisiableItem =  linearLayoutManager.findFirstVisibleItemPosition();
                int lastVisibleItem =  linearLayoutManager.findLastVisibleItemPosition();
                int totalItemCount = linearLayoutManager.getItemCount();
                if(lastVisibleItem>=totalItemCount-1&&dy>0){
                    Toast.makeText(getApplicationContext(),"加载中...",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private long exitTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
