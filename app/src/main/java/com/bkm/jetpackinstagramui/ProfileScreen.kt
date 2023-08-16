package com.bkm.jetpackinstagramui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        TopBar()
        ProfileSection()
        ProfileDescription(
            name = "Programming Mentor",
            description = "10 years coding experience\n" +
                    "Want me to make your app? Send me an email!\n" +
                    "Android tutorials? Subscribe to my chanel!",
            url = "https://youtube.com/c/PhilippLackner"
        )
        ButtonSection(
            list =
            listOf(
                TextWithImage(
                    image = Icons.Default.KeyboardArrowDown,
                    text = "Following"
                ),
                TextWithImage(
                    image = null,
                    text = "Message"
                ),
                TextWithImage(
                    image = null,
                    text = "Email"
                ),
                TextWithImage(
                    image = Icons.Default.KeyboardArrowDown,
                    text = ""
                )
            )
        )

    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier.fillMaxWidth(),
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(horizontal = 15.dp)

    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
        )
        Text(
            text = "philipplackner_official",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
        )
        Image(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )

    }

}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.philipp),
            contentDescription = null,
            modifier = Modifier
                .size(90.dp)
                .aspectRatio(1f)
                .border(
                    width = 2.dp,
                    shape = CircleShape,
                    color = Color.Gray
                )
                .clip(CircleShape)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
        ) {
            Text(
                text = "601",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )
            Text(
                text = "Posts",
                fontSize = 20.sp,
                color = Color.Black
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
        ) {
            Text(
                text = "99.8k",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )
            Text(
                text = "Followers",
                fontSize = 20.sp,
                color = Color.Black
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
        ) {
            Text(
                text = "72",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )
            Text(
                text = "Following",
                fontSize = 20.sp,
                color = Color.Black
            )
        }
    }
}

@Composable
fun ProfileDescription(
    name: String,
    description: String,
    url: String,
    modifier: Modifier = Modifier
        .fillMaxWidth(),
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = name,
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = description,
            fontSize = 18.sp,
            color = Color.Black,
        )
        Text(
            text = url,
            fontSize = 18.sp,
            color = Color.Blue,
        )
        Text(
            text = buildAnnotatedString {
                val buildStyle = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                append("Followed by")
                pushStyle(buildStyle)
                append("codingflow, miakhalifa ")
                pop()
                append("and ")
                pushStyle(buildStyle)
                append("17 and others")

            }
        )
    }
}

@Composable
fun ButtonSection(
    list: List<TextWithImage>,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            list.forEachIndexed { index, textWithImage ->
                ActionButton(textWithImage = textWithImage)
            }
        }
    }
}

@Composable
fun ActionButton(
    textWithImage: TextWithImage,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .border(
                width = 2.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Text(
            text = textWithImage.text!!,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
        Icon(
            imageVector = textWithImage.image!!,
            contentDescription = null
        )
    }
}

@Composable
fun HighLightedSection(
    modifier: Modifier = Modifier
) {

}


@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}