package com.google.firebase.samples.apps.mlkit.com.google.firebase.samples.apps.mlkit.java.arecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.samples.apps.mlkit.R
import com.google.firebase.samples.apps.mlkit.com.google.firebase.samples.apps.mlkit.java.api.RetrofitHelper

class RVAdapter : RecyclerView.Adapter<RVAdapter.VH>() {

    class VH(val view: View) : RecyclerView.ViewHolder(view)

    private val items: ArrayList<RetrofitHelper.Model> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {

    }

    fun setData(models: ArrayList<RetrofitHelper.Model>) {
        items.clear()
        items.addAll(models)
        notifyDataSetChanged()
    }

}