package com.example.demodatingapp.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.example.demodatingapp.databinding.ViewPersonDetailsHeaderBinding
import com.example.demodatingapp.util.ImageLoader

class PersonDetailHeaderView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    val binding: ViewPersonDetailsHeaderBinding

    init {
        val layoutInflater = LayoutInflater.from(context)
        binding = ViewPersonDetailsHeaderBinding.inflate(layoutInflater, this, true)
    }

  /*  companion object {
        @BindingAdapter("starCount")
        @JvmStatic
        fun TextView.starEmoji(count: Int) {
            val startEmojiHex = 0x2B50
            val startEmojiString = String(Character.toChars(startEmojiHex))
            text = startEmojiString.repeat(count)
        }

        @BindingAdapter("roundedResource")
        @JvmStatic
        fun ImageView.setRoundedResource(imageName: String?) {
         /*   val resources = context.resources
            val bitmap = BitmapFactory.decodeResource(resources, resId)
            val drawable = RoundedBitmapDrawableFactory.create(resources, bitmap)
            drawable.isCircular = true
            setImageDrawable(drawable)*/
            //Picasso.get().load(resName).transform(CircleTransform()).into(this)
            imageName?.let {
                ImageLoader.loadCircular(it, this)
            }
        }
    }*/


  /*  companion object {
        @JvmStatic val STAR_EMOJI_HEX = 0x2B50
        val STAR_EMOJI_STRING = String(Character.toChars(STAR_EMOJI_HEX))
    }

    private val mAvatarImageView: ImageView
    private val mPersonName: TextView
    private val mPersonJob: TextView
    private val mPersonRating: TextView
    private val mPersonAge: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_person_details_header, this, true)
        mAvatarImageView = findViewById(R.id.person_avatar)
        mPersonName = findViewById(R.id.person_visible_name)
        mPersonJob = findViewById(R.id.person_job)
        mPersonRating = findViewById(R.id.person_rating)
        mPersonAge = findViewById(R.id.person_age)
    }

    fun bind(model: PersonModel) {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.kristof)
        val drawable = RoundedBitmapDrawableFactory.create(resources,bitmap)
        drawable.isCircular = true
        mAvatarImageView.setImageDrawable(drawable)
        mPersonName.text = model.name
        mPersonJob.text = model.job
        mPersonRating.text = STAR_EMOJI_STRING.repeat(model.rating)
        mPersonAge.text = model.formattedAge
    }*/
}