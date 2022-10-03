package tw.edu.ntub.im.myrockrps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtUserName = findViewById<TextView>(R.id.txtUserName)
        val rgGuess = findViewById<RadioGroup>(R.id.rgGuess)
        val btnGo = findViewById<Button>(R.id.btnGo)
        val txtResultName = findViewById<TextView>(R.id.txtResultName)
        val txtResultWin = findViewById<TextView>(R.id.txtResultWin)
        val txtResultMe = findViewById<TextView>(R.id.txtResultMe)
        val txtResultComp = findViewById<TextView>(R.id.txtResultComp)

        btnGo.setOnClickListener{
            /**
             * 1. 剪刀
             * 2. 石頭
             * 3. 布
             */
            val rand = Random.nextInt(1, 4)
            Log.d("MyGuess", "onCreate: comp-rand: $rand")
            txtResultName.text = txtUserName.text
            txtResultMe.text = when(rgGuess.checkedRadioButtonId) {
                R.id.rbtnScissor -> "剪刀"
                R.id.rbtnRock -> "石頭"
                R.id.rbtnPaper -> "布"
                else -> "玩家寫錯了啦"
            }
            txtResultComp.text = when(rand) {
                1 -> "剪刀"
                2-> "石頭"
                3 -> "布"
                else -> "電腦寫錯了啦"
            }
            when(true){
                rand == 1 && rgGuess.checkedRadioButtonId == R.id.rbtnScissor,
                rand == 2 && rgGuess.checkedRadioButtonId == R.id.rbtnRock,
                rand == 3 && rgGuess.checkedRadioButtonId == R.id.rbtnPaper-> txtResultWin.text = "平手"
                rand == 1 && rgGuess.checkedRadioButtonId == R.id.rbtnPaper,
                rand == 2 && rgGuess.checkedRadioButtonId == R.id.rbtnScissor,
                rand == 3 && rgGuess.checkedRadioButtonId == R.id.rbtnRock-> txtResultWin.text = "電腦贏"
                rand == 1 && rgGuess.checkedRadioButtonId == R.id.rbtnRock,
                rand == 2 && rgGuess.checkedRadioButtonId == R.id.rbtnPaper,
                rand == 3 && rgGuess.checkedRadioButtonId == R.id.rbtnScissor-> txtResultWin.text = "我贏了"
                else-> txtResultWin.text = "寫錯了"
            }

        }
    }
}