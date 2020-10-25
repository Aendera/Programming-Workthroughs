from pymongo import MongoClient

client=MongoClient()
db=client.nobel_prize
coll=db.winners


def get_mongo_database(db_name,host='localhost',port=27017,username=None,password=None):
    """Get named database from MOngoDb with or without authentication"""
    #make Mongo connection
    if username and password:
        mongo_url="mongodb://{}:{}@{}/{}".format(username,password,host,db_name)
        print("Connecting to",mongo_url)
        conn=MongoClient(mongo_url)
    else:
        conn=MongoClient(host,port)
    return conn[db_name]