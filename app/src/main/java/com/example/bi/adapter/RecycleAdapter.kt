package com.example.bi.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bi.databinding.UpListBinding
import com.example.bi.model.UpList

class RecycleAdapter(
    private var upLists: List<UpList>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecycleAdapter.MyViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position:Int)
        fun onLongItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = UpListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = upLists[position]
        holder.binding.id.text = item.id
        holder.binding.imageView.setImageResource(item.imageResId)

        holder.binding.root.setOnClickListener {
            onItemClickListener.onItemClick(position)
        }

        holder.binding.root.setOnLongClickListener {
            onItemClickListener.onLongItemClick(position)
            true
        }
    }

    override fun getItemCount(): Int = upLists.size

    class MyViewHolder(val binding: UpListBinding) : RecyclerView.ViewHolder(binding.root)
}
