package com.tms;

import com.tms.config.AppConfig;
import com.tms.entity.joined_table.Cat;
import com.tms.entity.joined_table.Dog;
import com.tms.entity.mapped_superclass.Barista;
import com.tms.entity.mapped_superclass.Employee;
import com.tms.entity.mapped_superclass.Person;
import com.tms.entity.single_table.Chocolate;
import com.tms.entity.single_table.MyProduct;
import com.tms.entity.single_table.Shampoo;
import com.tms.entity.table_per_class.Bicycle;
import com.tms.entity.table_per_class.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.Serializable;
import java.nio.channels.ByteChannel;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SessionFactory sessinoFactory = context.getBean(SessionFactory.class);
        Session session = sessinoFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Car mazda = new Car();
        mazda.setModel("mx5");
        mazda.setManufacturer("MAZDA");
        mazda.setVehicleId(1L);

        Bicycle bicycle = new Bicycle();
        bicycle.setWheels(3);
        bicycle.setManufacturer("KROSS");
        bicycle.setVehicleId(2L);


        session.save(mazda);
        session.save(bicycle);
        transaction.commit();
        System.out.println("Application started");

        context.close();
    }
}
