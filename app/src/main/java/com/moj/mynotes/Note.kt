package com.moj.mynotes

class Note {
    var ID: Int? = null
    var Title: String? = null
    var Desc: String? = null

    constructor(id: Int, title: String, desc: String) {
        this.ID = id
        this.Title = title
        this.Desc = desc
    }
}