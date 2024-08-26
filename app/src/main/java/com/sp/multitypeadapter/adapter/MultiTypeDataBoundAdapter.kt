package com.sp.multitypeadapter.adapter

import androidx.databinding.ViewDataBinding
import com.sp.multitypeadapter.BR
import com.sp.mylibrary.BaseDataBoundAdapter
import com.sp.mylibrary.BaseObservableLayoutItem
import com.sp.mylibrary.DataBoundViewHolder
import java.util.Collections

class MultiTypeDataBoundAdapter(
    val actionCallback: ActionCallback,
    vararg items: Any?
): BaseDataBoundAdapter<ViewDataBinding>() {

    private val mItems: MutableList<Any?> = ArrayList()

    init {
        Collections.addAll(mItems, *items)
    }

    override fun bindItem(
        holder: DataBoundViewHolder<ViewDataBinding>?,
        position: Int,
        payloads: List<Any>?,
    ) {
        holder?.binding?.setVariable(BR.data, mItems[position])
        holder?.binding?.setVariable(BR.callback, actionCallback)
    }

    override fun getItemLayoutId(position: Int): Int {
        val item = getItem(position)
        return if (item is BaseObservableLayoutItem) {
            item.layoutId
        } else {
            throw IllegalArgumentException("Item must be BaseObservableLayoutItem")
        }
    }

    fun addItem(item: Any) {
        mItems.add(item)
        notifyItemInserted(mItems.size - 1)
    }

    fun getItem(position: Int): Any? {
        return mItems[position]
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun clear() {
        mItems.clear()
        notifyDataSetChanged()
    }

}


interface ActionCallback{

}