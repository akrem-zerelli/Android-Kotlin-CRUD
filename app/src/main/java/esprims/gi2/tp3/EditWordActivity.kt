package esprims.gi2.tp3

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import esprims.gi2.tp3.classes.Mot
import esprims.gi2.tp3.classes.WordsManager
import kotlinx.android.synthetic.main.activity_add_word.*
import kotlinx.android.synthetic.main.activity_edit_word.*

class EditWordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_word)

        val wordsManager: WordsManager = WordsManager(this)
        val motOld = intent.getStringExtra("motOld")
        val typeOld = intent.getStringExtra("typeOld")
        val genreOld = intent.getStringExtra("genreOld")

        motUpdate.setText(motOld)
        typeUpdate.setText(typeOld)
        genreUpdate.setText(genreOld                                                                                                                                                                                                                                                                                                                                                                                                                )


        btnUpdate.setOnClickListener {
            wordsManager.openWriteDB()
            var mot: Mot = Mot(
                motUpdate.text.toString(),
                motUpdate.text.toString().length,
                typeUpdate.text.toString(),
                genreUpdate.text.toString()
            )
            var verif: Int = wordsManager.updateWord(mot,motOld)
            wordsManager.closeDB()
            if (verif >= 0) {
                setResult(Activity.RESULT_OK)
                finish()
            } else {
                setResult(Activity.RESULT_CANCELED)
                finish()
            }
        }
    }
}