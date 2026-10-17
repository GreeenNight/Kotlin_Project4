package sl.kingdom.project4

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import io.michaelrocks.paranoid.Obfuscate
import sl.kingdom.project4.Data.Companion.arenaBought
import sl.kingdom.project4.Data.Companion.ballBought


@Obfuscate
class ShopActivity: AppCompatActivity() {
    private lateinit var ball1: ImageButton
    private lateinit var ballGreenSquares:Array<View>
    private lateinit var arenaGreenSquares:Array<View>
    private lateinit var textView: TextView
    lateinit var liveData: LiveData
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
//        val rootView: View = inflater.inflate(R.layout.fragment_shop, container, false)


        liveData = ViewModelProvider(this)[LiveData::class.java]
        textView = findViewById(R.id.TP)
        val noTP = findViewById<TextView>(R.id.notp)
        val button = findViewById<Button>(R.id.button)
        val whiteSquare1 = findViewById<ImageButton>(R.id.whiteSquare1)
        val whiteSquare2 = findViewById<ImageButton>(R.id.whiteSquare2)
        val whiteSquare3 = findViewById<ImageButton>(R.id.whiteSquare3)
        val whiteSquare4 = findViewById<ImageButton>(R.id.whiteSquare4)
        val whiteSquare5 = findViewById<ImageButton>(R.id.whiteSquare5)
        val whiteSquare6 = findViewById<ImageButton>(R.id.whiteSquare6)
        val whiteSquare7 = findViewById<ImageButton>(R.id.whiteSquare7)
        val whiteSquare8 = findViewById<ImageButton>(R.id.whiteSquare8)
        val whiteSquare9 = findViewById<ImageButton>(R.id.whiteSquare9)
        val whiteSquare10 = findViewById<ImageButton>(R.id.whiteSquare10)
        val greenSquare1 = findViewById<ImageView>(R.id.greenSquare1)
        val greenSquare2 = findViewById<ImageView>(R.id.greenSquare2)
        val greenSquare3 = findViewById<ImageView>(R.id.greenSquare3)
        val greenSquare4 = findViewById<ImageView>(R.id.greenSquare4)
        val greenSquare5 = findViewById<ImageView>(R.id.greenSquare5)
        val greenSquare6 = findViewById<ImageView>(R.id.greenSquare6)
        val greenSquare7 = findViewById<ImageView>(R.id.greenSquare7)
        val greenSquare8 = findViewById<ImageView>(R.id.greenSquare8)
        val greenSquare9 = findViewById<ImageView>(R.id.greenSquare9)
        val greenSquare10 = findViewById<ImageView>(R.id.greenSquare10)

        var score = Data.score
        textView.text="TP: $score"

        button.setOnClickListener{
            finish()
        }
        val ballWhiteSquares = arrayOf(whiteSquare1,whiteSquare2,whiteSquare3,whiteSquare4,whiteSquare5,whiteSquare6)
        ballGreenSquares = arrayOf(greenSquare1,greenSquare2,greenSquare3,greenSquare4,greenSquare5,greenSquare6)
        val arenaWhiteSquares = arrayOf(whiteSquare7,whiteSquare8,whiteSquare9,whiteSquare10)
        arenaGreenSquares = arrayOf(greenSquare7,greenSquare8,greenSquare9,greenSquare10)

        ballGreenSquares[Data.active_ball].visibility = View.VISIBLE
        arenaGreenSquares[Data.active_arena-1].visibility = View.VISIBLE

        val ballClickListener = View.OnClickListener {
            when (it) {
                ballWhiteSquares[0] ->{ballGreenSqr(0)
//                    ball1?.visibility = View.INVISIBLE
                }
                ballWhiteSquares[1] -> {if (ballBought[1]) {
                    ballGreenSqr(1)
                }else if (!ballBought[1]&&Data.score>=5){
                    ballBought[1]=true
                    bought(noTP)
                    Data.score-=5
                    score=Data.score
                    textView.text="TP: $score"
                    ballGreenSqr(1)
                }else{notEnoughTP(noTP)}
                }
                ballWhiteSquares[2] ->{if (ballBought[2]) {
                    ballGreenSqr(2)
                }else if (!ballBought[2]&&Data.score>=15){
                    ballBought[2]=true
                    bought(noTP)
                    Data.score-=15
                    score=Data.score
                    textView.text="TP: $score"
                    ballGreenSqr(2)
                }else{notEnoughTP(noTP)}
                }
                ballWhiteSquares[3] ->{if (ballBought[3]) {
                    ballGreenSqr(3)
                }else if (!ballBought[3]&&Data.score>=50){
                    ballBought[3]=true
                    bought(noTP)
                    Data.score-=50
                    score=Data.score
                    textView.text="TP: $score"
                    ballGreenSqr(3)
                }else{notEnoughTP(noTP)}
                }
                ballWhiteSquares[4] ->{if (ballBought[4]) {
                    ballGreenSqr(4)
                }else if (!ballBought[4]&&Data.score>=400){
                    ballBought[4]=true
                    bought(noTP)
                    Data.score-=400
                    score=Data.score
                    textView.text="TP: $score"
                    ballGreenSqr(4)
                }else{notEnoughTP(noTP)}
                }
                ballWhiteSquares[5] ->{if (ballBought[5]) {
                    ballGreenSqr(5)
                }else if (!ballBought[5]&&Data.score>=100){
                    ballBought[5]=true
                    bought(noTP)
                    Data.score-=100
                    score=Data.score
                    textView.text="TP: $score"
                    ballGreenSqr(5)
                }else{notEnoughTP(noTP)}
                }
            }
        }
        whiteSquare1.setOnClickListener(ballClickListener)
        whiteSquare2.setOnClickListener(ballClickListener)
        whiteSquare3.setOnClickListener(ballClickListener)
        whiteSquare4.setOnClickListener(ballClickListener)
        whiteSquare5.setOnClickListener(ballClickListener)
        whiteSquare6.setOnClickListener(ballClickListener)

        val arenaClickListener = View.OnClickListener {
            when (it) {
                arenaWhiteSquares[0] ->{arenaGreenSqr(0)}
                arenaWhiteSquares[1] ->{if (arenaBought[1]) {
                    arenaGreenSqr(1)
                }else if (!arenaBought[1]&&Data.score>=50){
                    arenaBought[1]=true
                    bought(noTP)
                    Data.score-=50
                    score=Data.score
                    textView.text="TP: $score"
                    arenaGreenSqr(1)
                }else{notEnoughTP(noTP)}
                }
                arenaWhiteSquares[2] ->{if (arenaBought[2]) {
                    arenaGreenSqr(2)
                }else if (!arenaBought[2]&&Data.score>=100){
                    arenaBought[2]=true
                    bought(noTP)
                    Data.score-=100
                    score=Data.score
                    textView.text="TP: $score"
                    arenaGreenSqr(2)
                }else{notEnoughTP(noTP)}
                }
                arenaWhiteSquares[3] ->{if (arenaBought[3]) {
                    arenaGreenSqr(3)
                }else if (!arenaBought[3]&&Data.score>=500){
                    arenaBought[3]=true
                    bought(noTP)
                    Data.score-=500
                    score=Data.score
                    textView.text="TP: $score"
                    arenaGreenSqr(3)
                }else{notEnoughTP(noTP)}
                }
            }
        }
        whiteSquare7.setOnClickListener(arenaClickListener)
        whiteSquare8.setOnClickListener(arenaClickListener)
        whiteSquare9.setOnClickListener(arenaClickListener)
        whiteSquare10.setOnClickListener(arenaClickListener)
    }

    fun notEnoughTP(view: View) {
        view.visibility=View.VISIBLE
        val animation2 = AlphaAnimation(1f, 0f)
        animation2.duration = 200
        Handler(Looper.getMainLooper()).postDelayed({
            view.startAnimation(animation2)
        }, 300)
        Handler(Looper.getMainLooper()).postDelayed({
            view.visibility=View.INVISIBLE
        }, 300)
    }

    fun bought(view: TextView) {
        val score = Data.score
        textView.text="TP: $score"
        view.text="Bought!"
        view.setBackgroundResource(R.color.green)
        view.visibility=View.VISIBLE
        val animation2 = AlphaAnimation(1f, 0f)
        animation2.duration = 200
        Handler(Looper.getMainLooper()).postDelayed({
            view.startAnimation(animation2)
        }, 300)
        Handler(Looper.getMainLooper()).postDelayed({
            view.visibility=View.INVISIBLE
            view.text="Not enough TP"
            view.setBackgroundResource(R.color.red)
        }, 500)
    }

    fun ballGreenSqr(i:Int){
        if(i==5) Data.power=10
        else Data.power=i+1
        Data.active_ball = i
        ballGreenSquares.forEach{
            it.visibility = View.INVISIBLE}
        ballGreenSquares[i].visibility = View.VISIBLE
    }

    fun arenaGreenSqr(i:Int){
        arenaGreenSquares.forEach{
            it.visibility = View.INVISIBLE}
        arenaGreenSquares[i].visibility = View.VISIBLE
        Data.active_arena = i+1
    }
}