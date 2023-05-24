package com.example.quizeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog


var questions = listOf<ModelQuestion>(
    ModelQuestion(
        "কোন বাক্যে ক্রিয়া পদ উহ্য রয়েছে?",
        "তিনি সাঁতার কাটছেন",
        "ইনি আমার ভাই",
        "কবির বই পড়ছে",
        "আমি লিখছি",
        "b",
    ),
    ModelQuestion(
        "ক্রিয়া সম্পাদনের যন্ত্র,উপকরণ বা সহায়ককে কি বলে?",
        "অপাদান কারক",
        "করণকারক",
        "কর্মকারক",
        "অধিকরন কারক",
        "b",
    ),
    ModelQuestion(
        "মিথ্যাবাদী রাখাল’ কাব্যটির রচয়িতা কে?",
        "সৈয়দ শামসুল হক",
        "মোহাম্মদ মনিরুজ্জামান",
        "আব্দুল মান্নান",
        "সৈয়দ আল মাহমুদ",
        "d",
    ),
    ModelQuestion(
        "বাঙ্গালা ভাষার ইতিবৃত্ত’ কে রচনা করেন?",
        "সুনীতিকুমার চট্টোপাধ্যায়",
        "সুকুমার সেন",
        "মুহম্মদ শহীদুল্লাহ্‌",
        "মুহম্মদ এনামুল হক",
        "c",
    ),
    ModelQuestion(
        "ভাষার ক্ষুদ্রতম একক কোন্টি?",
        "বর্ণ",
        "শব্দ",
        "অক্ষর",
        "ধ্বনি",
        "d",
    )
)

    lateinit var tvQuesNo: TextView

    lateinit var tvQues: TextView
    lateinit var rlOpt1:RelativeLayout
    lateinit var rlOpt2:RelativeLayout
    lateinit var rlOpt3:RelativeLayout
    lateinit var rlOpt4:RelativeLayout

    lateinit var tvOpt1: TextView
    lateinit var tvOpt2: TextView
    lateinit var tvOpt3: TextView
    lateinit var tvOpt4: TextView

    lateinit var ivOpt1 :ImageView
    lateinit var ivOpt2 :ImageView
    lateinit var ivOpt3 :ImageView
    lateinit var ivOpt4 :ImageView

    lateinit var btnNext: Button

    var index = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        tvQuesNo = findViewById(R.id.tv_ques_no_id)

        tvQues = findViewById(R.id.tv_question)
        rlOpt1 = findViewById(R.id.rl_id_op1)
        rlOpt2 = findViewById(R.id.rl_id_op2)
        rlOpt3 = findViewById(R.id.rl_id_op3)
        rlOpt4 = findViewById(R.id.rl_id_op4)

        tvOpt1 = findViewById(R.id.tv_ans_opt_1)
        tvOpt2 = findViewById(R.id.tv_ans_opt_2)
        tvOpt3 = findViewById(R.id.tv_ans_opt_3)
        tvOpt4 = findViewById(R.id.tv_ans_opt_4)

        ivOpt1 = findViewById(R.id.iv_opt1)
        ivOpt2 = findViewById(R.id.iv_opt2)
        ivOpt3 = findViewById(R.id.iv_opt3)
        ivOpt4 = findViewById(R.id.iv_opt4)

        btnNext = findViewById(R.id.btn_next_id)


        tvQues.text = questions[index].mques
        tvOpt1.text = questions[index].mOpt1
        tvOpt2.text = questions[index].mOpt2
        tvOpt3.text = questions[index].mOpt3
        tvOpt4.text = questions[index].mOpt4
        tvQuesNo.text = "${index+1}/${questions.size}"

        rlOpt1.setOnClickListener {
            ivOpt1.visibility = View.VISIBLE
            ivOpt2.visibility = View.INVISIBLE
            ivOpt3.visibility = View.INVISIBLE
            ivOpt4.visibility = View.INVISIBLE
            questions[index].UserSelectedAns = "a"
        }
        rlOpt2.setOnClickListener {
            ivOpt1.visibility = View.INVISIBLE
            ivOpt2.visibility = View.VISIBLE
            ivOpt3.visibility = View.INVISIBLE
            ivOpt4.visibility = View.INVISIBLE
            questions[index].UserSelectedAns = "b"
        }
        rlOpt3.setOnClickListener {
            ivOpt1.visibility = View.INVISIBLE
            ivOpt2.visibility = View.INVISIBLE
            ivOpt3.visibility = View.VISIBLE
            ivOpt4.visibility = View.INVISIBLE
            questions[index].UserSelectedAns = "c"
        }
        rlOpt4.setOnClickListener {
            ivOpt1.visibility = View.INVISIBLE
            ivOpt2.visibility = View.INVISIBLE
            ivOpt3.visibility = View.INVISIBLE
            ivOpt4.visibility = View.VISIBLE
            questions[index].UserSelectedAns = "d"
        }

        btnNext.setOnClickListener {
            if(index< questions.size-1) {
                index++
                ivOpt1.visibility = View.INVISIBLE
                ivOpt2.visibility = View.INVISIBLE
                ivOpt3.visibility = View.INVISIBLE
                ivOpt4.visibility = View.INVISIBLE
                tvQues.text = questions[index].mques
                tvOpt1.text = questions[index].mOpt1
                tvOpt2.text = questions[index].mOpt2
                tvOpt3.text = questions[index].mOpt3
                tvOpt4.text = questions[index].mOpt4
                tvQuesNo.text = "${index + 1}/${questions.size}"
                if(index == questions.size-1) btnNext.text = "Submit"
            }
            else{
                questions.forEach {
                    Log.d("ans", it.UserSelectedAns)
                }
            }
        }

    }
}