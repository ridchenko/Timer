package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.timer.databinding.ActivityMainBinding
import com.example.timer.databinding.FragmentActionBarBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var bindingActionBar: FragmentActionBarBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setDefaultFragment()

        setContentView(binding.root)
    }

    private fun setDefaultFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer, Stopwatch())
        }
        bindingActionBar.btnStopwatch.setOnClickListener() {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainer, Stopwatch())
            }
        }

        bindingActionBar.btnTimer.setOnClickListener() {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainer, Timer())
            }
        }
    }
}