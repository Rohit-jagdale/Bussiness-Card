package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SelfImage(getString(R.string.Name) , getString(R.string.work))
                    ContactDetails(getString(R.string.phone_no),
                        getString(R.string.email), getString(R.string.website_link))
                }
            }
        }
    }
}

@Composable
fun Intro(name: String, title: String, modifier: Modifier = Modifier){
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = name,
            fontSize = 40.sp,
            textAlign = TextAlign.Justify,
            color = Color(0xFF55312e),
            modifier = modifier.padding(2.dp)
        )
        Text(
            text = title,
            textAlign = TextAlign.Justify,
            color = Color(0xFF007a00),
            modifier = modifier.padding(4.dp)

        )
    }
}


@Composable
fun SelfImage(name: String, title: String, modifier: Modifier = Modifier){
    val image= painterResource(R.drawable.img_20231214_140538)
    val imagebk= painterResource(R.drawable.android)
    Image(painter = imagebk ,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        alpha = 0.5f
    )
    Box (contentAlignment = Alignment.Center,
        modifier = Modifier.padding(bottom =175.dp)){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = image,
                contentDescription = null,
                Modifier
                    .height(150.dp)
                    .width(150.dp)
            )
            Intro(
                name = name,
                title = title
            )
        }
    }
}

@Composable
fun ContactDetails(contact: String, mail: String, link: String, modifier: Modifier=Modifier){
   val phoneicon= painterResource(R.drawable.baseline_phone_black_24dp)
    val mailicon= painterResource(R.drawable.baseline_email_black_24dp)
    val linkicon= painterResource(R.drawable.baseline_share_black_24dp)
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier =  modifier.padding(24.dp)
    ){
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(8.dp)
        ){
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                ){
                Image(painter = phoneicon,
                    contentDescription = null,
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp)
                    )
                Text(text = contact,
                    color = Color(0xFF6b6c6a),
                    modifier = Modifier.padding(8.dp)
                    )
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(painter = mailicon,
                    contentDescription = null,
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp)
                )
                Text(text = mail,
                    color = Color(0xFF6b6c6a),
                    modifier = Modifier.padding(8.dp)
                     )
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(painter = linkicon,
                    contentDescription = null,
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp)
                )
                Text(text = link,
                    color = Color(0xFF6b6c6a),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SelfImage(
        stringResource(R.string.Name),
        stringResource(R.string.work)
    )
    ContactDetails(
        stringResource(id = R.string.phone_no),
        stringResource(id = R.string.email),
        stringResource(id = R.string.website_link)
    )
    BusinessCardTheme {
    }
}