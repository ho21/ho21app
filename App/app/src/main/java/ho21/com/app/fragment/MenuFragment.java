package ho21.com.app.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import ho21.com.app.activity.MainActivity;
import ho21.com.app.activity.R;

/**
 * Created by Administrator on 2016/6/4 0004.
 */
public class MenuFragment extends Fragment implements View.OnClickListener{
    private MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_left_layout, container, false);
        ButterKnife.bind(this,view);
        LinearLayout menuList = (LinearLayout) view.findViewById(R.id.menu_list);
        Log.e("child count", String.valueOf(menuList.getChildCount()));
        for(int i = 0;i<menuList.getChildCount();i++){
            TextView item = (TextView) menuList.getChildAt(i);
            item.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.fun_pic){

//            mainActivity.replaceFragment(R.id.frame_container, fragment);



        }
        Log.e("ID",""+id);
    }

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
        Log.i("i","  Fragment  执行onAttach");

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        Log.i("i"," Fragment 执行onCreate");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        Log.i("i"," Fragment 执行onActivityCreated");

    }
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        Log.i("i"," Fragment 执行onStart");
    }
    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        Log.i("i"," Fragment 执行onPause");
    }
    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Log.i("i"," Fragment 执行onResume");
    }

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        Log.i("i"," Fragment 执行onStop");
    }
    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Log.i("i", " Fragment 执行onDestroy");
    }
    @Override
    public void onDetach() {
        // TODO Auto-generated method stub
        super.onDetach();
        Log.i("i"," Fragment 执行onDetach");
    }

}
