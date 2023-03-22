package com.example.custom.view.page

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.custom.view.Widget.TopBar.CTopBar
import com.example.custom.R
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditProfil(){
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val context = LocalContext.current
    var bitmap by remember {
        mutableStateOf<Bitmap?>(null)
    }
    val launch = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent(), onResult = {
        uri:Uri? ->
        imageUri = uri
    })
    imageUri?.let {
        if(Build.VERSION.SDK_INT <28){
            bitmap =MediaStore.Images.Media.getBitmap(context.contentResolver,it)
        }
        else{
            val source = ImageDecoder.createSource(context.contentResolver,it)
            bitmap= ImageDecoder.decodeBitmap(source)
        }
    }
    Scaffold(topBar={
        CTopBar(title = "Modifier profil")
    } ){
        Column() {
            //Bloc Image
            bitmap?.let {img->
                Image(bitmap =img.asImageBitmap()  , contentDescription = null)
            }
            //Country
            Box(
                modifier = Modifier.size(128.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.head),
                    contentDescription = null,
                    modifier = Modifier
                        .size(128.dp)
                        .clip(CircleShape)
                )
                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = "Camera",
                    tint = Color.White,
                    modifier = Modifier
                        .size(32.dp)
                        .offset(48.dp, 48.dp)
                )
            }
            //Number phone

            //Mail

            //Confirmer
        }
    }
}


