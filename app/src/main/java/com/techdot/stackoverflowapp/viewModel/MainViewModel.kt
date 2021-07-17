package com.techdot.stackoverflowapp.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.techdot.stackoverflowapp.adapter.QuestionsAdapter
import com.techdot.stackoverflowapp.databinding.ActivityMainBinding
import com.techdot.stackoverflowapp.model.Question
import com.techdot.stackoverflowapp.model.Questions
import com.techdot.stackoverflowapp.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class MainViewModel(binding: ActivityMainBinding): ViewModel() {

    private val questionsList = ArrayList<Question>()
    private val mainBinding = binding


    init {
        getQuestions()
    }

    private fun getQuestions() {
        val call: Call<Questions> =
            RetrofitInstance.api.getQuestions("desc", "activity", "stackoverflow")

        call.enqueue(object : Callback<Questions> {
            override fun onResponse(
                call: Call<Questions>,
                response: Response<Questions>
            ) {
                if (response.code() == 200) {
                    val questions: Questions? = response.body()

                    val allQuestion: List<Question>? = questions?.items

                    allQuestion!!.forEach { item ->
                        if (item.is_answered && item.answer_count > 1) {
                            questionsList.add(item)
                        }
                    }

                    mainBinding.questionsView.adapter = QuestionsAdapter(questionsList)

                    Log.v("ADDED_QUESTIONS", questionsList[0].title.toRegex().pattern)
                } else {

                    Log.e("ERROR_QUESTIONS", "${response.code()}: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Questions>, t: Throwable) {
                Log.e("Callback failure", t.message!!)
                t.printStackTrace()
            }
        })
    }
}