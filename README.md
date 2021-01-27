# Thread
## Samples
### Simple Thread

```java
Thread {
	//do actions
}.start()
```
### Thread With UI actions
```java
Thread {
	//do actions
	this.activity?.runOnUiThread(){
        //does actions on Ui-Thread u neeed it because Ui-elements can only be edited in Main/Ui-Thread
        }
}.start()
```
# Corona Api
## Get ALL Locations
```java
var reque = URL("https://services7.arcgis.com/mOBPykOjAyBO2ZKk/arcgis/rest/services/RKI_Landkreisdaten/FeatureServer/0/query?where=1=1&outFields=GEN&returnGeometry=false&f=json") //request url
val conn: HttpURLConnection = reque.openConnection() as HttpURLConnection // create a connection
val data = conn.inputStream.bufferedReader().use(BufferedReader::readText) //read recevied bytes from request


 //loop at all objects in features
 val field = JSONObject(data).getJSONArray("features") // get object features in json
 for (i in 0..(field.length()-1)) {
     val attr = field.getJSONObject(i)   // get object of features at position i
     val ele = attr.getJSONObject("attributes") // get attribute of object
     val cases = ele.getString("GEN")    // get Gen .... Gen has the location Name
     locations.add(cases)    //add location name to list
 }

```

## Get Cases per 100k the last 7 days at a location

```java

var reque = URL("https://services7.arcgis.com/mOBPykOjAyBO2ZKk/arcgis/rest/services/RKI_Landkreisdaten/FeatureServer/0/query?where=GEN='${location}'&outFields=cases7_per_100k_txt&returnGeometry=false&f=json") //create url for location in autotext

val conn: HttpURLConnection = reque.openConnection() as HttpURLConnection //connect to url

val json = conn.inputStream.bufferedReader().use(BufferedReader::readText) //read response
val field = JSONObject(json).getJSONArray("features")       // get feature object
val attr = field.getJSONObject(0)       //only one feature so no loop needed
val ele = attr.getJSONObject("attributes")  // get attributes of object
val cases = ele.getString("cases7_per_100k_txt") // get cases

```


# Service
### Android Manifest
```java

    <uses-permission android:name="android.permission.INTERNET"></uses-permission>
    <uses-permission android:name="android.permission.FOREGROUND_SERVICE"/>
	  <service
            android:name=".ui.myservices.MyService"
            android:enabled="true"
            android:exported="false"></service>
```

### App Gradle
```java

    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9'
    
```
## Forground Service
### Intetent 
```java
 val startIntent =Intent(this.context,MyService::class.java)

```

### Erstellen des Fordergrund Services
```java
	ContextCompat.startForegroundService(root.context,startIntent)
```

### Benachrichtigen des Users das ein Fordergrund Service gestartet wurde
```java
 startForeground(ID, notification)
```

## Background Service

### Intent
```java
      val startIntent =Intent(this.context,MyService::class.java)
```

### Starten des Background Services
```java
  ContextCompat.startForegroundService(root.context,startIntent)
```

##Verbindung zum Server
```java
	//IP-Adresse des Servers in unserem Fall die des eigenen Geräts
        private val SERVER = "t45xvxe1amipu7ef.myfritz.net"

        //Port auf welchem der Server lauscht
        private const val PORT = 8888
```

## Coroutine zum Verbinden mit dem Server
 ```java

 CoroutineScope(Dispatchers.IO).launch {
        CoroutineScope(Dispatchers.IO).launch {
            val mRun = true;
            var charsRead = 0
            var buffer = CharArray(BUFFERSIZE)
            Log.e("TCP Client", "C: Connecting...");
          //Erstellen des Socket mit der im Companion Objekt angelegten IP und dem Port
            val socket = Socket(SERVER, PORT);
            while (mRun) {
                //Einlesen der gesendeten Daten vom C TCP-Server
                val mBufferIn = BufferedReader(InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

                charsRead = mBufferIn.read(buffer)
                if(charsRead<0) continue
                //Umwandeln der empfangenen Daten in einen String
                val mServerMessage: String? = String(buffer).substring(0, charsRead)
                buffer= CharArray(BUFFERSIZE)
                if (mServerMessage != null)
                    CoroutineScope(Dispatchers.IO).launch {
                        //Ausführen der Notification das ein Helfer gefunden wurde, mit übergabe des Namens
                        shownote(mServerMessage)
                        Log.i("connectserver", mServerMessage)
                    }

            }

        }
```

## User Benachrichtigung das ein Helfer gefunden wurde
```java
notify(ID, builder.build()
ID++
```

# WorkManager
### Lateint Variable workmanager
```java
lateinit var workmanager :WorkManager
```
### Constraints der das Laden der Batterie benötigt
``` java
val constraints= Constraints.Builder().setRequiresCharging(true).build()
```
## OneTimeRequest
```java
val request= OneTimeWorkRequestBuilder<WorkOneTimeRequest>().build()
```
## PeriodicalWorkRequest
```java
val request2= PeriodicWorkRequestBuilder<WorkPeriodical>(15,TimeUnit.MINUTES).build()
```
## Instance des WorkManagers erstellen
```java
workmanager=WorkManager.getInstance(root.context)
```
## Request in Warteschlange hinzufügen
```java
workmanager.enqueue(request)
```
 ## Cancel Work Manager
 ```java
workmanager.cancelAllWork()
 ```

