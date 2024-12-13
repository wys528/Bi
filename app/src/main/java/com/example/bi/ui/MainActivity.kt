package com.example.bi.ui
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.bi.adapter.RecycleAdapter
import com.example.bi.adapter.ViewPager2Adapter
import com.example.bi.data.DataSender
import com.example.bi.databinding.ActivityMainBinding
import com.example.bi.model.UpList


class MainActivity : AppCompatActivity(), RecycleAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewPager2: ViewPager2
    private lateinit var recycleAdapter: RecycleAdapter
    private lateinit var viewPager2Adapter: ViewPager2Adapter

    private var upLists: MutableList<UpList> = DataSender().createData().toMutableList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerview
        viewPager2 = binding.viwepager2


        recycleAdapter = RecycleAdapter(upLists, this)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = recycleAdapter

        viewPager2Adapter = ViewPager2Adapter(upLists)
        viewPager2.adapter = viewPager2Adapter


    }

    override fun onItemClick(position: Int) {
        viewPager2.setCurrentItem(position, true)
    }

    override fun onLongItemClick(position: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("up_name", upLists[position].id)
        intent.putExtra("up_avater",upLists[position].imageResId)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val name = data?.getStringExtra("name")
            name?.let {
                removeUp(it)
            }
        }
    }
    private fun removeUp(name: String) {
        // 查找需要删除的项
        val index = upLists.indexOfFirst { it.id == name }

        if (index >= 0) {
            // 从 upLists 中删除该项
            upLists.removeAt(index)

            // 通知 RecyclerView 更新，删除该项
            recycleAdapter.notifyItemRemoved(index)

            // 更新 ViewPager2 的数据源
            viewPager2Adapter.notifyItemRemoved(index)

            // 如果需要更新其他项目的位置（如删除后更新项目的顺序）
            recycleAdapter.notifyItemRangeChanged(index, upLists.size)
            viewPager2Adapter.notifyItemRangeChanged(index, upLists.size)
        }
    }


}
