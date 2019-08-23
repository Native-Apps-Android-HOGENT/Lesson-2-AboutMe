package be.equality.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import be.equality.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        binding.nicknameBtn.setOnClickListener {
            addNickname()
        }
    }

    /**
     * Switches the contents from the [nickname_edit] to that of
     * [nickname_txtview].
     */
    private fun addNickname(){

        //Change the contents from editText tot TextView
        nickname_txtview.text = nickname_edit.text
        nickname_edit.visibility  = View.GONE
        nickname_btn.visibility = View.GONE
        nickname_txtview.visibility = View.VISIBLE


        //Hide the keyboard
        val imm = getSystemService(
            Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(nickname_btn.windowToken, 0)
    }
}
