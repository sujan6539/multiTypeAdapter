package com.sp.multitypeadapter

import android.content.ClipData.Item
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sp.multitypeadapter.adapter.ActionCallback
import com.sp.multitypeadapter.adapter.MultiTypeDataBoundAdapter


class ExampleActivityBaseObservable : BaseObservable() {

    interface OnItemClick : ActionCallback {
        fun onCustomClick()
    }

    var event = object : OnItemClick {
        override fun onCustomClick() {
            count= "${count}s"
        }
    }

    @Bindable
    var adapter = MultiTypeDataBoundAdapter(event)

    @Bindable
    var count = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.count)
        }
}