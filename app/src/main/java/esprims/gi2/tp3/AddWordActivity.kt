package esprims.gi2.tp3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import esprims.gi2.tp3.classes.Mot
import esprims.gi2.tp3.classes.WordsManager
import kotlinx.android.synthetic.main.activity_add_word.*

class AddWordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)
        val wordsManager : WordsManager = WordsManager(this)

        btnNew.setOnClickListener {
            wordsManager.openWriteDB()
            var mot : Mot = Mot(motInput.text.toString(),motInput.text.toString().length,typeInput.text.toString(),genreInput.text.toString())
            var verif : Long = wordsManager.addWord(mot)
            wordsManager.closeDB()
            if (verif>=0){
                setResult(Activity.RESULT_OK)
                finish()
            }else{
                setResult(Activity.RESULT_CANCELED)
                finish()
            }

        }
    }
}