package com.example.jetbizcard

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(corner = CornerSize(15.dp))
        ) {
            Column(
                modifier = Modifier
                    .height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateImageProfile()
                Divider()
                CreateInfo()
                Button(
                    onClick = {
                        Log.d("Button", "CreateBizCard: Clicked")
                    },

                ) {
                    Text(
                        text = "Portfolio",
                        style = MaterialTheme.typography.button
                    )
                }
            }
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Text(
            text = "Plank",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.primaryVariant,
            style = MaterialTheme.typography.h4
        )
        Text(
            text = "Android Compose Programmer",
            modifier = Modifier
                .padding(3.dp)
        )
        Text(
            text = "@Sean_Monaghan_",
            modifier = Modifier
                .padding(3.dp),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Preview
@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(
                corner = CornerSize(6.dp)
            ),
            border = BorderStroke(
                width = 2.dp,
                color = Color.LightGray
            )
        ) {
            Portfolio(data = listOf("Project1 1", "Project 2", "Project 3"))
        }
    }

}

@Composable
fun Portfolio(data: List<String>) {




}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(
            0.5.dp,
            Color.LightGray
        ),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.plank),
            contentDescription = "Profile Image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}


//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}