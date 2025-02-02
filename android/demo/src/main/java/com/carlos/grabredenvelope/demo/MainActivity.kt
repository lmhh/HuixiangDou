package com.carlos.grabredenvelope.demo

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.carlos.cutils.base.CBaseAccessibilityActivity

class MainActivity : CBaseAccessibilityActivity() {

    private lateinit var btn_jump: Button
    private lateinit var btn_url: Button
    private lateinit var et_url: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        btn_jump = findViewById(R.id.btn_jump)
        btn_jump.setOnClickListener {
            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
            Toast.makeText(this@MainActivity, "找到（茴香豆）开启或关闭。", Toast.LENGTH_LONG)
                .show()
        }

        et_url = findViewById(R.id.et_url)

        btn_url = findViewById(R.id.btn_url)
        btn_url.setOnClickListener {
            var url = et_url.text.toString()
            var helper = SharedPreferenceHelper(applicationContext)
            helper.saveString("URL", url)
        }
    }
}
