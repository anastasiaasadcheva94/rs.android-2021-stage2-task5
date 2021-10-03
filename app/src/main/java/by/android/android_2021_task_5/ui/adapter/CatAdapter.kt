package by.android.android_2021_task_5.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.android.android_2021_task_5.MainActivity
import by.android.android_2021_task_5.R
import by.android.android_2021_task_5.databinding.ItemRvBinding
import by.android.android_2021_task_5.model.Response
import by.android.android_2021_task_5.ui.FullscreenCatFragment
import com.bumptech.glide.Glide

class CatAdapter (private val animals: Response?) : RecyclerView.Adapter<ViewHolder>() {
    private lateinit var binding: ItemRvBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val url = animals?.get(position)?.url.toString()
        val text = animals?.get(position)?.id.toString()

        Glide
            .with(holder.itemView.context)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.itemImage)

        binding.itemText.text = text
        holder.itemView.setOnClickListener {
            (holder.itemView.context as MainActivity).second(FullscreenCatFragment(text, url))
        }
    }

    override fun getItemCount(): Int {
            return animals?.size!!
    }

//    fun updateAnimalList(list: ArrayList<Any>) {
//        this.animals.apply {
//            clear()
//            addAll(list)
//        }
//    }

}