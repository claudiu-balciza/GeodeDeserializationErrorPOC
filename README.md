# GeodeDeserializationErrorPOC
this is a proof of error when deserializing in Geode 1.13

I'm getting this error when trying to export a region's data from a geode 1.13 server

Member  | Status | Message
------- | ------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
server1 | ERROR  |  java.io.IOException: org.apache.geode.cache.execute.FunctionException: org.apache.geode.SerializationException: A ClassNotFoundException was thrown while trying to deserialize cached value.


