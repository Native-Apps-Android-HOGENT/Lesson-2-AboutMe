package be.equality.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import be.equality.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Arthur Dent")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.nicknameBtn.setOnClickListener {
            addNickname()
        }
    }

    /**
     * Switches the contents from the [nickname_edit] to that of
     * [nickname_txtView].
     */
    private fun addNickname() {
        binding.apply {
            myName?.nickName = nickname_edit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            nicknameBtn.visibility = View.GONE
            nicknameTxtView.visibility = View.VISIBLE
        }

        //Hide the keyboard
        val imm = getSystemService(
            Context.INPUT_METHOD_SERVICE
        ) as InputMethodManager
        imm.hideSoftInputFromWindow(nickname_btn.windowToken, 0)
    }
}
