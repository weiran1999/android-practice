package com.thoughtworks.android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val buttonContainer: LinearLayout by lazy { findViewById(R.id.button_container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        generateButtons()
    }

    private fun generateButtons() {
        addButton(getString(R.string.constraint_layout)) {
            startActivity(Intent(this, ConstraintActivity::class.java))
        }
        addButton(getString(R.string.login)) {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        addButton(getString(R.string.button_3))
        addButton(getString(R.string.button_4))
        addButton(getString(R.string.button_5))
        addButton(getString(R.string.button_6))
        addButton(getString(R.string.button_7))
        addButton(getString(R.string.button_8))
        addButton(getString(R.string.button_9))
        addButton(getString(R.string.button_10))
    }

    private fun addButton(name: String, onClickListener: View.OnClickListener? = null) {
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(0, resources.getDimensionPixelSize(R.dimen.dimen_24), 0, 0)

        val button = Button(this)
        button.layoutParams = layoutParams
        button.text = name
        button.isAllCaps = false

        onClickListener?.let {
            button.setOnClickListener(it)
        }

        buttonContainer.addView(button)
    }
}