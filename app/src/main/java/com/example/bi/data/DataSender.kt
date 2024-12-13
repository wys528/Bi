package com.example.bi.data

import com.example.bi.R
import com.example.bi.model.UpList

class DataSender {

    fun createData(): List<UpList> {
        return listOf(
            UpList("up1", R.drawable.img),
            UpList("up2", R.drawable.img_1),
            UpList("up3", R.drawable.img_2),
            UpList("up4", R.drawable.img_3),
            UpList("up5",R.drawable.img_4),
            UpList("up6",R.drawable.img_5),
            UpList("up7", R.drawable.img_6),
            UpList("up8", R.drawable.img_7),
            UpList("up9", R.drawable.img_8),
            UpList("up10", R.drawable.img_9),
            UpList("up11", R.drawable.img_10),
            UpList("up12",R.drawable.img_11)
        )
    }
}
