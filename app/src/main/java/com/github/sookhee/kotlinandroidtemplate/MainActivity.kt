package com.github.sookhee.kotlinandroidtemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.asLiveData
import com.github.sookhee.kotlinandroidtemplate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels {
        ViewModelFactory.getInstance()
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel.getUserList(USER_LIST_SIZE)

        observeFlow()
        initRecyclerView()
    }

    private fun observeFlow() {
        viewModel.userList.asLiveData().observe(this) {
            (binding.recyclerView.adapter as UserAdapter).setItems(it.results)
        }
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            adapter = UserAdapter()
        }
    }

    companion object {
        private const val USER_LIST_SIZE = 10
    }
}
