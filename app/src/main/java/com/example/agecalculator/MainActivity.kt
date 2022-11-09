package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button= findViewById<Button>(R.id.button1)
        button.setOnClickListener(){view->
            printAge(view)
        }
    }

    private fun printAge(view: View){
        var myCalender=Calendar.getInstance()
        var year=myCalender.get(Calendar.YEAR)
        var month=myCalender.get(Calendar.MONTH)
        var day=myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            {view,year,month,day ->
                val selectDate="$day/${month+1}/$year"

                var textView1=findViewById<TextView>(R.id.textview1)
                   textView1.text=selectDate



                var dob=Calendar.getInstance()
                dob.set(year,month,day)

                var age= myCalender.get(Calendar.YEAR) - dob.get(Calendar.YEAR)

                 if(myCalender.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
                     {
                     age--
                     }
                var textView2 = findViewById<TextView>(R.id.textview2)
                textView2.text="You are $age year old."

            }
            ,year,month,day).show()

    }
}