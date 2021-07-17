package com.techdot.stackoverflowapp.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.techdot.stackoverflowapp.databinding.QuestionLayoutBinding
import com.techdot.stackoverflowapp.model.Question
import okhttp3.internal.Version

class QuestionsAdapter(questionList: ArrayList<Question>): RecyclerView.Adapter<QuestionsAdapter.ViewHolder>() {

    private val questions = questionList
    private var index = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = QuestionLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)

        return ViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question: Question = questions[position]
        holder.bind(question)
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    inner class ViewHolder(private val binding: QuestionLayoutBinding):
        RecyclerView.ViewHolder(binding.root) {
            @SuppressLint("SetTextI18n")
            fun bind (question: Question) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    binding.question.text = "$index: " +
                            Html.fromHtml(question.title, Html.TO_HTML_PARAGRAPH_LINES_INDIVIDUAL)
                    index++
                } else {
                    binding.question.text = "$index: " +
                            Html.fromHtml(question.title)
                    index++
                }
            }

    }
}