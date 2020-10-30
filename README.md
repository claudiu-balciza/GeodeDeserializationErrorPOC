# GeodeDeserializationErrorPOC
this is a proof of error when deserializing in Geode 1.13

I'm getting this error when trying to export a region's data from a geode 1.13 server

Member  | Status | Message
------- | ------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
server1 | ERROR  |  java.io.IOException: org.apache.geode.cache.execute.FunctionException: org.apache.geode.SerializationException: A ClassNotFoundException was thrown while trying to deserialize cached value.

the command line application populates 3 entries of Class1 objects in the DeserializationErrorPOC region

the region is created as follows:

gfsh> create region --name=DeserializationErrorPOC --type=PARTITION_REDUNDANT_PERSISTENT --recovery-delay=10000 --disk-store=DataPersistence --enable-statistics=true --eviction-action=overflow-to-disk --compressor='org.apache.geode.compression.SnappyCompressor' --redundant-copies=1

gfsh> describe region --name=DeserializationErrorPOC

|-------------------------------------------------
|Name            : DeserializationErrorPOC
|Data Policy     : persistent partition
|Hosting Members : server1
|------------------------------------------------
|Non-Default Attributes Shared By Hosting Members
|
|  Type    |        Name        | Value
|--------- | ------------------ | ---------------------------------------------
|Region    | data-policy        | PERSISTENT_PARTITION
|          | size               | 3
|          | cloning-enabled    | true
|          | disk-store-name    | DataPersistence
|          | statistics-enabled | true
|          | compressor         | org.apache.geode.compression.SnappyCompressor
|Eviction  | eviction-action    | overflow-to-disk
|          | eviction-algorithm | lru-heap-percentage
|Partition | redundant-copies   | 1
|          | recovery-delay     | 10000

the exception is triggered when I attempt:

gfsh> export data --region=DeserializationErrorPOC --file=geode-storage/DeserializationErrorPOC.gfd --member=server1

Also the app throws a "SpringBasedCacheClientApplication: org.apache.geode.SerializationException: While deserializing query result"
when running repository.findAll().forEach((item) -> System.out.println(item.toString()));
