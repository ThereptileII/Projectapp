package com.renovateglass.app.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.renovateglass.app.R

class WebContentFragment : Fragment(R.layout.fragment_web_content) {
    private var assetPath: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        assetPath = requireArguments().getString(ARG_ASSET_PATH)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.web_view)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        webView.setBackgroundColor(resources.getColor(R.color.deep_charcoal, null))
        val path = assetPath ?: return
        webView.loadUrl("file:///android_asset/$path")
    }

    companion object {
        private const val ARG_ASSET_PATH = "asset_path"

        fun newInstance(assetPath: String): WebContentFragment {
            return WebContentFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_ASSET_PATH, assetPath)
                }
            }
        }
    }
}
