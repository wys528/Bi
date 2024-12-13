package com.example.bi.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bi.databinding.UpInfoBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: UpInfoBinding
    private lateinit var btnUnfollow: Button
    private lateinit var name: TextView
    private lateinit var focus: TextView
    private lateinit var follow: TextView
    private lateinit var avater :ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UpInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnUnfollow = binding.button
        name = binding.idInfo
        focus = binding.focusInfo
        follow = binding.fellowInfo
        avater = binding.avater

        // 获取传递过来的 up 主名称
        val upName = intent.getStringExtra("up_name")
        val upAvater = intent.getIntExtra("up_avater",0)

        name.text = upName
        focus.text = "关注：100"
        follow.text = "粉丝：100"
        avater.setImageResource(upAvater)


        // 取关按钮点击事件
        btnUnfollow.setOnClickListener {
            // 提示取关成功
            Toast.makeText(applicationContext, "取关成功", Toast.LENGTH_SHORT).show()

            // 返回数据到 MainActivity
            val intent = Intent()
            intent.putExtra("name", upName)

            setResult(RESULT_OK, intent) // 设置返回结果为 RESULT_OK，并传递数据
            // 关闭当前页面，返回 MainActivity
            finish()
        }
    }

    // 返回按钮处理，确保退出时返回默认结果
    override fun onBackPressed() {
        val intent = Intent()
        setResult(RESULT_CANCELED, intent) // 如果没有点击取关，返回 CANCELED
        super.onBackPressed()
    }
}
