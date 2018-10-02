package com.piniponselvagem.pinidiscordbot.utils

import java.io.*

private const val filesDir = "bot_files"

fun writeTo(dir: String, fileName: String, content: String) : Boolean {
    val writer: BufferedWriter
    try {
        val file = File("$filesDir\\$dir")
        file.mkdirs()
        val fileFullPath = file.path + "\\" + fileName
        writer = BufferedWriter(FileWriter(fileFullPath))
        writer.write(content)
        writer.close()
        println("Output saved to: ..\\$fileFullPath")
        return true
    } catch (e: IOException) {
        //TODO: //log.error(e.message)
    }
    return false
}

fun readFrom(dir: String, fileName: String) : Boolean {
    val reader: BufferedReader
    try {
        val file = File("$filesDir\\$dir")
        val fileFullPath = file.path + "\\" + fileName
        reader = BufferedReader(FileReader(fileFullPath))
        var txt = reader.readLine()
        while(txt != null) {
            println(txt)
            txt = reader.readLine()
        }
        reader.close()
        return true
    } catch (e: IOException) {
        //TODO: //log.error(e.message)
    }
    return false
}