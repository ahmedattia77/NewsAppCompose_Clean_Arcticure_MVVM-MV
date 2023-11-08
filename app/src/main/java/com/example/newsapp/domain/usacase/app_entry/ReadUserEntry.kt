package com.example.newsapp.domain.usacase.app_entry

import com.example.newsapp.domain.manger.LocalUserManger

class ReadUserEntry(
    private val localUserManger: LocalUserManger
) {
    operator fun invoke() = localUserManger.readAppEntry()
}