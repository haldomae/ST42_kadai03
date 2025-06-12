package com.classnumber_00_domaekazuki.st42_kadai03

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var num by mutableStateOf("")
    var result = "計算結果"
    fun calc(){
        result = "ここに結果がでますよ"
    }
}