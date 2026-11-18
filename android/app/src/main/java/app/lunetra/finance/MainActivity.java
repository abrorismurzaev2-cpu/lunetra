package app.lunetra.finance;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView webView;
    private static final String START_URL = "https://abrorismurzaev2-cpu.github.io/lunetra/";
    private static final String APP_HOST = "abrorismurzaev2-cpu.github.io";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.parseColor("#0B0B0E"));
        getWindow().setNavigationBarColor(Color.parseColor("#0B0B0E"));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

        webView = new WebView(this);
        webView.setBackgroundColor(Color.parseColor("#0B0B0E"));
        setContentView(webView);

        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setDatabaseEnabled(true);
        s.setCacheMode(WebSettings.LOAD_DEFAULT);
        s.setAllowFileAccess(false);
        s.setMediaPlaybackRequiresUserGesture(false);
        s.setSupportZoom(false);
        s.setBuiltInZoomControls(false);
        s.setDisplayZoomControls(false);
        s.setUseWideViewPort(true);
        s.setLoadWithOverviewMode(true);
        s.setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);

        webView.setWebViewClient(new WebViewClient() {
            private boolean openExternal(String url) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }

            private boolean isInternal(String url) {
                if (url == null) return true;
                Uri u = Uri.parse(url);
                String host = u.getHost();
                if (host == null) return true;
                // Stay in WebView only for our app pages
                return host.equals(APP_HOST) || host.endsWith(".github.io") && url.contains("/lunetra");
            }

            private boolean isExternalAppLink(String url) {
                if (url == null) return false;
                String lower = url.toLowerCase();
                return lower.startsWith("https://t.me/")
                        || lower.startsWith("http://t.me/")
                        || lower.startsWith("tg://")
                        || lower.startsWith("telegram.")
                        || lower.contains("telegram.me")
                        || lower.startsWith("mailto:")
                        || lower.startsWith("tel:")
                        || lower.startsWith("market:")
                        || lower.startsWith("intent:");
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();
                if (isExternalAppLink(url) || !isInternal(url)) {
                    openExternal(url);
                    return true; // we handled it — do NOT load inside WebView
                }
                return false;
            }

            @Override
            @SuppressWarnings("deprecation")
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (isExternalAppLink(url) || !isInternal(url)) {
                    openExternal(url);
                    return true;
                }
                return false;
            }
        });
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl(START_URL);
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
