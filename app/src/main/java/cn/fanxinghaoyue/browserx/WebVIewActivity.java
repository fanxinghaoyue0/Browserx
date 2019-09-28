package cn.fanxinghaoyue.browserx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.just.agentweb.AgentWeb;

public class WebVIewActivity extends AppCompatActivity {
    private WebView webView;

    private EditText mEdU;
    private ImageButton mIbRe, mIbBa, mIbFr, mIbFu, mIbEx, mIbRef, mIbGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mIbRe = findViewById(R.id.ib_refe);
        mIbBa = findViewById(R.id.ib_back);
        mIbFr = findViewById(R.id.ib_front);
        mIbFu = findViewById(R.id.ib_full);
        mIbEx = findViewById(R.id.ib_exit);
        mIbRef = findViewById(R.id.btn_refresh);
        mEdU = findViewById(R.id.ed_url);
        mIbGo = findViewById(R.id.btn_go);
        webView = findViewById(R.id.webview);
        setBg(mIbGo);
        setBg(mIbRe);
        setBg(mIbBa);
        setBg(mIbFr);
        setBg(mIbFu);
        setBg(mIbEx);
        setBg(mIbRef);
        mEdU.setOnKeyListener(onKeyListener);


        WebSettings settings = webView.getSettings();
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webView.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 10; GM1910) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/10.1 Chrome/71.0.3578.99 Mobile Safari/537.36");
        final WebChromeClient webChromeClient = new WebChromeClient();

        webView.setWebChromeClient(webChromeClient);
        WebViewClient webViewClient = new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                mEdU.setText(webView.getUrl());
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                try{
                    if(url.startsWith("intent:")||url.startsWith("baiduboxapp:")||url.startsWith("baiduboxlite:")||url.startsWith("taobao:")||url.startsWith("alipays:")||url.startsWith("douban:")||url.startsWith("dangdang:")||url.startsWith("dingtalk:")
                            ||url.startsWith("taobaotravel:")
                            ||url.startsWith("suning")
                            ||url.startsWith("tmall:")
                            ||url.startsWith("mqq:")
                            ||url.startsWith("mqqapi:")
                            ||url.startsWith("mqqiapi:")
                            ||url.startsWith("qqmusic:")
                            ||url.startsWith("qq browser:")
                            ||url.startsWith("qqmail:")
                            ||url.startsWith("qqbizmailDistribute2:")
                            ||url.startsWith("tenvideo:")
                            ||url.startsWith("tenvideo2:")
                            ||url.startsWith("tenvideo3:")
                            ||url.startsWith("qqnews:")
                            ||url.startsWith("weiyun:")
                            ||url.startsWith("sosomap:")
                            ||url.startsWith("tenvideo:")
                            ||url.startsWith("tencent382:")
                            ||url.startsWith("mttbrowser:")
                            ||url.startsWith("qmtoken:")
                            ||url.startsWith("mqqsecure:")
                            ||url.startsWith("TencentWeibo:")
                            ||url.startsWith("tencent100689806:")
                            ||url.startsWith("weixin:")
                            ||url.startsWith("	wechat:")
                            ||url.startsWith("wechat:")
                            ||url.startsWith("baidu:")
                            ||url.startsWith("com.baidu.tieba:")
                            ||url.startsWith("baidumap:")
                            ||url.startsWith("photowonder:")
                            ||url.startsWith("bainuo:")
                            ||url.startsWith("baiduvideoiphone:")
                            ||url.startsWith("bdviphapp:")
                            ||url.startsWith("baiduyun:")
                            ||url.startsWith("bdNavi:")
                            ||url.startsWith("BaiduIMShop:")
                            ||url.startsWith("wondercamera://:")
                            ||url.startsWith("neteasemail://:")
                            ||url.startsWith("newsapp://:")
                            ||url.startsWith("orpheuswidget://:")
                            ||url.startsWith("yddict:/:")
                            ||url.startsWith("imeituan:")
                            ||url.startsWith("dianping::")
                            ||url.startsWith("meituanwaimai:")
                            ||url.startsWith("dianping::")
                            ||url.startsWith("cn.12306:")
                            ||url.startsWith("openApp.jdMobile:/:")
                            ||url.startsWith("snssdk141:")
                            ||url.startsWith("amap:")
                            ||url.startsWith("weibo:")
                            ||url.startsWith("youku:")
                            ||url.startsWith("iqiyi:")
                            ||url.startsWith("qiyi:")){//过滤
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        //startActivity(intent);//防止开启三方软件
                        return true;
                    }
                }catch (Exception e){
                    return false;
                }
                webView.loadUrl(url);
                return true;
            }



        };
        webView.setWebViewClient(webViewClient);


        Bundle bundle = getIntent().getExtras();

        webView.loadUrl(bundle.getString("link").toString());

        mIbFu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WebVIewActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        mIbFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (webView.canGoForward()) {

                    webView.goForward();
                } else {
                    finish();
                }
            }
        });
        mIbEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(WebVIewActivity.this);

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
        mIbBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (webView.canGoBack()) {
                    webView.goBack();

                } else {
                    Intent intent = new Intent(WebVIewActivity.this, MainActivity.class);
                    startActivity(intent);


                }

            }
        });
        mIbRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.reload();
            }
        });
        mIbRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.reload();
            }
        });
        mIbGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mEdU.getText().toString().endsWith(".com")) || (mEdU.getText().toString().endsWith(".cn")) || (mEdU.getText().toString().endsWith(".net")) || (mEdU.getText().toString().endsWith(".org")) || (mEdU.getText().toString().endsWith(".edu")) || (mEdU.getText().toString().endsWith(".gov")) || (mEdU.getText().toString().endsWith(".top"))|| (mEdU.getText().toString().endsWith(".xyz"))||(mEdU.getText().toString().endsWith(".com/"))||(mEdU.getText().toString().endsWith(".cn/"))) {
                    if (!(mEdU.getText().toString().startsWith("http"))) {
                        mEdU.setText("http://" + mEdU.getText().toString());
                    }
                    webView.loadUrl(mEdU.getText().toString());


                } else {
                    webView.loadUrl("https://m.baidu.com/s?word=" + mEdU.getText().toString());


                }

            }
        });


        mEdU.setText(webView.getUrl());


    }


    private void setBg(ImageButton imageButton) {

        imageButton.getBackground().setAlpha(0);
    }


    boolean doubleBackToExitPressedOnce = false;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack();
                return true;
            } else {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);


            }
        }
        return super.onKeyDown(keyCode, event);
    }


    private View.OnKeyListener onKeyListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == KeyEvent.KEYCODE_ENTER) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputMethodManager.isActive()) {

                    inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);

                }

                if ((mEdU.getText().toString().endsWith(".com")) | (mEdU.getText().toString().endsWith(".com/")) | (mEdU.getText().toString().endsWith(".cn")) | (mEdU.getText().toString().endsWith(".cn/")) | (mEdU.getText().toString().endsWith(".net")) | (mEdU.getText().toString().endsWith(".org")) | (mEdU.getText().toString().endsWith(".edu")) | (mEdU.getText().toString().endsWith(".gov")) | (mEdU.getText().toString().endsWith(".top")) | (mEdU.getText().toString().endsWith(".xyz"))) {
                    if (!(mEdU.getText().toString().startsWith("http"))) {
                        mEdU.setText("http://" + mEdU.getText().toString());
                    }
                    webView.loadUrl(mEdU.getText().toString());


                } else {
                    webView.loadUrl("https://m.baidu.com/s?word=" + mEdU.getText().toString());


                }
                return true;


            }

            return false;
        }
    };


}
