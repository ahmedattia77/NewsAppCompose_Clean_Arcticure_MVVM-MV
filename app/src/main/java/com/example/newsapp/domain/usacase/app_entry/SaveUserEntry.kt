package com.example.newsapp.domain.usacase.app_entry

import com.example.newsapp.domain.manger.LocalUserManger

class SaveUserEntry(
    private val localUserManger: LocalUserManger
) {
    suspend operator fun invoke (){
        localUserManger.saveAppEntry()
    }
}