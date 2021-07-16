package com.example.moviesapp.view.movieslist

import android.content.res.ColorStateList
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.model.Movie

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val movieImage: ImageView = itemView.findViewById(R.id.movie_image)
    private val likeImage: ImageView = itemView.findViewById(R.id.movie_like_image)
    private val pgText: TextView = itemView.findViewById(R.id.pg_text)
    private val genreText: TextView = itemView.findViewById(R.id.film_genre_text)
    private val starsImages: List<ImageView> = listOf(
        itemView.findViewById(R.id.star1_image),
        itemView.findViewById(R.id.star2_image),
        itemView.findViewById(R.id.star3_image),
        itemView.findViewById(R.id.star4_image),
        itemView.findViewById(R.id.star5_image)
    )
    private val reviewsText: TextView = itemView.findViewById(R.id.movie_reviews_count_text)
    private val titleText: TextView = itemView.findViewById(R.id.film_name_text)
    private val movieLenText: TextView = itemView.findViewById(R.id.film_time_text)

    fun bind(item: Movie, onClickCard: (item: Movie) -> Unit) {
        val context = itemView.context
        Glide.with(context).load(item.imageUrl).into(movieImage)

        pgText.text =
            context.getString(R.string.movies_list_allowed_age_template, item.pgAge)
        genreText.text = item.genres.joinToString { it.name }
        reviewsText.text =
            context.getString(R.string.movies_list_reviews_template, item.reviewCount)
        titleText.text = item.title
        movieLenText.text = context.getString(R.string.movies_list_film_time, item.runningTime)

        val likeColor = if (item.isLiked) {
            R.color.pink_light
        } else {
            R.color.color_white
        }
        ImageViewCompat.setImageTintList(
            likeImage, ColorStateList.valueOf(
                ContextCompat.getColor(likeImage.context, likeColor)
            )
        )

        //set stars tint
        starsImages.forEachIndexed { index, imageView ->
            val colorId = if (item.rating > index) R.color.pink_light else R.color.gray_dark
            ImageViewCompat.setImageTintList(
                imageView, ColorStateList.valueOf(
                    ContextCompat.getColor(imageView.context, colorId)
                )
            )
        }

        itemView.setOnClickListener {
            onClickCard(item)
        }
    }
}