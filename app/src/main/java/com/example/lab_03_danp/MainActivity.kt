package com.example.lab_03_danp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.lab_03_danp.navigation.MainFlow
import com.example.lab_03_danp.screens.viewModel.AppViewModel
import com.example.lab_03_danp.ui.theme.Lab_03_DANPTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("CoroutineCreationDuringComposition")

    private lateinit var viewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab_03_DANPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    viewModel = ViewModelProvider(this)[com.example.lab_03_danp.screens.viewModel.AppViewModel::class.java]
                    MainFlow(viewModel)
                }
            }
        }
    }
}
