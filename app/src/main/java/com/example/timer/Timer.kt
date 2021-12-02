package com.example.timer

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.timer.databinding.FragmentTimerBinding

class Timer : Fragment(R.layout.fragment_timer) {

    private lateinit var binding: FragmentTimerBinding
    private var timeNow = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTimerBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val handler = Handler(Looper.getMainLooper())

        binding.btnStart.setOnClickListener {
            if (timeNow == 0) {
                timeNow = binding.edtxtSetTimer.text.toString().toInt()
            }

            binding.edtxtSetTimer.text.clear()
            tickTime(handler)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun tickTime(handler: Handler) {
        handler.postDelayed({
            if (timeNow > 0) {
                binding.txtTimer.text = "Seconds left $timeNow"
                timeNow--
                tickTime(handler)
            } else {
                Toast.makeText(context, "Time is out!", Toast.LENGTH_SHORT).show()
                timeNow = 0
                binding.edtxtSetTimer.text = null
            }
        }, 1000)
    }
}