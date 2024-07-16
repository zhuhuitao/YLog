package com.atoto.ylog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        XLog.d("打印日志")
        XLog.d("/com.atoto.ylog D/AppCompatDelegate: Checking for metadata for AppLocalesMetadataHolderService : Service not found\n" +
                "om.atoto.ylog W/com.atoto.ylog: Accessing hidden method Landroid/view/View;->computeFitSystemWindows(Landroid/graphics/Rect;Landroid/graphics/Rect;)Z (unsupported, reflection, allowed)")
    }
}