package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.material3.MaterialTheme as MaterialTheme1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme1.colorScheme.background,
                )
                {
                    LemonApp()
                }
            }
        }
    }
}

@Composable
fun LemonApp() {

    var currentIndex by remember { mutableIntStateOf(1) }

    val imageResource = when (currentIndex) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_squeeze
        4 -> R.drawable.lemon_squeeze
        5 -> R.drawable.lemon_drink
        6 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    val textResource = when (currentIndex) {
        1 -> R.string.lemon_tree_description
        2 -> R.string.squeeze_description
        3 -> R.string.squeeze_description
        4 -> R.string.squeeze_description
        5 ->  R.string.glass_of_lemonade_description
        6 ->  R.string.empty_glass_description
        else -> R.string.lemon_tree_description
    }

    Column(modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Box (
            modifier = Modifier
                .size(280.dp)
                .padding(16.dp)
                .background(
                    color = colorResource(R.color.background),
                    shape = RoundedCornerShape(40.dp)
                )
                .clickable{
                    currentIndex = (currentIndex + 1)
                    if(currentIndex > 6){
                        currentIndex = 1
                    }else if(currentIndex == 2){
                        currentIndex = (2..4).random()
                    }
                }
        ){
            Image(
                painter = painterResource(imageResource),
                contentDescription = currentIndex.toString(),
                modifier = Modifier.fillMaxSize().padding(16.dp)
            )
        }
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = stringResource(textResource),
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonAppPreview() {
    LemonadeTheme {
        LemonApp()
    }
}