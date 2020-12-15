package com.ninetwozero.bf5intel

import android.app.Application
import com.ninetwozero.bf5intel.repository.storage.BfVDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class BfVApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this
    }

    companion object {

        private var app :BfVApplication? = null

        private val applicationScope = CoroutineScope(SupervisorJob())

        fun getDatabase(): BfVDatabase =  BfVDatabase.getDatabase(app!!.applicationContext, applicationScope)
    }
}