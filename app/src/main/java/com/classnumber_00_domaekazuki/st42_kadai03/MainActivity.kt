package com.classnumber_00_domaekazuki.st42_kadai03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.classnumber_00_domaekazuki.st42_kadai03.ui.theme.ST42_kadai03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ST42_kadai03Theme {
                MainContent()
            }
        }
    }
}
@Composable
private fun MainContent(){
    Column(
        modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.Start
    ) {
        // アプリタイトル
        Text(
            text = "計算機",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
        // 入力欄
        TextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "170cm")
            },
            // テキストに表示されている文字列
            value = "",
            // 内容が変わった時に実行される
            onValueChange = {},
            // 入力欄の色を変更
            colors = TextFieldDefaults.colors(
                // フォーカスされいない時の色
                unfocusedContainerColor = Color.Transparent,
                // フォーカスされている時の色
                focusedContainerColor = Color.Transparent
            )
        )
    }
}