package esprims.gi2.tp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import esprims.gi2.tp3.classes.Mot
import esprims.gi2.tp3.classes.WordsManager
import kotlinx.android.synthetic.main.activity_compose.*

class ComposeActivity : AppCompatActivity() {
    val wordsManager : WordsManager = WordsManager(this)
    var nom : List<Mot> = ArrayList()
    var adj : List<Mot> = ArrayList()
    var l : String = String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compose)

        composeSub.setOnClickListener {
            wordsManager.openWriteDB()
            nom=wordsManager.getComposeNom(genreSelect.text.toString())
            adj=wordsManager.getComposeAdj(genreSelect.text.toString())
            if(genreSelect.text.toString()=="male")
                l = "Le"
            else if(genreSelect.text.toString()=="female")
                l = "La"
            resultCompose.text = l+" "+nom[0].leMot+" est "+adj[0].leMot
            wordsManager.closeDB()
        }
    }
}