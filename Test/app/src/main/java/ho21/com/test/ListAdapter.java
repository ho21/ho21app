package ho21.com.test;

/**
 * Created by Administrator on 2016/4/30 0030.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    public JSONArray JAdata = null;

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

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            String title = JAdata.getJSONObject(position).getString("images_title");
            holder.mTextView.setText(title);
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
        public TextView mTextView;
        public ViewHolder(View view){
            super(view);
            mTextView = (TextView) view.findViewById(R.id.tvUrl);
        }
    }
}



