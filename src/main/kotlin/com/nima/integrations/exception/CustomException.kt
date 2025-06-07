package com.nima.integrations.exception

class CustomException(private val msg: String): Exception() {
    override val message: String
        get() = msg
}