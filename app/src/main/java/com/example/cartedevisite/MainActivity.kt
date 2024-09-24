package com.example.cartedevisite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartedevisite.ui.theme.CarteDeVisiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarteDeVisiteTheme {
                Surface ( modifier = Modifier.fillMaxSize(), color = Color.LightGray) {
                    VisiteCard(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun VisiteCard(modifier: Modifier = Modifier) {
    Column (Modifier.fillMaxSize().background(Color.LightGray), horizontalAlignment = Alignment.CenterHorizontally  ) {
        ProfileContainer(modifier = Modifier.fillMaxWidth().weight(1f))
        ContactContainer(modifier = Modifier.padding(top = 50.dp).fillMaxWidth().weight(1f))
    }
}

@Composable
fun ProfileContainer(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.profile)

    Column (modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom) {
        Box (modifier = Modifier.size(150.dp).aspectRatio(1f)) {
            Image (
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize().clip(CircleShape)
            )
        }
        Text (
            text = stringResource(R.string.name),
            modifier = Modifier.padding(top = 30.dp, bottom = 5.dp),
            fontSize = 30.sp,
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold
        )
        Text (
            text = stringResource(R.string.share),
            fontSize = 18.sp,
            color = Color.DarkGray
        )
    }
}

@Composable
fun ContactContainer(modifier: Modifier = Modifier) {
    val mail = painterResource(R.drawable.mail)
    val phone = painterResource(R.drawable.phone)
    val share = painterResource(R.drawable.share)
    val linkedin = painterResource(R.drawable.linkedin)
    val github = painterResource(R.drawable.github)

    Column (modifier = modifier.wrapContentWidth(), verticalArrangement = Arrangement.spacedBy(15.dp)) {
        ContactContainerItem(
            image = mail,
            text = stringResource(R.string.email)
        )
        ContactContainerItem(
            image = phone,
            text = stringResource(R.string.phone)
        )
        ContactContainerItem(
            image = linkedin,
            text = stringResource(R.string.linkedin)
        )
        ContactContainerItem(
            image = github,
            text = stringResource(R.string.github)
        )
        ContactContainerItem(
            image = share,
            text = stringResource(R.string.share)
        )
    }
}

@Composable
fun ContactContainerItem ( image: Painter, text: String, modifier: Modifier = Modifier) {
    Row ( horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        Icon (
            painter = image,
            contentDescription = null,
            tint = Color.DarkGray,
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = text,
            color = Color.DarkGray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CarteDeVisiteTheme {
        VisiteCard(modifier = Modifier)
    }
}