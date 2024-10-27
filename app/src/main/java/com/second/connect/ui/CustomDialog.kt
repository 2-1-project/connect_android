package com.second.connect.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.second.connect.ui.theme.Black
import com.second.connect.ui.theme.DialogBlue
import com.second.connect.ui.theme.Gray400
import com.second.connect.ui.theme.Pretendard
import com.second.connect.ui.theme.Red
import com.second.connect.ui.theme.White

@Composable
fun ConnectConfirmDialog(
    modifier: Modifier = Modifier,
    title: String,
    onClickConfirm: () -> Unit,
    onClickCancel: () -> Unit,
    isContent: Boolean = false,
    content: String = ""
) {
    Dialog(
        onDismissRequest = onClickCancel,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        Card(
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = modifier
                    .width(300.dp)
                    .wrapContentHeight()
                    .background(color = White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        color = Black,
                        fontFamily = Pretendard,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    ),
                    modifier = modifier
                        .padding(
                            top = 40.dp
                        )
                )
                if (isContent) {
                    Text(
                        text = content,
                        style = TextStyle(
                            color = Red,
                            fontFamily = Pretendard,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp
                        ),
                        modifier = modifier
                            .padding(
                                top = 8.dp
                            )
                    )
                }
                Spacer(modifier = modifier.height(30.dp))
                HorizontalDivider(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    color = Gray400
                )
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                ) {
                    Button(
                        onClick = onClickCancel,
                        shape = RectangleShape,
                        modifier = modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        colors = ButtonDefaults.buttonColors(
                            disabledContainerColor = White,
                            containerColor = White,
                            disabledContentColor = Red,
                            contentColor = Red
                        )
                    ) {
                        Text(
                            text = "취소",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontFamily = Pretendard,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp
                            )
                        )
                    }
                    VerticalDivider(
                        modifier = modifier
                            .fillMaxHeight()
                            .padding(0.dp),
                        color = Gray400
                    )
                    Button(
                        onClick = onClickConfirm,
                        shape = RectangleShape,
                        modifier = modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        colors = ButtonDefaults.buttonColors(
                            disabledContainerColor = White,
                            containerColor = White,
                            disabledContentColor = DialogBlue,
                            contentColor = DialogBlue
                        )
                    ) {
                        Text(
                            text = "확인",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontFamily = Pretendard,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp
                            )
                        )
                    }
                }
            }
        }
    }
}