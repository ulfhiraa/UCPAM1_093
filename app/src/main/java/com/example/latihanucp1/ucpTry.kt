package com.example.latihanucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun mainUCP(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize()
    )
    {
        headerHead()
        inputData()
    }
}

@Composable
fun headerHead(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Blue)
    ) {
        Row {
            Box(contentAlignment = Alignment.BottomEnd) {
                Image(
                    painter = painterResource(id = R.drawable.tae),
                    contentDescription = "",
                    Modifier.size(100.dp).clip(shape = CircleShape)
                )
                Icon(
                    painter = painterResource(id = R.drawable.verif),
                    contentDescription = "",
                    Modifier
                        .padding(end = 13.dp)
                        .size(25.dp),
                   tint = Color.Red
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(Modifier.padding(13.dp))
                Text(
                    text = "Halo,",
                    Modifier.padding(start = 15.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFB58DAC)
                )
                Spacer(Modifier.padding(3.dp))
                Text(
                    text = "Muhammad Adri",
                    Modifier.padding(start = 15.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W500,
                    color = Color(0xFFB58DAC)
                )
            }
        }
    }
}

@Composable
fun inputData(modifier: Modifier = Modifier)
{
    Text(
        text = "Masukan Biodata Kamu!",
        modifier = Modifier.padding(8.dp),
        fontWeight = FontWeight.SemiBold
    )

    Text(
        text = "Silahkan isi data dengan sebenar-benarnya",
        modifier = Modifier.padding(8.dp),
        fontWeight = FontWeight.SemiBold
    )
    Column (Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally)
    {
        Card(
            modifier
            .size(height = 350.dp, width = 360.dp)
            .padding(8.dp),
           // horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var email by rememberSaveable { mutableStateOf("") }
            var noHP by rememberSaveable { mutableStateOf("") }
            var alamat by rememberSaveable { mutableStateOf("") }

            var thMasuk by rememberSaveable { mutableStateOf("") }

            val tahun = listOf("2020", "2021", "2022")


            OutlinedTextField(
                value = email, // nilai
                onValueChange = { email = it }, // ketika data diubah, dia akan muncul disini
                placeholder = { Text("Masukkan Email: ") }, //
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email), //tipe keyboard email
                label = { Text("Email") }, // judulnya
                modifier = Modifier.fillMaxWidth()
                    .padding(5.dp) // untuk mengatur selebar layar dengan padding jarak 5dp
            )

            OutlinedTextField(
                value = noHP, // nilai
                onValueChange = { noHP = it }, // ketika data diubah, dia akan muncul disini
                placeholder = { Text("Masukkan Nomor Telepon: ") }, //
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), //tipe keyboard angka
                label = { Text("Nomor Telephone") }, // judulnya
                modifier = Modifier.fillMaxWidth()
                    .padding(5.dp) // untuk mengatur selebar layar dengan padding jarak 5dp
            )

            OutlinedTextField(
                value = alamat, // nilai
                onValueChange = { alamat = it }, // ketika data diubah, dia akan muncul disini
                placeholder = { Text("Masukkan Alamat: ") }, //
                label = { Text("Alamat") }, // judulnya
                modifier = Modifier.fillMaxWidth()
                    .padding(5.dp) // untuk mengatur selebar layar dengan padding jarak 5dp
            )

            Text(
                text = "Tahun Masuk :",
                modifier = Modifier.padding(vertical = 8.dp),
                fontWeight = FontWeight.SemiBold
            )

            Row {
                tahun.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = thMasuk == item,
                            onClick = { thMasuk = item }
                        )
                        Text(text = item, modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        }

        Button(onClick =  {
        // Button adalah tombol yang, ketika diklik,
        // akan menyimpan nilai-nilai yang dimasukkan ke dalam variabel namaUser, emailUser, alamatUser, noHPUser, dan selectedGenderUser.

        })
        {
            Text("Submit")
        }

        Card(modifier.size(height = 300.dp, width = 300.dp)) {
            bungkus(judulParameter = "Email", isiParameter = "emailUser")
            bungkus(judulParameter = "Alamat", isiParameter = "alamatUser")
            bungkus(judulParameter = "No HP ", isiParameter = "noHPUser")
            /*
            Fungsi CardSection digunakan untuk menampilkan data dalam format kolom dan baris.
            Row di dalam CardSection digunakan untuk menyusun judulParam (misalnya "Nama") dan isiParam (misalnya nama yang dimasukkan pengguna) dalam satu baris.
            Modifier.weight digunakan untuk menentukan proporsi ruang yang diberikan ke setiap elemen dalam baris.
            */
        }
    }
}


@Composable
fun bungkus(judulParameter:String, isiParameter:String) {
    Column (horizontalAlignment = Alignment.Start, modifier = Modifier.padding(8.dp)) {
        // horizontal alignment start untuk memulai tulisan secara horizontal dari kiri ke kanan

        Row (
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = judulParameter, modifier = Modifier.weight(1.2f)) // weight untuk mengatur space isi data
            Text(text = " : ", modifier = Modifier.weight(0.2f))
            Text(
                text = "$isiParameter",
                modifier = Modifier.weight(2f))
        }
    }
}

