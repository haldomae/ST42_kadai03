package com.classnumber_00_domaekazuki.st42_kadai03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.classnumber_00_domaekazuki.st42_kadai03.ui.theme.ST42_kadai03Theme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ST42_kadai03Theme {
                MainContent(viewModel = viewModel)
            }
        }
    }
}
@Composable
private fun MainContent(viewModel: MainViewModel){
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(20.dp)
    ) {
        // アプリ名
        Text(
            text = "BMI計算機",
            fontSize = 26.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(20.dp))
        // 身長入力エリア
        PinkLabelTextField(
            value = viewModel.height,
            onValueChange = {
                viewModel.height = it
            },
            label = "身長(cm)",
            placeholder = "170"
        )
        Spacer(modifier = Modifier.height(20.dp))
        // 体重入力エリア
        PinkLabelTextField(
            value = viewModel.weight,
            onValueChange = {
                viewModel.weight = it
            },
            label = "体重(kg)",
            placeholder = "60"
        )
        Spacer(modifier = Modifier.height(30.dp))
        // 計算するボタン
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF85F6F)
            )
        ) {
            Text(
                text = "計算する",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        // 結果表示テキスト
        Text(
            text = "あなたのBMIは00.0です",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Composable
private fun PinkLabelTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String
){
    Column {
        Text(
            text = label,
            color = Color(0xFFF85F6F),
            fontWeight = FontWeight.Bold
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(text = placeholder) },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent, // フォーカスされていない時の背景色
                focusedContainerColor = Color.Transparent    // フォーカスされている時の背景色
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number),
            singleLine = true

        )
    }
}
