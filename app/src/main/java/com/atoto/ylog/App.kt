package com.atoto.ylog

import android.app.Application
import com.atoto.ylog.flattener.DefaultFlattener
import com.atoto.ylog.printer.AndroidPrinter
import com.atoto.ylog.printer.file.FilePrinter
import com.atoto.ylog.printer.file.backup.NeverBackupStrategy
import com.atoto.ylog.printer.file.clean.FileLastModifiedCleanStrategy
import com.atoto.ylog.printer.file.naming.DateFileNameGenerator
import com.atoto.ylog.printer.file.writer.SimpleWriter

/**
 * author:huitao
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val config = LogConfiguration.Builder().enableBorder().logLevel(LogLevel.ALL).build()
        val printer = FilePrinter
            .Builder(filesDir.absolutePath + "log")
            .fileNameGenerator(
                DateFileNameGenerator()
            ).backupStrategy(NeverBackupStrategy())
            .cleanStrategy(FileLastModifiedCleanStrategy(Long.MAX_VALUE))
            .flattener(DefaultFlattener()).writer(SimpleWriter()).build()
        XLog.init(config, AndroidPrinter(),printer)
    }
}