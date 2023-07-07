package com.android.youkumenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import com.android.youkumenu.util.Tools

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rlLevel1: RelativeLayout
    private lateinit var rlLevel2: RelativeLayout
    private lateinit var rlLevel3: RelativeLayout

    private val isLevel1Show: Boolean = true
    private var isLevel2Show: Boolean = true
    private var isLevel3Show: Boolean = true

    private lateinit var ivHome: ImageView
    private lateinit var ivMenu: ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivHome = findViewById(R.id.iv_home)
        ivMenu = findViewById(R.id.iv_menu)

        rlLevel1 = findViewById(R.id.rl_level1)
        rlLevel2 = findViewById(R.id.rl_level2)
        rlLevel3 = findViewById(R.id.rl_level3)

        ivHome.setOnClickListener(this)
        ivMenu.setOnClickListener(this)

        // 为了避免第三层布局将一二层事件拦截掉, 需要在布局文件中最先注册第三层, 最后注册第一层
        rlLevel3.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.iv_home -> {
                Log.d(TAG, "home clicked!")
                if (Tools.animationNum != 0) {
                }
                if (isLevel2Show) {
                    Tools.hideView(rlLevel2)
                    isLevel2Show = false

                    if (isLevel3Show) {
                        Tools.hideView(rlLevel3, 200)
                        isLevel3Show = false
                    }
                } else {
                    Tools.hideView(rlLevel2)
                    isLevel2Show = true
                }

            }

            R.id.iv_menu -> {

                isLevel3Show = if (isLevel2Show) {
                    Tools.hideView(rlLevel3)
                    false
                } else {
                    Tools.hideView(rlLevel3)
                    true
                }
            }

        }
    }
}