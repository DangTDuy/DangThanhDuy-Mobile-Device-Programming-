package com.example.th_tuan_5


import android.os.Bundle
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.*
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.auth.api.identity.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var oneTapClient: SignInClient
    private lateinit var signInRequest: BeginSignInRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()

        oneTapClient = Identity.getSignInClient(this)
        signInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId("YOUR_WEB_CLIENT_ID") // 🔥 Thay "YOUR_WEB_CLIENT_ID" bằng Web Client ID từ Firebase
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            )
            .setAutoSelectEnabled(true)
            .build()

        val signInLauncher = registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                try {
                    val credential = oneTapClient.getSignInCredentialFromIntent(result.data)
                    val idToken = credential.googleIdToken
                    if (idToken != null) {
                        val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
                        auth.signInWithCredential(firebaseCredential)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val user = auth.currentUser
                                    Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show()
                                    setContent { ManHinhHienThi(user?.email ?: "Unknown") }
                                } else {
                                    setContent { ManHinhLoi("Lỗi đăng nhập!") }
                                }
                            }
                    }
                } catch (e: Exception) {
                    setContent { ManHinhLoi("Lỗi: ${e.message}") }
                }
            } else {
                setContent { ManHinhLoi("User canceled the Google sign-in process.") }
            }
        }

        setContent {
            ManHinhDangNhap {
                oneTapClient.beginSignIn(signInRequest)
                    .addOnSuccessListener { result ->
                        signInLauncher.launch(IntentSenderRequest.Builder(result.pendingIntent.intentSender).build())
                    }
                    .addOnFailureListener {
                        setContent { ManHinhLoi("Không thể đăng nhập!") }
                    }
            }
        }
    }
}

@Composable
fun ManHinhDangNhap(onLoginClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onLoginClick,
            colors = ButtonDefaults.buttonColors(Color(0xFF2196F3)),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(text = "Đăng nhập bằng Google", fontSize = 23.sp, color = Color.White)
        }
    }
}

@Composable
fun ManHinhLoi(message: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Lỗi!", fontSize = 20.sp, color = Color.Red)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = message, fontSize = 18.sp, color = Color.Black)
    }
}

@Composable
fun ManHinhHienThi(email: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Chào mừng, $email!", fontSize = 22.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Bạn đã đăng nhập thành công!", fontSize = 18.sp, color = Color.Blue)
    }
}
