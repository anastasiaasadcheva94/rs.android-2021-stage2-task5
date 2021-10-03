package by.android.android_2021_task_5.ui.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.android.android_2021_task_5.databinding.ItemRvBinding


class ViewHolder(binding: ItemRvBinding) : RecyclerView.ViewHolder(binding.root) {
    var imageCat: ImageView = binding.itemImage
    var textCat: TextView = binding.itemText
}
