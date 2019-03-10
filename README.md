# API Challenge

## Dependencies

This project uses Maven for builds.
You need Java 8 installed.

## Building

```
$ mvn package
```

## Running

```
$ java -jar target/api_interview-0.1.0.jar
```

## EndPoints
Each End Point throws exception in case of db errors


```
Get All breeds Enpoint:
GET
http://localhost:8080/dogpics/all

Sample Response:
200 OK
{
"dogs": [
{
"id": "418022ed-2611-4503-a387-09ac874b598e",
"url": "http://i.imgur.com/eE29vX4.png",
"breed": "labrador",
"votes": 0,
"weightlb": null,
"color": null,
"age": null,
"personality": null
},
{
"id": "e49f8efc-7a4e-46b8-a50d-e4dfd4ba4f78",
"url": "http://i.imgur.com/xX2AeDR.png",
"breed": "labrador",
"votes": 0,
"weightlb": null,
"color": null,
"age": null,
"personality": null
}
]
}
```

```
Get specific breed Enpoint: Example Yorkie
GET
http://localhost:8080/dogpics/specificbreed/yorkie

Sample Response:
200 OK
{
"dogs": [
{
"id": "65e66d7d-1441-4080-b09f-d7c7320c951e",
"url": "http://i.imgur.com/oSieVUO.png",
"breed": "yorkie",
"votes": 0,
"weightlb": null,
"color": null,
"age": null,
"personality": null
},
{
"id": "67050256-cf85-4b4f-b61c-817b1e70ddd5",
"url": "http://i.imgur.com/qtXIL.png",
"breed": "yorkie",
"votes": 0,
"weightlb": null,
"color": null,
"age": null,
"personality": null
}]}
```


```
Vote a dog pic Enpoint:
Example: To vote up, pass value true for vote field. picid is id of the picture. You can find it in the database. It Throws an error response if the pic id is invalid
POST
http://localhost:8086/dogpics/vote

BODY:
{
	"picid" :	"45c45788-6b9b-433f-80b5-69207b33dd5f",
	"vote": true
}
Sample Response:
202
{}

Response In case of Error:
{
    "errorcode": 600,
    "errordescription": "Database error"
}

```

```
Vote a dog pic Enpoint:
Example: To vote down, pass value false for vote field. picid is id of the picture. You can find it in the database.Throws an error response if the pic id is invalid
POST
http://localhost:8086/dogpics/vote

BODY:
{
	"picid" :	"45c45788-6b9b-433f-80b5-69207b33dd5f",
	"vote": false
}

Response In case of Error:
{
    "errorcode": 600,
    "errordescription": "Database error"
}

```
