<<<<<<< HEAD
This is a sample app to get latest and mostly viewed post from "The New York Times News Paper". I Used
Retrofit to make HTTP request, with RXJava, and Live data Observer. Also use data binding to bind views with class.
MVVM coding structure used in this project and DataBinding to bind data with view.
NewFeedsRepositoryTest class used to run test with MockWebServer.
To run the test right click on the test class and select run with coverage.
@Test
    fun `authentication sends proper body`(){
        server.apply{
            enqueue(MockResponse().setBody(MockResponseFileReader("test.json").content))
        }

        startKoin(listOf(module {
            single { NewFeedsRepository() }
        }))
        get<NewFeedsRepository>().apply {
            authenticateBlocking()
        }
        val testBody = NyNewsFeedBaseModel()

        val requestBody = server.takeRequest().body.readUtf8()

        val json = JsonParser().parse(requestBody).asJsonObject
        assertEquals(json.get("status").toString().replace("\"",""), testBody.copyright)
    }
=======
# NYMauqah

>>>>>>> e191d460fd0ad78f9dd0856e1a3b228e2b372ed1
