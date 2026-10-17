package sl.kingdom.project4
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.michaelrocks.paranoid.Obfuscate

@Obfuscate
class LiveData: ViewModel() {

    var score = 0
    var power = 1

    val activeBall: MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }
    val activeArena: MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }
    val boughtBalls: MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }
    val boughtArenas: MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }
}
