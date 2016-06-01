package ho21.com.test;

/**
 * Created by Administrator on 2016/4/30 0030.
 */

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;

import org.json.JSONArray;
import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    public JSONArray JAdata = null;
    public int num = 0;
    private RequestQueue queue;
    private int lastPosition = -1;
    private int page = 1;
    private boolean isFirstRow;
    private boolean isLastRow;

    public ListAdapter(JSONArray JAdata) {
        this.JAdata = JAdata;
        System.out.println(JAdata.toString());
        System.out.println(JAdata.length());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_test,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R.anim.item_bottom_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        try {
            String title = JAdata.getJSONObject(position).getString("images_title");
            holder.mTextView.setText(title);
            setAnimation(holder.card, position);
//            String url = JAdata.getJSONObject(position).getString("images_url");
//            ImageRequest imgRequest = new ImageRequest(url,
//                    new Response.Listener<Bitmap>() {
//                        @Override
//                        public void onResponse(Bitmap response) {
//                            holder.mPic.setImageBitmap(response);
//                        }
//                    }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    holder.mPic.setBackgroundColor(Color.parseColor("#ff0000"));
//                    error.printStackTrace();
//                }
//            });
//            queue = Volley.newRequestQueue(holder.mPic.getContext());
//            queue.add(imgRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return JAdata.length();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.images_title) TextView mTextView;
        @BindView(R.id.images_src) ImageView mPic;
        @BindView(R.id.card) CardView card;

        public ViewHolder(View view){
            super(view);
            ButterKnife.bind(this,view);
            mTextView.setPadding(30,30,30,30);
            mTextView.setBackgroundColor(Color.argb(132, 0, 0, 0));
        }
    }


}



