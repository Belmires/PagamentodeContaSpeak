package com.example.pagamentodecontaspeak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button2.setOnClickListener {
            if (editTextNumber.toString() != "" && editTextNumber2.toString() != "") {
                val valorConta = editTextNumber.text.toString().toDouble()
                val valorRecebido = editTextNumber2.text.toString().toDouble()
                val taxa = textView4.text.toString().replace("%","").toDouble()
                val valorComTaxa = valorConta +((valorConta*taxa)/100)

                val total = valorComTaxa
                textView6.text = "R$ $total"

                val troco = valorRecebido - total
                textView8.text = "R$ $troco"
            }
        }
        button.setOnClickListener {
//                editTextNumber.text = ""
//                editTextNumber2.text = ""
                textView6.text = ""
                textView8.text = ""
            }
        initSeekBar()
        initTxServ()
    }

    private fun initSeekBar() {
        seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    textView4.text = progress.toString() + "%"
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            }
        )
    }

    private fun initTxServ() {
        textView4.text = seekBar.progress.toString() + "%"
    }
}