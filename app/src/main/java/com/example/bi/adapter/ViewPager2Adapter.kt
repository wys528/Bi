package com.example.bi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bi.databinding.DynamicInfoBinding
import com.example.bi.model.UpList

class ViewPager2Adapter(private var upLists: List<UpList>) : RecyclerView.Adapter<ViewPager2Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DynamicInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val upList = upLists[position]
        holder.binding.textView.text = "${upList.id} 的动态"
        holder.binding.imageView.setImageResource(upList.imageResId)
    }

    override fun getItemCount(): Int = upLists.size


    class ViewHolder(val binding: DynamicInfoBinding) : RecyclerView.ViewHolder(binding.root)
}
