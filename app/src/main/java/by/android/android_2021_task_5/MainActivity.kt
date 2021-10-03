package by.android.android_2021_task_5

import android.animation.AnimatorSet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import by.android.android_2021_task_5.databinding.ActivityMainBinding
import by.android.android_2021_task_5.interfaces.ItemClickListener
import by.android.android_2021_task_5.ui.CatFragment
import by.android.android_2021_task_5.ui.FullscreenCatFragment
import com.bumptech.glide.Glide
import kotlinx.coroutines.Job

class MainActivity : AppCompatActivity(), ItemClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openCatFragment()
    }

    private fun openCatFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, CatFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun openSecondFragment(nextFragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, nextFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun second(nextFragment: Fragment) {
        openSecondFragment(nextFragment)
    }
}