package sl.kingdom.project4

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.michaelrocks.paranoid.Obfuscate


@Obfuscate
class GameActivity: AppCompatActivity() {
    lateinit var liveData: LiveData

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        liveData = ViewModelProvider(this)[LiveData::class.java]
        var score:Int
        val ball1: ImageButton = findViewById(R.id.ball1)
        val ball2: ImageButton = findViewById(R.id.ball2)
        val ball3: ImageButton = findViewById(R.id.ball3)
        val ball4: ImageButton = findViewById(R.id.ball4)
        val ball5: ImageButton = findViewById(R.id.ball5)
        val ball6: ImageButton = findViewById(R.id.ball6)
        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.shop)
        val button2: Button = findViewById(R.id.confirm)
        val balls = arrayOf(ball1,ball2,ball3,ball4,ball5,ball6)
        

        val clickListener = View.OnClickListener {
            it.animate().scaleX(1.1f).scaleY(1.1f).duration = 50
            Handler(Looper.getMainLooper()).postDelayed({
                it.animate().scaleX(1f).scaleY(1f).duration = 50
                                                        }, 50)

            Data.score+=Data.power
            var score=Data.score
            textView.text="Tap Points(TP): $score"
        }
        ball1.setOnClickListener(clickListener)
        ball2.setOnClickListener(clickListener)
        ball3.setOnClickListener(clickListener)
        ball4.setOnClickListener(clickListener)
        ball5.setOnClickListener(clickListener)
        ball6.setOnClickListener(clickListener)

        button.setOnClickListener{
            startActivity(Intent(this, ShopActivity::class.java))
        }
    val container: ConstraintLayout = findViewById(R.id.Container)
    button2.setOnClickListener{
        score=Data.score
        textView.text="Tap Points(TP): $score"

        balls.forEach{
            it.visibility = View.INVISIBLE}
        balls[Data.active_ball].visibility = View.VISIBLE

        when (Data.active_arena){
            1->container.background = resources.getDrawable(R.drawable.arena1)
            2->container.background = resources.getDrawable(R.drawable.arena3)
            3->container.background = resources.getDrawable(R.drawable.arena4)
            4->container.background = resources.getDrawable(R.drawable.arena5)
        }


    }
    }
//    fun switchFragment(fragment: Fragment) {
//        val manager = supportFragmentManager
//        val transaction = manager.beginTransaction()
//        transaction.replace(R.id.shop_fragment, fragment, null)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }
}