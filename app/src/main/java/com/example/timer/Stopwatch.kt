package com.example.timer

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import com.example.timer.databinding.FragmentStopwatchBinding

class Stopwatch: Fragment(R.layout.fragment_stopwatch) {

    private lateinit var binding: FragmentStopwatchBinding
    private var isStop = false
    private var timeNow: Int = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val handler = Handler(Looper.getMainLooper())

        binding.btnStartStop.setOnClickListener {
            if (isStop){
                isStop = false
                tickTime(handler)
                binding.btnStartStop.text = "Stop"
            } else {
                isStop = true
                binding.btnStartStop.text = "Start"
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun tickTime(handler: Handler) {

        handler.postDelayed({
            while (!isStop){
                binding.txtStopwatch.text = "Passed $timeNow seconds"
                timeNow++
                tickTime(handler)
            }
        }, 1000)
    }
}