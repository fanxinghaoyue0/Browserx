package cn.fanxinghaoyue.browserx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    private ImageButton mIbRe, mIbBa, mIbFr, mIbFu, mIbEx, mIbRef, mIbGo;
    private ImageButton m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15;
    private EditText mEdUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIbRe = findViewById(R.id.ib_refe);
        mIbBa = findViewById(R.id.ib_back);
        mIbFr = findViewById(R.id.ib_front);
        mIbFu = findViewById(R.id.ib_full);
        mIbEx = findViewById(R.id.ib_exit);
        mIbRef = findViewById(R.id.btn_refresh);
        mIbGo = findViewById(R.id.btn_go);
        mEdUrl = findViewById(R.id.ed_mainurl);
        m1 = findViewById(R.id.btn_baidu);
        m2 = findViewById(R.id.btn_taobao);
        m3 = findViewById(R.id.btn_douban);
        m4 = findViewById(R.id.btn_weibo);
        m5 = findViewById(R.id.btn_amazon);
        m6 = findViewById(R.id.btn_dang);
        m7 = findViewById(R.id.btn_ju);
        m8 = findViewById(R.id.btn_qq);
        m9 = findViewById(R.id.btn_youku);
        m10 = findViewById(R.id.btn_renren);
        m11 = findViewById(R.id.btn_sina);
        m12 = findViewById(R.id.btn_yahoo);
        m13 = findViewById(R.id.btn_wangyi);
        m14 = findViewById(R.id.btn_souhu);
        m15 = findViewById(R.id.btn_jd);
        OnClick onClick = new OnClick();
        setBg(mIbRe);
        setBg(mIbBa);
        setBg(mIbFr);
        setBg(mIbFu);
        setBg(mIbEx);
        setBg(mIbRef);
        setBg(mIbGo);

        m1.setOnClickListener(onClick);
        m2.setOnClickListener(onClick);
        m3.setOnClickListener(onClick);
        m4.setOnClickListener(onClick);
        m5.setOnClickListener(onClick);
        m6.setOnClickListener(onClick);
        m7.setOnClickListener(onClick);
        m8.setOnClickListener(onClick);
        m9.setOnClickListener(onClick);
        m10.setOnClickListener(onClick);
        m11.setOnClickListener(onClick);
        m12.setOnClickListener(onClick);
        m13.setOnClickListener(onClick);
        m14.setOnClickListener(onClick);
        m15.setOnClickListener(onClick);
        mEdUrl.setOnKeyListener(onKeyListener);
        mEdUrl.setInputType(InputType.TYPE_CLASS_TEXT);
        mEdUrl.setFocusableInTouchMode(true);
        mIbEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("提示");
                builder.setMessage("确定要退出吗？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                final Dialog dialog = builder.show();

            }
        });
        mIbGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                Bundle bundle = new Bundle();

                if ((mEdUrl.getText().toString().endsWith(".com"))|(mEdUrl.getText().toString().endsWith(".cn"))|(mEdUrl.getText().toString().endsWith(".net"))|(mEdUrl.getText().toString().endsWith(".org"))|(mEdUrl.getText().toString().endsWith(".edu"))|(mEdUrl.getText().toString().endsWith(".gov"))|(mEdUrl.getText().toString().endsWith(".top"))|(mEdUrl.getText().toString().endsWith(".xyz"))){
                    if (!(mEdUrl.getText().toString().startsWith("http"))) {
                        mEdUrl.setText("http://"+mEdUrl.getText().toString());
                    }
                    bundle.putString("link",mEdUrl.getText().toString());
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);


                }


                else {
                    bundle.putString("link", "https://m.baidu.com/s?word=" + mEdUrl.getText().toString());
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }


            }

        });

    }


    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_baidu: {
                    Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("link", "https://Google.com");
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
                }
                case R.id.btn_taobao: {
                    Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("link", "https://ai.m.taobao.com/index.html");
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
                }
                case R.id.btn_douban: {
                    Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("link", "https://m.douban.com/home_guide");
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
                }
                case R.id.btn_weibo: {
                    Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("link", "https://m.weibo.cn");
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
                }
                case R.id.btn_amazon: {
                    Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("link", "https://www.amazon.cn");
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
                }
                case R.id.btn_dang: {
                    Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("link", "http://m.dangdang.com");
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
                }
                case R.id.btn_ju: {
                    Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("link", "https://jhs.m.taobao.com/m/index.htm");
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
                }
                case R.id.btn_qq: {
                    Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("link", "https://3gqq.qq.com");
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
                }
                case R.id.btn_youku: {
                    Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("link", "https://www.youku.com");
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
                }
                case R.id.btn_renren: {
                    Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("link", "http://activity.renren.com");
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
                }
                case R.id.btn_sina: {
                    Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("link", "https://sina.cn");
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
                }
                case R.id.btn_yahoo: {
                    Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("link", "https://www.baidu.com");
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
                }
                case R.id.btn_wangyi: {
                    Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("link", "https://3g.163.com/touch/#/");
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
                }
                case R.id.btn_souhu: {
                    Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("link", "https://m.sohu.com/limit/");
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
                }
                case R.id.btn_jd: {
                    Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("link", "https://m.jd.com");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                }
            }
        }

    }

    private View.OnKeyListener onKeyListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == KeyEvent.KEYCODE_ENTER) {


                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputMethodManager.isActive()) {

                    inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);

                }
                Intent intent = new Intent(MainActivity.this, WebVIewActivity.class);
                Bundle bundle = new Bundle();


                if ((mEdUrl.getText().toString().endsWith(".com"))|(mEdUrl.getText().toString().endsWith(".cn"))|(mEdUrl.getText().toString().endsWith(".net"))|(mEdUrl.getText().toString().endsWith(".org"))|(mEdUrl.getText().toString().endsWith(".edu"))|(mEdUrl.getText().toString().endsWith(".gov"))|(mEdUrl.getText().toString().endsWith(".top"))|(mEdUrl.getText().toString().endsWith(".xyz"))){
                    if (!(mEdUrl.getText().toString().startsWith("http"))) {
                        mEdUrl.setText("http://"+mEdUrl.getText().toString());
                    }
                    bundle.putString("link",mEdUrl.getText().toString());
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);


                }


                else {
                    bundle.putString("link", "https://m.baidu.com/s?word=" + mEdUrl.getText().toString());
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }




            }




            return false;
        }
    };
    boolean doubleBackToExitPressedOnce = false;

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (doubleBackToExitPressedOnce) {
                        super.onBackPressed();
                    }

                    this.doubleBackToExitPressedOnce = true;
                    Toast.makeText(this, "两次点击才能退出", Toast.LENGTH_SHORT).show();

                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            doubleBackToExitPressedOnce = false;
                        }
                    }, 2000);
            }

            return true;

        }


        return super.onKeyDown(keyCode, event);

    }

    private void setBg(ImageButton imageButton) {

        imageButton.getBackground().setAlpha(0);
    }

}
