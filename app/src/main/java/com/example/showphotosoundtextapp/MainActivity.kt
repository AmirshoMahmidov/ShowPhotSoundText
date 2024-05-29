package com.example.showphotosoundtextapp

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.showphotosoundtextapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.abu.setOnClickListener {
            playSound(R.raw.abu)
        }
        binding.MinionBananna.setOnClickListener {
            playSound(R.raw.minion_myz)
        }

        binding.MinionBananna2.setOnClickListener {
            playSound(R.raw.banana)
        }

        binding.CipiCipi.setOnClickListener {
            playSound(R.raw.chi)
        }

        binding.Ketchup.setOnClickListener {
            playSound(R.raw.moinez)
        }

        binding.obez.setOnClickListener {
            playSound(R.raw.brue)
        }
    }

    private fun playSound(soundRes: Int) {
        stopMediaPlayer()
        mediaPlayer = MediaPlayer.create(this, soundRes).apply {
            start()
        }
    }

    private fun stopMediaPlayer() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
            }
            it.release()
            mediaPlayer = null
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopMediaPlayer()
    }
}
