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
        //do actions on ui thread because ui elements can only be edited in Main/Ui thread
        // set Text to cases
                    }
}.start()
```
# Corona Api
## Get ALL Locations
```java
var reque = URL("https://services7.arcgis.com/mOBPykOjAyBO2ZKk/arcgis/rest/services/RKI_Landkreisdaten/FeatureServer/0/query?where=1=1&outFields=GEN&returnGeometry=false&f=json") //request url
val conn: HttpURLConnection = reque.openConnection() as HttpURLConnection // create a connection
val data = conn.inputStream.bufferedReader().use(BufferedReader::readText) //read recevied bytes for request


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





