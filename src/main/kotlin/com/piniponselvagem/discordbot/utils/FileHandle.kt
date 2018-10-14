package com.piniponselvagem.discordbot.utils

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
        println(e)
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
        println(e)
        //TODO: //log.error(e.message)
    }
    return false
}

fun readConfig(fileName: String) : MutableList<String> {
    val reader: BufferedReader
    val list: MutableList<String> = mutableListOf()
    try {
        reader = BufferedReader(FileReader(fileName))
        list.add(0, reader.readLine())
        list.add(1, reader.readLine())
        reader.close()
    } catch (e: IOException) {
        println(e)
        //TODO: //log.error(e.message)
    }
    finally {
        return list
    }
}