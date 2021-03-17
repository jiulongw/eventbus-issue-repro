package com.example.eventbusbug

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView

class TestTextView : AppCompatTextView {
    companion object {
        const val TAG = "TestTextView"
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        Log.i(TAG, "Attached.")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

        Log.i(TAG, "Detached.")
    }
}