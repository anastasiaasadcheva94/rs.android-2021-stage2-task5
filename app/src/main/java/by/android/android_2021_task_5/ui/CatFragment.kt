package by.android.android_2021_task_5.ui

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import by.android.android_2021_task_5.R
import by.android.android_2021_task_5.databinding.CatFragmentBinding
import by.android.android_2021_task_5.network.RestClient
import by.android.android_2021_task_5.ui.adapter.CatAdapter
import kotlinx.coroutines.*

class CatFragment : Fragment() {
    private lateinit var binding: CatFragmentBinding
    private lateinit var job: Job

    @DelicateCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CatFragmentBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }


    @DelicateCoroutinesApi
    private fun initUI() {
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
        }
        updateView()
    }

    @DelicateCoroutinesApi
    @SuppressLint("NotifyDataSetChanged")
    fun updateView() {
        job = GlobalScope.launch(Dispatchers.IO) {
            val response = RestClient().service.getDataFromAPI()
            val data = response.body()
            withContext(Dispatchers.Main) {
                val catAdapter = CatAdapter(data) //передаем в адаптер
                catAdapter.notifyDataSetChanged()
                binding.recyclerView.adapter = catAdapter
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        job.cancel()
    }

}