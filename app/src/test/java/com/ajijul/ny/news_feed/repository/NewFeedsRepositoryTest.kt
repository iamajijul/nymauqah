package com.ajijul.ny.news_feed.repository

import com.ajijul.ny.gateway.HttpClient
import com.ajijul.ny.gateway.network.NyApiEndPoint
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import com.google.gson.JsonParser
import io.reactivex.schedulers.Schedulers.single
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.junit.Before
import org.junit.Test
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.get
import org.koin.test.KoinTest


class NewFeedsRepositoryTest : KoinTest {
    lateinit var server : MockWebServer

    @Before
    fun initTest(){
        server = MockWebServer()
    }

    @After
    fun shutdown(){
        server.shutdown()
    }

    @Test
    fun `authentication sends proper body`(){
        server.apply{
            enqueue(MockResponse().setBody(MockResponseFileReader("test.json").content))
        }

        startKoin(listOf(module {
            single { NewFeedsRepository(null) }
        }))
        get<NewFeedsRepository>().apply {
            authenticateBlocking()
        }
        val testBody = NyNewsFeedBaseModel()

        val requestBody = server.takeRequest().body.readUtf8()

        val json = JsonParser().parse(requestBody).asJsonObject
        assertEquals(json.get("status").toString().replace("\"",""), testBody.copyright)
    }
}