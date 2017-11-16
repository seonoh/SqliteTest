package com.seonoheam.sqlitetest02

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val mDBHelper:DBHelper = DBHelper(this,"seonoh.db",1,null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        insert.setOnClickListener {
            val name = name_et.text.toString()
            val age = Integer.parseInt(age_et.text.toString())
            val phoneNum = phoneNum_et.text.toString()
            mDBHelper.insert(name,age,phoneNum)
            result.setText(mDBHelper.getResult())
        }

        delete.setOnClickListener {
            mDBHelper.delete(name_et.text.toString())
            result.setText(mDBHelper.getResult())

        }

        update.setOnClickListener {
            mDBHelper.update(name_et.text.toString(),Integer.parseInt(age_et.text.toString()),phoneNum_et.text.toString())
            result.setText(mDBHelper.getResult())

        }

        search.setOnClickListener {
            result.setText(mDBHelper.getResult())
            result.setText(mDBHelper.getResult())

        }
    }
}
