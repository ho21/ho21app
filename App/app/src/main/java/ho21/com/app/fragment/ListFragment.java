package ho21.com.app.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import ho21.com.app.activity.R;
import ho21.com.app.adapter.ListItemAdapter;

/**
 * Created by Administrator on 2016/6/4 0004.
 */
public class ListFragment extends Fragment {

    int page = 1;
    RecyclerView recyclerView;
    ListItemAdapter listItemAdapter;
    private RequestQueue queue;
    boolean loding = false;
    RotateLoading rotateloading;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final List<JSONObject> list = new ArrayList();
        View view = inflater.inflate(R.layout.list_main, container, false);
        rotateloading = (RotateLoading) view.findViewById(R.id.rotateloading);
        rotateloading.setLoadingColor(Color.parseColor("#0000ff"));
        rotateloading.start();
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        //请求api填充api
        String url = "http://fun.ho21.com/index.php/api/list/1/1/6";
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    rotateloading.stop();
                    JSONArray JAdata = response.getJSONArray("data");
                    for (int i =0; i<JAdata.length();i++){
                        list.add(JAdata.getJSONObject(i));
                    }
                    listItemAdapter = new ListItemAdapter(list);
                    recyclerView.setAdapter(listItemAdapter);
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
        queue = Volley.newRequestQueue(container.getContext());
        queue.add(jsonRequest);

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int getChildCount  = linearLayoutManager.getChildCount();
                int firstVisiableItem =  linearLayoutManager.findFirstVisibleItemPosition();
                int lastVisibleItem =  linearLayoutManager.findLastVisibleItemPosition();
                int totalItemCount = linearLayoutManager.getItemCount();
                if((getChildCount+firstVisiableItem)>=totalItemCount&&loding==false){
                    page++;
                    loding = true;
                    //请求api填充api
                    String url = "http://fun.ho21.com/index.php/api/list/1/"+page+"/6";
                    JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                loding = false;
                                JSONArray JAdata = response.getJSONArray("data");
                                List<JSONObject> newList = new ArrayList();
                                for (int i =0; i<JAdata.length();i++){
                                    newList.add(JAdata.getJSONObject(i));
                                }
                                listItemAdapter.addData(newList);
                                listItemAdapter.notifyDataSetChanged();
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
                    queue = Volley.newRequestQueue(container.getContext());
                    queue.add(jsonRequest);
                    Toast.makeText(container.getContext(),"加载中...", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
