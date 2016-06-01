package ho21.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Toast.makeText(getApplication(),"测试啦",Toast.LENGTH_SHORT).show();
    }
}


