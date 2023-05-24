package com.example.quizeapp

class ModelQuestion(ques:String, Opt1:String, Opt2:String, Opt3:String, Opt4:String, Ans:String, SelectedAns:String = "") {
    lateinit var mques:String
    lateinit var mOpt1:String
    lateinit var mOpt2:String
    lateinit var mOpt3:String
    lateinit var mOpt4:String
    lateinit var mAns:String
    lateinit var UserSelectedAns:String

    init {
        mques = ques
        mOpt1 = Opt1
        mOpt2 = Opt2
        mOpt3 = Opt3
        mOpt4 = Opt4
        mAns = Ans
        UserSelectedAns = SelectedAns
    }

}