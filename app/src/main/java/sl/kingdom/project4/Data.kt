package sl.kingdom.project4
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.michaelrocks.paranoid.Obfuscate

@Obfuscate
class Data {
    companion object{
        var background = "drawable/arena1"
        var score = 0
        var power=1
        var active_ball=0
        var active_arena=1
        var ballBought = arrayOf(true,false,false,false,false,false)
        var arenaBought = arrayOf(true,false,false,false)
    }
}