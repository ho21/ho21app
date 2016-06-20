package ho21.com.app.adapter;

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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ho21.com.app.activity.R;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ViewHolder> {

    private int lastPosition = -1;
    private List<JSONObject> data;

    public void ListItemAdapter(List<JSONObject> data){
        this.data = data;
    }

    public void setData(List<JSONObject> getData) {
        this.data = getData;
    }

    public void addData(List<JSONObject> getData) {
        this.data.addAll(getData);
    }

    public ListItemAdapter(List<JSONObject> getData) {
        this.data = getData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
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
                String title = data.get(position).getString("images_title");
                holder.mTextView.setText(title);
//
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.images_title) TextView mTextView;
        @BindView(R.id.images_src) ImageView mPic;
        @BindView(R.id.card)
        CardView card;

        public ViewHolder(View view){
            super(view);
            ButterKnife.bind(this,view);
            mTextView.setPadding(30,30,30,30);
            mTextView.setBackgroundColor(Color.argb(132, 0, 0, 0));
        }
    }


}



