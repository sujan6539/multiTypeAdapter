package com.sp.mylibrary

import androidx.annotation.LayoutRes
import androidx.databinding.BaseObservable

abstract class BaseObservableLayoutItem : BaseObservable() {

    @get:LayoutRes
    abstract val layoutId: Int
}