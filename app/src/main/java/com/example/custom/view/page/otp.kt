package com.example.custom.view.page

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.custom.R
import com.example.custom.view.Widget.Toast.CustomToast
import com.example.custom.view.Widget.otp.*
import kotlinx.coroutines.delay
import org.w3c.dom.Text

@Composable
fun Otp(){
    OtpFinal(textList,requestList)
}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OtpBody(
    textList :List<MutableState<TextFieldValue>>,
    requesterList:List<FocusRequester>
){
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current
    var msg = "Code incorrecte"
    Surface(modifier = Modifier
        .fillMaxSize(),
        color = Color.White

    ) {
        Column(){
          Text(fontSize = 16.sp, fontWeight = FontWeight.Bold,modifier = Modifier.width(210.dp),
              text = "Entrez le code de validation",textAlign =  TextAlign.Center)
            Box(modifier = Modifier.fillMaxSize(10f)){
                Row(modifier = Modifier
                    .padding(horizontal =0.dp)
                    .padding(top = 30.dp)

                ) {
                    for(i in textList.indices){
                        InputFieldOtp(value = textList[i].value, onValueChange = {newValue->

                            if(textList[i].value.text != ""){
                                if(newValue.text == ""){
                                    textList[i].value = TextFieldValue(
                                        text = "",
                                        selection = TextRange(0)
                                    )
                                }
                                return@InputFieldOtp
                            }
                            textList[i].value = TextFieldValue(
                                text = newValue.text,
                                selection = TextRange(newValue.text.length)
                            )
                            nextFocus(textList,requesterList)
                            assemblageCode(textList,onVerify={
                                focusManager.clearFocus()
                                keyboardController?.hide()

                                if(it){
                                    msg = "Code correcte"
                                    Log.e("MSG",msg)
                                }
                                //echec
                                Log.e("MSG",msg)
                                for(text in textList){
                                    text.value = TextFieldValue(
                                        text = "",
                                        selection = TextRange(0)
                                    )
                                }
                            })
                        }, focusRequester =requesterList[i] )
                    }
                }

            }
        }

    }
    LaunchedEffect(key1 = null,block={
        delay(300)
        requesterList[0].requestFocus()
    })
}
@Composable
@Preview(showBackground = true)
fun OptPreview(){
    Otp()
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OtpFinal(textList :List<MutableState<TextFieldValue>>,
             requesterList:List<FocusRequester>){
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current
    var msg = "Code incorrecte"
    CustomToast("Elie Oko")
        Column(
            modifier = Modifier.padding(6.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.head),
                contentDescription = "Logo de l'application",
                modifier = Modifier.size(96.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Vérification ",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(){
                Row(modifier = Modifier
                    .padding(horizontal =0.dp)
                    .padding(top = 30.dp)

                ) {
                    for(i in textList.indices){
                        InputFieldOtp(value = textList[i].value, onValueChange = {newValue->

                            if(textList[i].value.text != ""){
                                if(newValue.text == ""){
                                    textList[i].value = TextFieldValue(
                                        text = "",
                                        selection = TextRange(0)
                                    )
                                }
                                return@InputFieldOtp
                            }
                            textList[i].value = TextFieldValue(
                                text = newValue.text,
                                selection = TextRange(newValue.text.length)
                            )
                            nextFocus(textList,requesterList)
                            assemblageCode(textList,onVerify={
                                focusManager.clearFocus()
                                keyboardController?.hide()

                                if(it){
                                    msg = "Code correcte"
                                    Log.e("MSG",msg)
                                }
                                //echec
                                Log.e("MSG",msg)
                                for(text in textList){
                                    text.value = TextFieldValue(
                                        text = "",
                                        selection = TextRange(0)
                                    )
                                }
                            })
                        }, focusRequester =requesterList[i] )
                    }
                }

            }
            Spacer(modifier = Modifier.height(6.dp))
            Button(
                onClick = {},

            ) {
                Text("Valider")
            }
           // Bouton de connexion Google
        }

    LaunchedEffect(key1 = null,block={
        delay(300)
        requesterList[0].requestFocus()
    })
}