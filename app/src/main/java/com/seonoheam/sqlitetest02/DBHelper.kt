package com.seonoheam.sqlitetest02

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by seonoheam on 2017. 11. 16..
 */
class DBHelper:SQLiteOpenHelper {

    constructor(context: Context,name:String,version:Int,factory: SQLiteDatabase.CursorFactory?) :
            super(context, name, factory, version)

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE SEONOH (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER, phoneNum TEXT);")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insert(name: String, age: Int, phoneNum: String) {
        // DB에 입력한 값으로 행 추가
        writableDatabase.execSQL("INSERT INTO SEONOH VALUES(null, '"+name+"', "+age+",'"+phoneNum+"');")

        writableDatabase.close()
    }

    fun update(name: String, age: Int,phoneNum: String) {
        //  입력한 이름과 동일한 항목의 phoneNum을 수정
        writableDatabase.execSQL("UPDATE SEONOH SET phoneNum='"+phoneNum+"' WHERE name='"+name+"';")
        writableDatabase.close()
    }

    fun delete(name: String) {
        // 입력한 이름의 데이터 삭제
        writableDatabase.execSQL("DELETE FROM SEONOH WHERE name='"+name+"';")
        writableDatabase.close()
    }

    fun getResult(): String {
        // 읽기가 가능하게 DB 열기
        var result = ""

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        val cursor = readableDatabase.rawQuery("SELECT * FROM SEONOH", null)
        while (cursor.moveToNext()) {
            result += (cursor.getString(0)
                    + " : "
                    + cursor.getString(1)
                    + " 님 "
                    + cursor.getInt(2)
                    + " 세  "
                    + cursor.getString(3))+"\n"

        }

        return result
    }
}

