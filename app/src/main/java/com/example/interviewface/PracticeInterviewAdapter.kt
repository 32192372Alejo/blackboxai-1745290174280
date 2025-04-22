package com.example.interviewface

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.interviewface.databinding.ItemPracticeInterviewBinding

class PracticeInterviewAdapter(
    private val items: List<PracticeInterview>
) : RecyclerView.Adapter<PracticeInterviewAdapter.PracticeInterviewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PracticeInterviewViewHolder {
        val binding = ItemPracticeInterviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PracticeInterviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PracticeInterviewViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class PracticeInterviewViewHolder(private val binding: ItemPracticeInterviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PracticeInterview) {
            binding.tvPracticeTitle.text = item.title
            binding.tvPracticeDescription.text = item.description
            Glide.with(binding.ivPracticeImage.context)
                .load(item.imageUrl)
                .centerCrop()
                .into(binding.ivPracticeImage)
        }
    }
}
