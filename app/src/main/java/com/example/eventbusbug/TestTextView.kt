package com.example.eventbusbug

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class TestTextView : AppCompatTextView {
    companion object {
        const val TAG = "TestTextView"
    }

    data class Event(val value: Int)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        EventBus.getDefault().register(this)

        Log.i(TAG, "Attached.")

        EventBus.getDefault().post(Event(123))
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        EventBus.getDefault().unregister(this)

        Log.i(TAG, "Detached.")
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun foo(e: Event) {
        Log.i(TAG, "bar: ${e.value}")
    }
}