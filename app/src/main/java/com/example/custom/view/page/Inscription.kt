package com.example.custom.view.page

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.custom.R
import com.example.custom.view.Widget.BottomSheet.BottomSheetContent
import com.example.custom.view.Widget.Country.component.TogiCountryCodePicker
import kotlinx.coroutines.launch

@Composable
fun Inscription(){
    InscriptionBody()
}

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun InscriptionBody(){
    val checkedState = remember { mutableStateOf(false) }
    var phone by remember(){
        mutableStateOf("")
    }
    var password by remember(){
        mutableStateOf("")
    }
    var username by remember(){
        mutableStateOf("")
    }
    var isPasswordVisible by remember(){
        mutableStateOf(false)
    }
    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)

    val sheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val scope = rememberCoroutineScope()
    val phoneNumber = rememberSaveable { mutableStateOf("") }
    val isFormValid by derivedStateOf {
        phone.isNotBlank() && password.length > 7
    }

    Scaffold(backgroundColor = Color.White) {
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(8.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.ge), contentDescription ="App Logo" ,
                modifier= Modifier
                    .weight(1f)
                    .size(42.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Spacer(modifier = Modifier.height(8.dp))

                Column(modifier = Modifier
                    .padding(32.dp)){
                    Text(text="Inscription",fontWeight = FontWeight.Bold, color = Color.DarkGray)
                    Column(modifier = Modifier.fillMaxSize(),
                       ){
                        Spacer(modifier = Modifier.weight(1f))
                        TogiCountryCodePicker(
                            text = phoneNumber.value,
                            onValueChange = { phoneNumber.value = it },
                            unfocusedBorderColor = MaterialTheme.colors.primary,
                            bottomStyle =false,
                            shape = RoundedCornerShape(12.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value =username,
                            singleLine = true,
                            onValueChange ={username=it},
                            label ={ Text(text="Nom d'utilisateur") },
                            trailingIcon = {
                                IconButton(onClick = {username}){
                                    Icon(imageVector =  Icons.Filled.Person,contentDescription ="")
                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value =password,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                            visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            onValueChange ={password=it},
                            singleLine = true,
                            label ={ Text(text="Mot de passe") },
                            trailingIcon = {
                                IconButton(onClick = {isPasswordVisible = !isPasswordVisible}){
                                    Icon(imageVector =if(isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,contentDescription ="")

                                }
                            }
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value =password,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                            visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            onValueChange ={password=it},
                            singleLine = true,
                            label ={ Text(text="Confirmer mot de passe") },
                            trailingIcon = {
                                IconButton(onClick = {isPasswordVisible = !isPasswordVisible}){
                                    Icon(imageVector =if(isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,contentDescription ="")

                                }
                            }
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                      Row(){
                          Checkbox(
                              checked = checkedState.value,
                              onCheckedChange = { checkedState.value = it }
                          )
                          Text("J'accepte les termes et conditions")
                          IconButton(onClick = {
                              scope.launch {
                              if(sheetState.isCollapsed){
                              sheetState.expand()
                          }}}){
                              Icon(imageVector =Icons.Default.Edit,contentDescription ="",modifier = Modifier
                                  .size(34.dp))
                          }

                      }

                        Button(
                            onClick={
                                //  navCtrl.navigate(MyRoute.home.name)
                            },
                            enabled = isFormValid,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(26.dp)
                        ){
                            Text(text="CREER")
                        }
                    }
                }
        }
        BottomSheetScaffold(
            scaffoldState = sheetScaffoldState,
            sheetElevation = 0.dp,
            sheetBackgroundColor = Color.Transparent,
            sheetPeekHeight = 99.dp,
            sheetContent = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    IconButton(onClick = {
                        scope.launch {
                            if(sheetState.isCollapsed){
                                sheetState.expand()
                            }
                            else if(sheetState.isExpanded){
                                sheetState.collapse()
                            }
                        }
                    }) {
                        Icon(imageVector = if(sheetState.isExpanded){
                            Icons.Filled.KeyboardArrowDown
                        }
                        else{
                            Icons.Filled.KeyboardArrowUp
                        },
                            contentDescription = "Icon button")
                    }
                    BottomSheetContent()
                }
            }) {
//
        }

    }
}

@Composable
@Preview
fun InscriptionPreview(){
    Inscription()
}