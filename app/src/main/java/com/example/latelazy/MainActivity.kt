package com.example.latelazy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var company = Company()
        company.process()

        var testLateinit = TestLateinit()
        testLateinit.process()

    }
}

class TestLateinit {
    // 초기화가 발생하지 않으면 종료가 될 수 있음으로 초기화되지 않으면 초기화하는 것이 좋음.
    lateinit var name: String
    init {
        name = "Kotlin"
    }
    fun process() {
        name.plus("Hello")
        Log.d("TestLateinit process", "이름의 길이 = ${name.length}")
        Log.d("TestLateinit process", "이름의 첫글자 = ${name.substring(0,1)}")
    }
}

class Company {
    // 최초 호출되는 시점에서 초기화가 되기 때문에 리소스가 너무 크면 속도가 느려짐.
    val testLateinit: TestLateinit by lazy{ TestLateinit() }
    init {

    }
    fun process() {
        Log.d("Company","testLateinit의 이름은 ${testLateinit.name}")
    }
}