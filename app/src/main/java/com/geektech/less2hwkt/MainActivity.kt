package com.geektech.less2hwkt

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.geektech.less2hwkt.databinding.ActivityMainBinding
import com.geektech.less2hwkt.extensions.setImage
import com.geektech.less2hwkt.extensions.toast

class MainActivity : AppCompatActivity() {

    private lateinit var ui: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        val images = mutableListOf(
            "https://showgamer.com/wp-content/uploads/2020/09/a09680a4-7f90-4516-b00d-d0707891b17e.jpg",
            "https://images.squarespace-cdn.com/content/v1/5db01a61fb9da11b04b0cd1e/1572343459015-U99I0Y" +
                    "GE6DSD25RMFQZ3/ke17ZwdGBToddI8pDm48kAjZjFK1WvFf-Z5BVWO0fKAUqsxRUqqbr1mOJYKfIPR7LoDQ9m" +
                    "XPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYxCRW4BPu10St3TBAUQYVKcJsZXr-_pCQ5C1bo70sbf0Inf-tdqBv" +
                    "_TE9wmKsQcq69UHPc7QpmrXE9bnVIZAGNp/Hello+Europe+Logo_Colour_Square.png",
            "https://i.ytimg.com/vi/YQHsXMglC9A/maxresdefault.jpg",
            "https://d3avoj45mekucs.cloudfront.net/rojakdaily/media/jessica-chua/entertainment/2018/oct/" +
                    "he110%20channel%20introduction/hello_main.jpg?ext=.jpg",
            "https://learnenglishkids.britishcouncil.org/sites/kids/files/image/songs-hello-hello-hello.png"
        )

        ui.buttonRandom.setOnClickListener {
            val randomImage = (images).shuffled().first()
            ui.imageView.setImage(randomImage)
        }

        ui.buttonAdd.setOnClickListener {
            if (ui.editText.text.toString().trim().isNotEmpty()) {
                images.add(ui.editText.text.toString().trim())
                if (ui.editText.text.toString().trim() in images) {
                    ui.editText.setText("")
                    hideKeyBoard()
                    toast(getString(R.string.added))
                }
            }
        }
    }

    private fun hideKeyBoard() {
        val inputManager: InputMethodManager =
            getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            currentFocus?.windowToken,
            InputMethodManager.SHOW_FORCED
        )
    }
}