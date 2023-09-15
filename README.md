# RETROFIT LIBRARY IN ANDROID
The Retrofit library is a type-safe REST client for Android, Java, and Kotlin, developed by Square. With the help of the Retrofit library, we can have access to a powerful framework that helps us in authenticating and interacting with APIs and sending network requests with OkHttp. With the help of this library, downloading JSON or XML data from a web API becomes easy. In a Retrofit library, once the data is downloaded, it is parsed into a Plain Old Java Object (POJO) which must be defined for each “resource” in the response. Retrofit is an easy and fast library to retrieve and upload data via a REST-based web service.

Retrofit manages the process of receiving, sending, and creating HTTP requests and responses. It resolves issues before sending an error and crashing the application. It pools connections to reduce latency. It is used to cache responses to avoid sending duplicate requests

![image](https://github.com/oybekjon94/RetrofitGsonPaging/assets/91370134/fa066a10-8389-4a0d-9482-45414c6309e2)

## FEATURES OF RETROFIT
Retrofit is very fast.
Retrofit enables direct communication with the web service.
Retrofit supports dynamic URLs.
Retrofit is easy to use and understand.
Retrofit supports both synchronous and asynchronous network requests.
Retrofit supports converters.
Retrofit supports request cancellation.
Retrofit supports post requests and multipart uploads.

## DISADVANTAGES OF RETROFIT
Retrofit does not support setting priorities.
Retrofit does not support image loading.
Retrofit requires other libraries such as Glide and Picasso.

## CLASSES USED IN RETROFIT
Model Class: A model class contains the objects to be obtained from the JSON file.
Retrofit Instance: This is a Java class. It is used to send requests to an API.
Interface Class: This is a Java class. It is used to define endpoints.

# Gson
Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object. Gson can work with arbitrary Java objects including pre-existing objects that you do not have source-code of.
There are a few open-source projects that can convert Java objects to JSON. However, most of them require that you place Java annotations in your classes; something that you can not do if you do not have access to the source-code. Most also do not fully support the use of Java Generics. Gson considers both of these as very important design goals.
ℹ️ Gson is currently in maintenance mode; existing bugs will be fixed, but large new features will likely not be added. If you want to add a new feature, please first search for existing GitHub issues, or create a new one to discuss the feature and get feedback.

# Paging 
The Paging Library helps you load and display small chunks of data at a time. Loading partial data on demand reduces usage of network bandwidth and system resources.
![image](https://github.com/oybekjon94/RetrofitGsonPaging/assets/91370134/84ff2bfe-5108-4b80-897b-cf6f7c79acc9)
## Support different data architectures
### The Paging Library supports the following data architectures:
Served only from a backend server.
Stored only in an on-device database.
A combination of the other sources, using the on-device database as a cache.
![image](https://github.com/oybekjon94/RetrofitGsonPaging/assets/91370134/fcfa1ffb-62eb-4177-a0e7-b9b143d316e2)

