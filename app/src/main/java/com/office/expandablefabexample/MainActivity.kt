package com.office.expandablefabexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val rotateOpen: Animation by lazy {
        AnimationUtils.loadAnimation(
            this,
            R.anim.rotate_open_anim
        )
    }
    private val rotateClose: Animation by lazy {
        AnimationUtils.loadAnimation(
            this, R.anim
                .rotate_close_anim
        )
    }
    private val fromBottom: Animation by lazy {
        AnimationUtils.loadAnimation(
            this, R.anim
                .from_bottom_anim
        )
    }
    private val toBottom: Animation by lazy {
        AnimationUtils.loadAnimation(
            this, R.anim
                .to_bottom_anim
        )
    }

    private var clicked = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_btn.setOnClickListener {
            onAddButtonClicked()
        }

        edit_btn.setOnClickListener {
            Toast.makeText(this, "Edit Button Clicked", Toast.LENGTH_SHORT).show()
        }

        image_btn.setOnClickListener {
            Toast.makeText(this, "Image Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked: Boolean) {
        if(!clicked) {
            edit_btn.visibility = View.VISIBLE
            edit_tv.visibility = View.VISIBLE
            image_btn.visibility = View.VISIBLE
            image_tv.visibility = View.VISIBLE
        } else {
            edit_btn.visibility = View.INVISIBLE
            edit_tv.visibility = View.INVISIBLE
            image_btn.visibility = View.INVISIBLE
            image_tv.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if(!clicked) {
            edit_btn.startAnimation(fromBottom)
            edit_tv.startAnimation(fromBottom)
            image_btn.startAnimation(fromBottom)
            image_tv.startAnimation(fromBottom)
            add_btn.startAnimation(rotateOpen)
        } else {
            edit_btn.startAnimation(toBottom)
            edit_tv.startAnimation(toBottom)
            image_btn.startAnimation(toBottom)
            image_tv.startAnimation(toBottom)
            add_btn.startAnimation(rotateClose)
        }
    }
}