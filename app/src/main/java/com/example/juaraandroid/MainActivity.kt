package com.example.juaraandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.juaraandroid.ui.theme.JuaraAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JuaraAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Article()
                }
            }
        }
    }
}

@Composable
fun Article() {
    val image = painterResource(R.drawable.bg_compose_background)
    Column {
        ContentImage(image)
        Title(stringResource(R.string.title))
        Content(
            stringResource(R.string.first_content),
            modifier = Modifier
                .padding(16.dp, 0.dp)
        )
        Content(
            stringResource(R.string.second_content),
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun ContentImage(image: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier,
    )
}

@Composable
fun Title(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = modifier
            .padding(16.dp)
    )
}

@Composable
fun Content(content: String, modifier: Modifier = Modifier) {
    Text(
        text = content,
        textAlign = TextAlign.Start,
        modifier = modifier
    )
}

@Composable
fun TaskCompleted() {
    val image = painterResource(R.drawable.ic_task_completed)
    ContentImage(image)
}

@Composable
fun TextBold(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Article"
)
@Composable
fun ArticlePreview() {
    JuaraAndroidTheme {
        Article()
    }
}