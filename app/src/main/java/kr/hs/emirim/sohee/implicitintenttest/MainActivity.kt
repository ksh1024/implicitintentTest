package kr.hs.emirim.sohee.implicitintenttest

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnCall:Button
    lateinit var btnHome:Button
    lateinit var btnMap:Button
    lateinit var btnSearch:Button
    lateinit var btnSMS:Button
    lateinit var btnPicture:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "암시적 인텐트 연습"

        btnCall = findViewById(R.id.btnCall)
        btnHome = findViewById(R.id.btnHome)
        btnMap = findViewById(R.id.btnMap)
        btnSearch = findViewById(R.id.btnSearch)
        btnSMS = findViewById(R.id.btnSMS)
        btnPicture = findViewById(R.id.btnPicture)

        btnCall.setOnClickListener{
            var uri = Uri.parse("tel:010-1234-5678")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }//parse : 문자열을 uri로 변환해줌

        btnHome.setOnClickListener{
            var uri = Uri.parse("http://m.naver.com")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }//모바일인 경우 도메인 앞에 'm'을 붙여준다

        btnMap.setOnClickListener{
            var uri = Uri.parse("https://maps.google.com/maps?q="+37.4663507+","+"126.9328951")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnSearch.setOnClickListener{
            var intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY,"미림마이스터고")
            startActivity(intent)
        }

        btnSMS.setOnClickListener{
            var intent = Intent(Intent.ACTION_SENDTO)
            intent.putExtra("sms_body","hello world")
            intent.data = Uri.parse("smsto:"+Uri.encode("01029994444"))
            startActivity(intent)
        }

        btnPicture.setOnClickListener{
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
    }
}