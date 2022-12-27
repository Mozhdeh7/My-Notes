package com.moj.mynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var noteList = ArrayList<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteList.add(Note(1, "نوبت دندان پزشکی", "ساعت ۹:۴۵ نویت دندان پزشکی با دکتر نادری"))
        noteList.add(Note(2, "نوبت چشم پزشکی", "ساعت ۹:۴۵ نوبت چشم پزشکی با دکتر نجفی"))
        noteList.add(Note(3, "مطالعه اندروید", "مطالعه فصول ۱ و ۲"))
        noteList.add(Note(4, "بازی", "بازی سیمز"))
        noteList.add(Note(5, "تنیس", "خرید راکت تنیس"))
        noteList.add(Note(6, "پادکست زبان شناس", "گوش دادن پادکست علی بندری"))
        noteList.add(Note(7, "مشاهده فیلم های آموزشی", "مشاهده فایل های بوکمارک شده"))

        var notesListView = findViewById<ListView>(R.id.notesListView)

        var noteAdapter = NoteAdapter(noteList)
        notesListView.adapter = noteAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.item_new -> {
                var intent = Intent(this, AddNoteActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    inner class NoteAdapter : BaseAdapter {
        var notesListAdapter = ArrayList<Note>()

        constructor(notesListAdapter: ArrayList<Note>) : super() {
            this.notesListAdapter = notesListAdapter
        }

        override fun getCount(): Int {

            return notesListAdapter.count()
        }

        override fun getItem(p0: Int): Any {

            return notesListAdapter[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            var view = layoutInflater.inflate(R.layout.note_item, null)
            //var note = notesListAdapter[p0]

            var title = view.findViewById<TextView>(R.id.textViewTitle)
            var desc = view.findViewById<TextView>(R.id.textViewDesc)

            title.text = notesListAdapter[p0].Title
            desc.text = notesListAdapter[p0].Desc

            return view

        }

    }
}