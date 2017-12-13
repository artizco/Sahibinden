package com.yasince.sahibinden

open class BaseTest {

    fun sleepShort() {
        sleep(1000)
    }

    fun sleepLong() {
        sleep(4000)
    }


    fun sleep(sec: Long) {
        try {
            Thread.sleep(sec)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}