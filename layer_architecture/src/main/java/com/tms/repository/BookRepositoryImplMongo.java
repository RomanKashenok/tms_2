package com.tms.repository;

import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.util.JSON;
import com.tms.model.Book;

public class BookRepositoryImplMongo implements BookRepository {

    MongoClient mongo;
    DB db;
    DBCollection table;

    public BookRepositoryImplMongo() {
        mongo = new MongoClient( "localhost" , 27017 );
        db = mongo.getDB("exampledb");
        table = db.getCollection("books");
    }

    @Override
    public Book getBook(Long id) {
        Book book = null;
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("id", id);

        DBCursor cursor = table.find(searchQuery);

        while (cursor.hasNext()) {
            DBObject dbobj = cursor.next();
            book = (new Gson()).fromJson(dbobj.toString(), Book.class);
        }
        return book;
    }

    @Override
    public void addBook(Book book) {
        Gson gson = new Gson();
        BasicDBObject obj = (BasicDBObject) JSON.parse(gson.toJson(book));
        table.insert(obj);
    }
}
