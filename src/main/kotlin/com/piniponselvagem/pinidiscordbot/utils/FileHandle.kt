package com.piniponselvagem.pinidiscordbot.utils

import java.io.IOException
import java.io.FileWriter
import java.io.BufferedWriter
import java.io.File

private const val filesDir = "bot_files"

fun writeTo(dir: String, fileName: String, content: String) {
    val writer: BufferedWriter
    try {
        val file = File("$filesDir\\$dir")
        file.mkdirs()
        val fileFullPath = file.path + "\\" + fileName + ".txt"
        writer = BufferedWriter(FileWriter(fileFullPath))
        writer.write(content)
        writer.close()
        println("Output saved to: ..\\$fileFullPath")
    } catch (e: IOException) {
        //TODO: //log.error(e.message)
    }
}