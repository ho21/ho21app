package ho21.com.app.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ho21.com.app.activity.R;
import ho21.com.app.adapter.ListItemAdapter;

/**
 * Created by Administrator on 2016/6/4 0004.
 */
public class HeaderFragment extends Fragment {

    DrawerLayout drawerLayout;
//    @BindView(R.id.toolbar) Toolbar toolbar;
//    @BindView(R.id.app_title) TextView app_title;

    public HeaderFragment(){}

    public HeaderFragment(DrawerLayout drawerLayout){
        this.drawerLayout = drawerLayout;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("tag","exec-----------");
        View view = inflater.inflate(R.layout.header_layout,null);
        ButterKnife.bind(this,view);
        //设置导航栏图标
//        toolbar.setNavigationIcon(R.mipmap.menu_icon);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawerLayout.openDrawer(GravityCompat.START);
//            }
//        });
        return view;
    }
}
