package com.example.demodatingapp.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.example.demodatingapp.databinding.ViewPersonDetailsIntroductionBinding

class PersonDetailIntroductionView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    val binding = ViewPersonDetailsIntroductionBinding.inflate(LayoutInflater.from(context), this, true)

    /*private val mTitleEditText: TextView
    private val mBodyEditText: EditText

    init {
        LayoutInflater.from(context).inflate(R.layout.view_person_details_introduction, this, true)
        mTitleEditText = findViewById(R.id.introduction_title)
        mBodyEditText = findViewById(R.id.introduction_body)
    }

    fun bind(model:PersonModel) {
        mBodyEditText.setText(model.introduction)
    }*/
}