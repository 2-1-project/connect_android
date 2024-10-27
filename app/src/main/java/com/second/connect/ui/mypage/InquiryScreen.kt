package com.second.connect.ui.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.second.connect.ConnectTopBar
import com.second.connect.ui.theme.ConnectBackground
import com.second.connect.ui.theme.Gray300
import com.second.connect.ui.theme.Gray400
import com.second.connect.ui.theme.Gray600
import com.second.connect.ui.theme.Main
import com.second.connect.ui.theme.Main1
import com.second.connect.ui.theme.Pretendard
import com.second.connect.ui.theme.White


const val NAVIGATION_INQUIRY = "inquiry"

@Composable
fun InquiryScreen(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var buttonEnabled by remember { mutableStateOf(false) }

    if (title.isNotEmpty() && content.isNotEmpty()) {
        buttonEnabled = true
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ConnectBackground)
    ) {
        ConnectTopBar(title = "문의하기")
        InquiryInput(
            input = title,
            hint = "제목",
            singleLine = true,
            onValueChange = { newTitle ->
                title = newTitle
            },
            modifier = modifier.padding(top = 30.dp)
        )
        InquiryInput(
            input = content,
            hint = "문의하실 내용을 입력해주세요",
            singleLine = false,
            onValueChange = { newContent ->
                content = newContent
            },
            modifier = modifier
                .padding(top = 16.dp)
                .heightIn(
                    min = 160.dp
                )
        )
        SubmitButton(
            buttonEnabled = buttonEnabled,
            onClick = onButtonClick
        )
    }
}

@Composable
fun InquiryInput(
    modifier: Modifier = Modifier,
    input: String,
    hint: String,
    singleLine: Boolean,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = input,
        onValueChange = onValueChange,
        modifier = modifier
            .padding(
                start = 20.dp,
                end = 20.dp
            )
            .fillMaxWidth(),
        placeholder = {
            Text(
                text = hint,
                style = TextStyle(
                    color = Gray600,
                    fontFamily = Pretendard,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            )
        },
        singleLine = singleLine,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = White,
            focusedContainerColor = White,
            unfocusedBorderColor = Gray400,
            focusedBorderColor = Main1,
            cursorColor = Main1
        ),
        shape = RoundedCornerShape(8.dp)
    )
}

@Composable
fun SubmitButton(
    modifier: Modifier = Modifier,
    buttonEnabled: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        enabled = buttonEnabled,
        modifier = modifier
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 40.dp
            )
            .fillMaxWidth()
            .height(48.dp)
            .background(
                brush = Main,
                shape = RoundedCornerShape(8.dp)
            ),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            disabledContentColor = Gray300,
            containerColor = Color.Transparent
        )
    ) {
        Text(
            text = "전달하기",
            style = TextStyle(
                color = White,
                fontFamily = Pretendard,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
        )
    }
}