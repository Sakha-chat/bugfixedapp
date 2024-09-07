package com.morpankh.sakha

import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar?.hide()

        // Initialize the WebView
        webView = findViewById(R.id.Sakha)

        // Set up the WebView
        webViewSetUp(webView)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetUp(webView: WebView) {
        webView.webViewClient = WebViewClient()
        webView.apply {
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
            loadUrl("https://home.sakha.chat")
        }
    }

    override fun onBackPressed() {
        // Check if the WebView can go back
        if (webView.canGoBack()) {
            webView.goBack() // Go back in the WebView history
        } else {
            super.onBackPressed() // If there's no history, exit the activity
        }
    }
}
