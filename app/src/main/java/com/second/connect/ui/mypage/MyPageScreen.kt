package com.second.connect.ui.mypage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.second.connect.ConnectTopBar
import com.second.connect.R
import com.second.connect.ui.ConnectConfirmDialog
import com.second.connect.ui.theme.Black
import com.second.connect.ui.theme.ConnectBackground
import com.second.connect.ui.theme.Gray200
import com.second.connect.ui.theme.Gray600
import com.second.connect.ui.theme.Pretendard
import com.second.connect.ui.theme.Red
import com.second.connect.ui.theme.White

@Composable
fun MyPageScreen(
    modifier: Modifier = Modifier,
    onInquiryClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ConnectBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConnectTopBar(
            title = "마이페이지"
        )
        MyPageProfile(
            userName = "홍서은",
            instagramId = "hong__seoeun",
            profileUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA5MjZfMjIz%2FMDAxNjY0MTgyNDMwNTM0.T1LNiPmVZeeMteTviIhiU1HCIklwIEca7hiQtFnzYb0g.W8OHprkV2EWsb66j_mCptfGFHbMq0LQ2o6OryBHVCEcg.JPEG.s2_bijou%2FScreenshot%25A3%25DF20220926%25A3%25DF175058.jpg&type=sc960_832"
        )
        MyPageOption(
            onInquiryClick = onInquiryClick
        )
        Withdrawal()
    }
}

@Composable
fun MyPageProfile(
    modifier: Modifier = Modifier,
    userName: String,
    instagramId: String,
    profileUrl: String
) {
    Row(
        modifier = modifier
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 20.dp
            )
            .fillMaxWidth()
            .background(White)
            .border(
                width = 1.dp,
                color = Gray200,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(
                start = 24.dp,
                end = 24.dp,
                top = 20.dp,
                bottom = 20.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = profileUrl,
            contentDescription = "Profile",
            modifier = modifier
                .size(86.dp)
                .clip(shape = CircleShape)
        )
        Column(
            modifier = modifier
                .padding(
                    start = 24.dp
                )
        ) {
            Text(
                text = userName,
                style = TextStyle(
                    color = Black,
                    fontFamily = Pretendard,
                    fontWeight = FontWeight.Bold,
                    fontSize = 21.sp
                )
            )
            Row(
                modifier = modifier
                    .padding(top = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.instagram),
                    contentDescription = "instagram",
                    modifier = modifier.size(16.dp)
                )
                Text(
                    text = instagramId,
                    style = TextStyle(
                        color = Gray600,
                        fontFamily = Pretendard,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    ),
                    modifier = modifier
                        .padding(start = 6.dp)
                )
            }
        }
    }
}

@Composable
fun MyPageOptionText(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Text(
        text = text,
        style = TextStyle(
            color = Black,
            fontFamily = Pretendard,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        ),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(White)
            .padding(
                start = 24.dp,
                end = 24.dp,
                top = 16.dp,
                bottom = 16.dp
            )
            .clickable {
                onClick()
            }
    )
}

@Composable
fun MyPageOption(
    modifier: Modifier = Modifier,
    onInquiryClick: () -> Unit
) {
    var showLogoutDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 30.dp
            )
            .fillMaxWidth()
            .wrapContentHeight()
            .background(White)
            .border(
                width = 1.dp,
                color = Gray200,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        MyPageOptionText(
            text = "문의하기",
            onClick = {
                onInquiryClick()
            }
        )
        HorizontalDivider(
            modifier = modifier
                .fillMaxWidth()
                .padding(0.dp),
            color = Gray200
        )
        MyPageOptionText(
            text = "로그아웃",
            onClick = {
                showLogoutDialog = true
            }
        )
    }
    if (showLogoutDialog) {
        ConnectConfirmDialog(
            title = "로그아웃하시겠습니까?",
            onClickConfirm = {
                // 로그아웃
                showLogoutDialog = false
            },
            onClickCancel = {
                showLogoutDialog = false
            }
        )
    }
}

@Composable
fun Withdrawal(
    modifier: Modifier = Modifier
) {
    var showWithdrawal by remember { mutableStateOf(false) }

    Text(
        text = "회원 탈퇴",
        style = TextStyle(
            color = Red,
            fontFamily = Pretendard,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        ),
        modifier = modifier
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 16.dp
            )
            .fillMaxWidth()
            .background(White)
            .border(
                width = 1.dp,
                color = Gray200,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(
                start = 24.dp,
                end = 24.dp,
                top = 16.dp,
                bottom = 16.dp
            )
            .clickable {
                showWithdrawal = true
            }
    )

    if (showWithdrawal) {
        ConnectConfirmDialog(
            title = "정말 탈퇴하시겠습니까?",
            onClickConfirm = {
                // 회원 탈퇴
                showWithdrawal = false
            },
            onClickCancel = {
                showWithdrawal = false
            },
            isContent = true,
            content = "탈퇴 후 되돌릴 수 없습니다"
        )
    }
}