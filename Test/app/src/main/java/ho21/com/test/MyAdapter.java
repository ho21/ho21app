package ho21.com.test;

/**
 * Created by Administrator on 2016/4/30 0030.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public String[] datas = null;
    public MyAdapter(String[] datas) {
        this.datas = datas;
        System.out.print(datas);
    }
    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_test,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mTextView.setText(datas[position]);
    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.length;
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



/**
 * 适配器
 * Created by lizheng on 14/10/19.
 */
//public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoViewHolder> {
//    String[] picUrls;
//
//    public DemoAdapter(String[] picUrls) {
//        this.picUrls = picUrls;
//        System.out.print("run");
//    }
//
//    @Override
//    public DemoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        // 加载数据item的布局，生成VH返回
//        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_test, viewGroup, false);
//        return new DemoViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(DemoViewHolder demoViewHolder, int i) {
//        // 数据绑定
////        ImageLoader.getInstance().displayImage(picUrls[i], demoViewHolder.imavPic);
//        demoViewHolder.tvUrl.setText(picUrls[i]);
//    }
//
//    @Override
//    public int getItemCount() {
//        // 返回数据有多少条
//        if (null == picUrls) {
//            return 0;
//        }
//        return picUrls.length;
//    }
//
//    // 可复用的VH
//    public static class DemoViewHolder extends RecyclerView.ViewHolder {
//        // 大图
//        public ImageView imavPic;
//        // 图片url
//        public TextView tvUrl;
//
//        public DemoViewHolder(View itemView) {
//            super(itemView);
////            imavPic = (ImageView) itemView.findViewById(R.id.imavPic);
//            tvUrl = (TextView) itemView.findViewById(R.id.tvUrl);
//        }
//    }
//}