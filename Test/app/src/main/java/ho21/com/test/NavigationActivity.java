package ho21.com.test;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NavigationActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        // 线性布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        // 设置布局管理器
        recyclerView.setLayoutManager(linearLayoutManager);

//        String url = "http://app.ho21.com/index.php/api/list";
//        JsonObjectRequest jsonRequest = new JsonObjectRequest
//                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        // the response is already constructed as a JSONObject!
//                        try {
//                            System.out.println("S------------------------");
//                            JSONArray data = response.getJSONArray("data");
//
//                            String title = data.getJSONObject(1).getString("images_title");
////                            adapter = new MyAdapter(data);
////                            String msg = response.getString("message");
//                            System.out.println(title);
//                            System.out.println("E------------------------");
////                            String msg = response.getString("message");
////                            System.out.println("Reponse data: "+msg);
////                            Toast.makeText(getApplicationContext(),"Reponse data:"+code,Toast.LENGTH_LONG).show();
//
////                            response = response.getJSONObject("args");
////                            String site = response.getString("site"),
////                                    network = response.getString("network");
////                            System.out.println("Site: "+site+"\nNetwork: "+network);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        error.printStackTrace();
//                    }
//                });
//        Volley.newRequestQueue(this).add(jsonRequest);

        try {
            String strData = "[{'images_id':'1894'},{'images_title':'520节日'}]";
            JSONArray JAData = new JSONArray(strData);
            System.out.println("S------------------------");
            adapter = new ListAdapter(JAData);
            recyclerView.setAdapter(adapter);
            System.out.println("E------------------------");
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        try {
//            String strData = "[{'images_id':'1894'},{'images_title':'520节日'}]";
//            JSONArray JAData = new JSONArray(strData);
//            System.out.println("S------------------------");
//            for(int i=0;i<JAData.length();i++){
//                 System.out.println("array data ="+JAData.get(i).toString());
//            }
//            System.out.println("E------------------------");
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//         try {
//             String strData = "['images_id','1894','images_title','520节日']";
//             JSONArray JAData = new JSONArray(strData);
//             System.out.println("S------------------------");
//             for(int i=0;i<JAData.length();i++){
//                 System.out.println("array data ="+JAData.get(i).toString());
//             }
//             System.out.println("E------------------------");
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//     JSONArray jsonData = [{"images_id":"1894","user_id":"1","category_id":"3","images_url":"http:\/\/ho21com.oss-cn-hangzhou.aliyuncs.com\/img\/3\/gif\/2014-09-23\/{0D210735-4E1E-2043-9286-FDCBCF3EDB48}.gif","images_title":"\u56fd\u5916\u6709\u4e2a\u5c0f\u54e5\u5728instagram\u4e0a\u6652\u4e86\u4e00\u5f20\u5012\u7acb\u7167\u7247\uff08\u56fe1\uff09\u4ee5\u6b64\u70ab\u8000\u81ea\u5df1\u8179\u808c\u662f\u591a\u4e48\u660e\u663e\u3002\u539f\u672c\u8fd9\u53ea\u662f\u793e\u4ea4\u5e73\u53f0\u4e0a\u5f88\u5e38\u89c1\u7684\u4e8b\u60c5\uff0c\u7ed3\u679c\u4e0d\u77e5\u9053\u4e3a\u4ec0\u4e48\u4ed6\u5c31\u88ab\u65e2\u559c\u6b22\u597d\u8eab\u6750\u53c8\u559c\u6b22\u300e\u53e3\u888b\u5996\u602a\u300f\u7684\u73a9\u5bb6\u4eec\u76ef\u4e0a\u4e86\uff0c\u7ed3\u679c\u5bfc\u81f4\u7167\u7247\u88ab\u6539\u6210\u4e86\u5404\u79cdGIF\u52a8\u56fe\uff0c\u79f0\u4f5c\u201c\u7cbe\u7075\u4e5f\u7231\u8179\u808c\u201d\u3002\u8fd9\u4e2a\u6545\u4e8b\u518d\u6b21\u544a\u8bc9\u6211\u4eec\uff1a\u70ab\u8000\u6709\u98ce\u9669\uff0c\u65e5\u897f\u9700\u8c28\u614e\u3002","images_content":"","images_tags":"","images_source":"http:\/\/s1.dwstatic.com\/group1\/M00\/22\/DB\/0a905ce1479da6dc2de568fdcc8a8c62.gif","browse_num":"681","is_good":"13","is_bad":"28","is_old":"5","images_time":"1411444417","category_title":"\u641e\u7b11GIF"}];
      //        创建并设置Adapter
//        adapter = new MyAdapter(new String[]{"aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb","aaaa", "bbb"});
//        recyclerView.setAdapter(adapter);













//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        // App Logo
//        toolbar.setLogo(R.mipmap.ic_launcher);
//        // Title
//        toolbar.setTitle("My Title");
//        // Sub Title
//        toolbar.setSubtitle("Sub title");
//        setSupportActionBar(toolbar);


//        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
//                this,                  /* host Activity */
//                mDrawerLayout,         /* DrawerLayout object */
//                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
//                R.string.drawer_open,  /* "open drawer" description for accessibility */
//                R.string.drawer_close  /* "close drawer" description for accessibility */
//        ) {
//            public void onDrawerClosed(View view) {
//                getActionBar().setTitle(mTitle);
//                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
//            }
//
//            public void onDrawerOpened(View drawerView) {
//                getActionBar().setTitle(mDrawerTitle);
//                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
//            }
//        };
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,100,"设置");
        return super.onCreateOptionsMenu(menu);
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
