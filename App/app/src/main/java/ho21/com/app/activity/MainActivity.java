package ho21.com.app.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.widget.Toast;

import butterknife.ButterKnife;
import ho21.com.app.fragment.ListFragment;
import ho21.com.app.fragment.MenuFragment;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends Activity {

    FragmentTransaction transaction;
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        transaction = getFragmentManager().beginTransaction();
        MenuFragment menuFragment = new MenuFragment();
        ListFragment listFragment = new ListFragment();
        transaction.replace(R.id.menu_container,menuFragment);
        transaction.replace(R.id.container,listFragment);
        transaction.commit();
        transaction.
    }

    private long exitTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(this,"再按一次退出程序", LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void closeDrawer() {
        mDrawerLayout.closeDrawers();
    }

//    public void replaceFragment(int id,Fragment fragment) {
////        transaction = getFragmentManager().beginTransaction();
//        FragmentTransaction replace = transaction.replace(id, fragment);
//        transaction.commit();
//    }

}
