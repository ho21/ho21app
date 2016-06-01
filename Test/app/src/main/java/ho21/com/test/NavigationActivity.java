package ho21.com.test;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.Menu;
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


public class NavigationActivity extends Activity {
    private ListAdapter adapter;
    private int page = 1;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.rotateloading) RotateLoading rotateLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
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
        defalutData();
        /*滚动监听*/
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                ListAdapter mLayoutManager = null;
                int firstVisiableItem =  linearLayoutManager.findFirstVisibleItemPosition();
                int lastVisibleItem =  linearLayoutManager.findLastVisibleItemPosition();
                int totalItemCount = linearLayoutManager.getItemCount();
                if(lastVisibleItem>=totalItemCount-1&&dy>0){
                    page = page+1;
                    loadData(page);
                    Toast.makeText(NavigationActivity.this,"加载中..."+page,Toast.LENGTH_SHORT).show();
                }
//                System.out.println("First--------------"+isFirstRow);
//                System.out.println("Last--------------"+isLastRow);
//                System.out.println("dx--------------"+dx);
//                System.out.println("dy--------------"+dy);
            }
        });
    }
    private void defalutData(){
        String url = "http://fun.ho21.com/index.php/api/list/1/1/6";
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    rotateLoading.stop();
                    JSONArray JAData = response.getJSONArray("data");
                    adapter = new ListAdapter(JAData);
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
        addToRequestQueue(jsonRequest);
    }
    public void loadData(int page){
       String url = "http://fun.ho21.com/index.php/api/list/1/"+page+"/6";
       JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
           @Override
           public void onResponse(JSONObject response) {
               try {
                   rotateLoading.stop();
                   JSONArray JAData = response.getJSONArray("data");
                   adapter = new ListAdapter(JAData);
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
       addToRequestQueue(jsonRequest);
   }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,100,"设置");
        return super.onCreateOptionsMenu(menu);
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
    private RequestQueue mRequestQueue;
    public RequestQueue getRequestQueue(){
        if(mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req){
        getRequestQueue().add(req);
    }
}

















//
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.view.View;
//import android.support.design.widget.NavigationView;
//import android.support.v4.view.GravityCompat;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuItem;
//
//public class NavigationActivity extends AppCompatActivity
//        implements NavigationView.OnNavigationItemSelectedListener {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_navigation);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//    }
//
//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.navigation, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
//}
