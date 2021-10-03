package by.android.android_2021_task_5.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.android.android_2021_task_5.R
import by.android.android_2021_task_5.databinding.FragmentFullscreenCatBinding
import by.android.android_2021_task_5.utils.saveMediaToStorage
import com.bumptech.glide.Glide


class FullscreenCatFragment (var text: String, var url: String) : Fragment() {
    private lateinit var binding: FragmentFullscreenCatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFullscreenCatBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        binding.fullImageView
        fullSize(text, url)
        binding.saveButton.setOnClickListener {
            val img = binding.fullImageView.drawable
            context?.let { it1 -> saveMediaToStorage(it1, img) }
        }
    }

    private fun fullSize(text: String, url: String) {
        Glide
            .with(this)
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.fullImageView)
        binding.fullTextView.text = text
    }
}