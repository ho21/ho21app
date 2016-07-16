package ho21.com.app.activity;

import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import ho21.com.app.fragment.HeaderFragment;
import ho21.com.app.fragment.ListFragment;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    FragmentTransaction transaction;
    ListFragment listFragment;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.menu_list) LinearLayout leftMenuList;
    @BindView(R.id.setting) TextView setting;
    @BindView(R.id.app_title) TextView app_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_container);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        //左侧菜单列表
        leftMenuList = (LinearLayout) findViewById(R.id.menu_list);
////        Typeface iconfont = Typeface.createFromAsset(getAssets(), "iconfont/iconfont.ttf");
        for (int i = 0; i < leftMenuList.getChildCount(); i++) {
            TextView item = (TextView) leftMenuList.getChildAt(i);
//            item.setTypeface(iconfont);
            item.setOnClickListener(this);
            item.setTextColor(Color.parseColor("#000000"));
        }
////        setting.setTypeface(iconfont);
        setting.setOnClickListener(this);
        defaultFragment();
    }

    @Override
    public void onClick(View v) {
        //设置标题
        v.findViewById(R.id.setting);
        TextView tv = (TextView) v.findViewById(v.getId());
        app_title.setText(tv.getText().toString());
        //布局切换
        transaction = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.funny_pic:
                listFragment = new ListFragment(1);
                transaction.replace(R.id.page_container, listFragment);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.gif_pic:
                listFragment = new ListFragment(3);
                transaction.replace(R.id.page_container, listFragment);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.vision_pic:
                listFragment = new ListFragment(5);
                transaction.replace(R.id.page_container, listFragment);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            //设置
            case R.id.setting:
                drawerLayout.closeDrawer(GravityCompat.START);
                drawerLayout.openDrawer(GravityCompat.END);
                break;
            default:
                listFragment = new ListFragment(1);
                transaction.replace(R.id.page_container, listFragment);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }
        transaction.commit();
    }


    public void defaultFragment() {
        transaction = getFragmentManager().beginTransaction();
//        HeaderFragment headerFragment = new HeaderFragment(drawerLayout);
//        transaction.replace(R.id.page_header, headerFragment);
        ListFragment listFragment = new ListFragment(1);
        transaction.replace(R.id.page_container, listFragment);
        transaction.commit();
    }


    private long exitTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
