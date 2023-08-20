package com.sergio.rodriguez.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sergio.rodriguez.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}


@Composable
fun ArtSpaceApp(
    modifier: Modifier = Modifier
) {

    var currentStep:        Int by remember { mutableStateOf(0) }

    var currentArtWork:     Int by remember { mutableStateOf(R.drawable.denji_face) }
    var title:              Int by remember { mutableStateOf(R.string.denji) }
    var subTitle:           Int by remember { mutableStateOf(R.string.denji_year) }

    Column(
        modifier = modifier.fillMaxWidth().verticalScroll( rememberScrollState() ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        ArtWork(
            currentArtWork = currentArtWork
        )
        Spacer(modifier = Modifier.height(16.dp))
        BodyContent(
            title = title,
            subTitle = subTitle
        )
        ButtonsControl(
            onPreviousClicked = {
                if (currentStep > 0) currentStep -= 1
                when(currentStep) {
                    0 -> {
                        currentArtWork = R.drawable.denji_face
                        title = R.string.denji
                        subTitle = R.string.denji_year
                    }
                    1 -> {
                        currentArtWork = R.drawable.naruto_face
                        title = R.string.naruto
                        subTitle = R.string.naruto_year
                    }
                    2 -> {
                        currentArtWork = R.drawable.sanji_face
                        title = R.string.sanji
                        subTitle = R.string.sanji_year
                    }
                    3 -> {
                        currentArtWork = R.drawable.zero_two_face
                        title = R.string.zero_two
                        subTitle = R.string.zero_two_year
                    }
                }
            },
            onNextClicked = {
                if(currentStep < 3) currentStep += 1
                when(currentStep) {
                    0 -> {
                        currentArtWork = R.drawable.denji_face
                        title = R.string.denji
                        subTitle = R.string.denji_year
                    }
                    1 -> {
                        currentArtWork = R.drawable.naruto_face
                        title = R.string.naruto
                        subTitle = R.string.naruto_year
                    }
                    2 -> {
                        currentArtWork = R.drawable.sanji_face
                        title = R.string.sanji
                        subTitle = R.string.sanji_year
                    }
                    3 -> {
                        currentArtWork = R.drawable.zero_two_face
                        title = R.string.zero_two
                        subTitle = R.string.zero_two_year
                    }
                }
            }
        )
    }

}

@Composable
fun ArtWork(
    @DrawableRes currentArtWork: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
        shape = RoundedCornerShape(4.dp)
    ){
        Image(
            painter = painterResource(id = currentArtWork),
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(32.dp),
            contentScale = ContentScale.FillWidth
        )
    }

}

@Composable
fun BodyContent(
    @StringRes title: Int,
    @StringRes subTitle: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color(0xFFecebf4)),
    ){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            text = stringResource(id = title),
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraLight
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            text = stringResource(id = subTitle),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun ButtonsControl(
    onPreviousClicked: () -> Unit,
    onNextClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(28.dp),
        horizontalArrangement = Arrangement.SpaceBetween,

    ) {
        Button(
            onClick = {
                onPreviousClicked()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF495d92)
            ),
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(id = R.string.btn_previous))
        }
        Spacer(modifier = Modifier.width(32.dp))
        Button(
            onClick = {
                onNextClicked()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF495d92)
            ),
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(id = R.string.btn_next))
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp(modifier = Modifier.fillMaxSize())
    }
}