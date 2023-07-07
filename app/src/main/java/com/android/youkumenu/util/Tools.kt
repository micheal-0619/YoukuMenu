package com.android.youkumenu.util

import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation


object Tools {
    var animationNum = 0
    fun hideView(view: ViewGroup) {
        hideView(view, 0)
    }

    fun showView(view: ViewGroup) {
        showView(view, 0)
    }

    /**
     * 隐藏动画
     * @param view 将要执行动画的视图
     * @param delay 动画要延迟执行的时间
     */
    fun hideView(view: ViewGroup, delay: Long) {
        /**
         * 第一个参数： fromDegrees 起始角度，这里我们设置为 0
         * 第二个参数: toDegrees 目标角度，这里设置为 180 度
         * 第三个参数: pivotXType 相对于 X 坐标类型，这里是相对于自己
         * 第四个参数: pivotXValue 相对于 X 坐标类型的值，这里是 0.5f,也就是 X 轴的一半
         * 第五个参数: pivotYType 相对于 Y 坐标类型，这里是相对于自己
         * 第六个参数: pivotYValue 相对于 Y 坐标类型的值，这里是 1.f,也就是 Y 坐标最大处
         * RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType,
         * pivotYValue)
         */
        val anim: RotateAnimation = RotateAnimation(
            0F,
            180F,
            Animation.RELATIVE_TO_SELF,
            0.5F,
            Animation.RELATIVE_TO_SELF,
            1F
        )
        anim.duration = 500 //动画执行时间
        anim.fillAfter = true // 保持动画后的状态
        anim.startOffset = delay //延迟多长时间后才运行动画
        anim.setAnimationListener(MyAnimationListener())
        view.startAnimation(anim)

        // 开启所有孩子的点击事件
        val childCount: Int = view.childCount
        for (i in 0 until childCount) {
            view.getChildAt(i).isEnabled = false
        }
    }

    /**
     * 隐藏动画
     * @param view 将要执行动画的视图
     * @param delay 动画要延迟执行的时间
     */
    fun showView(view: ViewGroup, delay: Long) {
        /**
         * 第一个参数： fromDegrees 起始角度，这里我们设置为 0
         * 第二个参数: toDegrees 目标角度，这里设置为 180 度
         * 第三个参数: pivotXType 相对于 X 坐标类型，这里是相对于自己
         * 第四个参数: pivotXValue 相对于 X 坐标类型的值，这里是 0.5f,也就是 X 轴的一半
         * 第五个参数: pivotYType 相对于 Y 坐标类型，这里是相对于自己
         * 第六个参数: pivotYValue 相对于 Y 坐标类型的值，这里是 1.f,也就是 Y 坐标最大处
         * RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType,
         * pivotYValue)
         */
        val anim: RotateAnimation = RotateAnimation(
            180F,
            360F,
            Animation.RELATIVE_TO_SELF,
            0.5F,
            Animation.RELATIVE_TO_SELF,
            1F
        )
        anim.duration = 500 //动画执行时间
        anim.fillAfter = true // 保持动画后的状态
        anim.startOffset = delay //延迟多长时间后才运行动画
        anim.setAnimationListener(MyAnimationListener())
        view.startAnimation(anim)

        // 开启所有孩子的点击事件
        val childCount: Int = view.childCount
        for (i in 0 until childCount) {
            view.getChildAt(i).isEnabled = true
        }
    }

    class MyAnimationListener : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation) {
            animationNum++
        }

        override fun onAnimationEnd(animation: Animation) {
            animationNum--
        }

        override fun onAnimationRepeat(animation: Animation) {
        }

    }


}